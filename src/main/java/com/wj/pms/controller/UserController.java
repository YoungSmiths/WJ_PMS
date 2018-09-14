package com.wj.pms.controller;

import com.wj.pms.bean.UserBean;
import com.wj.pms.common.Result;
import com.wj.pms.common.enums.BaseResponseCodeEnum;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;
import com.wj.pms.common.exception.BusinessException;
import com.wj.pms.mybatis.entity.User;
import com.wj.pms.mybatis.entity.UserDepartmentRelation;
import com.wj.pms.mybatis.mapper.DepartmentMapper;
import com.wj.pms.mybatis.mapper.UserMapper;
import com.wj.pms.service.PmsService;
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
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PmsService pmsService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result registerUser(@RequestBody User user) throws BusinessException {
        userService.registerUser(user);
        return Result.success();
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public Result currentUser(HttpSession session) {
        UserBean user = (UserBean) session.getAttribute("user");
        if (user != null) {
            return Result.success(user);
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

        UserBean userBean = pmsService.getUserBean(enUser);
        session.setAttribute("user", userBean);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getCode(), user.getPassword());
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication auth = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);


        userBean.getUser().setPassword("");
//        LogUtil.log(uors,new Date(), false, new Date(), LogUtil.LOGTYPE.LOGIN.name(), "登录：" + user.getDisplayName(), "", "", session);
        return Result.success(userBean);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result signOut(@RequestBody Map<String, Object> jsonObject, HttpSession session, HttpServletResponse response) {
        session.removeAttribute("user");
//        LogUtil.log(uors,new Date(), false, new Date(), LogUtil.LOGTYPE.LOGIN.name(), "登出：" + user.getDisplayName(), "", "", session);
        return Result.buildResponse(response, null, BaseResponseCodeEnum.SUCCESS.getCode(), "logout success", null);
    }
}