package com.wj.pms.controller;

import com.wj.pms.common.exception.PmsException;
import com.wj.pms.common.model.User;
import com.wj.pms.common.utils.Result;
import com.wj.pms.common.LogUtil;
import com.wj.pms.service.UserOperationRecordService;
import com.wj.pms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserOperationRecordService uors;

    @Autowired
    private AuthenticationManager authenticationManager;

    private static final Result ERROR_RESULT = Result.buildFailResult(999999, "server error");

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
        } catch (PmsException e) {
            return Result.fail(e);
        }
        return Result.success();
    }

    @RequestMapping(value = "/register/{userName}", method = RequestMethod.POST)
    @ResponseBody
    public Result isUserUniq(@PathVariable("userName") String userName) {
        if (userService.getUserByName(userName) != null) {
            return Result.buildSuccessResult(true);
        } else {
            return Result.buildFailResult(1002, "user is not exist");
        }
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public Result currentUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return Result.success(new User().setId(user.getId()).setName(user.getName()));
        } else {
            return Result.success(null);
        }
    }

    @RequestMapping(value = "/login_info", method = RequestMethod.GET)
    @ResponseBody
    public Result signIn(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            User data = new User().setId(user.getId()).setName(user.getName());
            return Result.success(data);
        } else {
            session.setAttribute("user", new User());
            return Result.fail("Please login first.");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result signIn(@RequestBody User user, HttpSession session, HttpServletRequest request) {
        User enUser = userService.getUserByName(user.getName());
        if (enUser == null) {
            return Result.buildResult(1002, "Couldn't find the user", null);
        }
        if (!user.getPassword().equals(enUser.getPassword())) {
            return Result.buildResult(1009, "password is invalid", null);
        }
        session.setAttribute("user", enUser);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication auth = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);

        User data = new User().setId(enUser.getId()).setName(enUser.getName());
        LogUtil.log(uors,new Date(), false, new Date(), LogUtil.LOGTYPE.LOGIN.name(), "登录：" + user.getName(), "", "", session);
        return Result.success(data);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result signOut(@RequestBody Map<String, Object> jsonObject, HttpSession session, HttpServletResponse response) {
        User user = (User) session.getAttribute("user");
        session.removeAttribute("user");
        LogUtil.log(uors,new Date(), false, new Date(), LogUtil.LOGTYPE.LOGIN.name(), "登出：" + user.getName(), "", "", session);
        return Result.buildResponse(response, null, 0, "logout success", null);
    }
}

