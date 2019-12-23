package com.xzt.feign.test.service;

import com.xzt.feign.test.beans.User;
import org.springframework.stereotype.Component;

@Component
public class AdminHystrix implements AdminService {
    @Override
    public String sayHi(String message) {
        return "Hi，your message is :\"" + message + "\" but request error.";
    }

    @Override
    public User postHi(User user) {
        return null;
    }
}
