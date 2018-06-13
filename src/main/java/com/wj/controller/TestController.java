package com.wj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Value("${manInfo}")
    private String test;

    @GetMapping("/{user}")
    public Long getUser(@PathVariable Long user) {
        return user+111;
    }

    @GetMapping("/test")
    public String deleteUser() {
       return test;
    }
}