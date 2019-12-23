package com.xzt.ribbon.test.controller;

import com.xzt.ribbon.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(String message) {
        return adminService.sayHi(message);
    }

    @RequestMapping(value = "req_post", method = RequestMethod.GET)
    public String postHi(String userName, String password) {
        return adminService.postHi(userName, password);
    }
}
