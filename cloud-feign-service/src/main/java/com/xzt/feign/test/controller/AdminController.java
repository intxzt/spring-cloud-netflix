package com.xzt.feign.test.controller;

import com.xzt.feign.test.beans.User;
import com.xzt.feign.test.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String message) {
        return adminService.sayHi(message);
    }

    @RequestMapping(value = "req_post", method = RequestMethod.GET)
    public String postHi(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User res = adminService.postHi(user);
        if (Objects.isNull(res)) return "request error.";
        return String.format("%s ,welcome! I am from port %s", userName, res.getPort());
    }
}
