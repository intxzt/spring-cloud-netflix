package com.xzt.admin.test.controller;

import com.xzt.admin.test.beans.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message) {
        return String.format("Hi，your message is : %s i am from port : %s", message, port);
    }

    @RequestMapping(value = "req_post", method = RequestMethod.POST)
    public User postHi(@RequestBody User user){
        logger.info("userName:{}----password:{}",user.getUserName(),user.getPassword());
        user.setPort(port);
        return user;
    }
}
