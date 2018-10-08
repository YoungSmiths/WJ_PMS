package com.wj.pms.controller;

import com.wj.pms.bean.UserBean;
import com.wj.pms.common.Constants;
import com.wj.pms.common.Result;
import com.wj.pms.common.enums.BaseResponseCodeEnum;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;
import com.wj.pms.common.util.SessionUtil;
import com.wj.pms.mybatis.entity.UserInfo;
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
import java.math.BigDecimal;
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
    public Result registerUser(@RequestBody UserInfo user){
        userService.registerUser(user);
        return Result.success();
    }

    @PutMapping(value = "/editUser/{id}")
    @ResponseBody
    public Result updateUser(@PathVariable("id") BigDecimal id, @RequestBody UserInfo user){
        user.setId(id);
        userService.updateUser(user);
        return Result.success();
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public Result currentUser(HttpSession session) {
        UserBean user = (UserBean) session.getAttribute(Constants.SESSION_USER_KEY);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.success(null);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result signIn(@RequestBody UserInfo user, HttpSession session, HttpServletRequest request) {
        UserInfo enUser = userService.getUserByCode(user.getCode());
        if (enUser == null) {
            return Result.fail(BusinessResponseCodeEnum.USER_NOT_EXISTED, null);
        }
        if (!user.getSecret().equals(enUser.getSecret())) {
            return Result.fail(BusinessResponseCodeEnum.SECERT_INVALID, null);
        }

        UserBean userBean = userService.getUserBean(enUser);
        SessionUtil.setAttr(session, Constants.SESSION_USER_KEY, userBean);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getCode(), user.getSecret());
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication auth = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);

        userBean.getUser().setSecret("");
        return Result.success(userBean);
    }

    @GetMapping(value = "/logout")
    @ResponseBody
    public Result signOut(HttpSession session, HttpServletResponse response) {
        session.removeAttribute(Constants.SESSION_USER_KEY);
        return Result.buildResponse(response, null, BaseResponseCodeEnum.SUCCESS.getCode(), "logout success", null);
    }

    @PostMapping("resetSecret")
    @ResponseBody
    public Result resetSecret(HttpSession session, @RequestBody Map<String, String> map){
        String orderSecret = map.get("orderSecret");
        String newSecret = map.get("newSecret");
        userService.resetSecret(session, orderSecret, newSecret);
        return Result.success();
    }

    @DeleteMapping("delete/{id}")
    public Result deleteUser(HttpSession session, @PathVariable("id") BigDecimal id){
        userService.deleteUser(id);
        return Result.success();
    }
}