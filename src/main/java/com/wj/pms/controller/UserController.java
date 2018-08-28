package com.wj.pms.controller;

import com.wj.pms.common.Result;
import com.wj.pms.common.enums.BaseResponseCodeEnum;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;
import com.wj.pms.common.exception.BusinessException;
import com.wj.pms.mybatis.entity.User;
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
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result registerUser(@RequestBody User user) throws BusinessException {
        userService.registerUser(user);
        return Result.success();
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public Result currentUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            User user1 = new User();
            user1.setId(user.getId());
            user1.setCode(user.getCode());
            user1.setDisplayName(user.getDisplayName());
            return Result.success(user1);
        } else {
            return Result.success(null);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result signIn(@RequestBody User user, HttpSession session, HttpServletRequest request) {
        User enUser = userService.getUserByCode(user.getCode());
        if (enUser == null) {
            return Result.fail(BusinessResponseCodeEnum.USER_NOT_EXISTED, null);
        }
        if (!user.getPassword().equals(enUser.getPassword())) {
            return Result.fail(BusinessResponseCodeEnum.SECERT_INVALID, null);
        }
        session.setAttribute("user", enUser);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getCode(), user.getPassword());
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication auth = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
        User user1 = new User();
        user1.setId(enUser.getId());
        user1.setCode(enUser.getCode());
        user1.setDisplayName(enUser.getDisplayName());
//        LogUtil.log(uors,new Date(), false, new Date(), LogUtil.LOGTYPE.LOGIN.name(), "登录：" + user.getDisplayName(), "", "", session);
        return Result.success(user1);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result signOut(@RequestBody Map<String, Object> jsonObject, HttpSession session, HttpServletResponse response) {
        User user = (User) session.getAttribute("user");
        session.removeAttribute("user");
//        LogUtil.log(uors,new Date(), false, new Date(), LogUtil.LOGTYPE.LOGIN.name(), "登出：" + user.getDisplayName(), "", "", session);
        return Result.buildResponse(response, null, BaseResponseCodeEnum.SUCCESS.getCode(), "logout success", null);
    }
}