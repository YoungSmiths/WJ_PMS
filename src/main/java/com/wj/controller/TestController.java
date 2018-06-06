package com.wj.controller;

import com.wj.bean.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-5-29 下午10:56
 */
@RestController
@RequestMapping(value="/users")
public class TestController {
    @RequestMapping(value="/{user}", method= RequestMethod.GET)
    public Long getUser(@PathVariable Long user) {
        return user+111;
    }

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public User deleteUser() {
       return new User();
    }
}