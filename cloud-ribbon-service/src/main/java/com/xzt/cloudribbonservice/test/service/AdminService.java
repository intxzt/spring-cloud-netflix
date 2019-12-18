package com.xzt.cloudribbonservice.test.service;

import com.xzt.cloudribbonservice.test.beans.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    private Logger logger = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    private RestTemplate restTemplate;

    public String sayHi(String message) {
        return restTemplate.getForObject("http://CLOUD-ADMIN-SERVICE/hi?message=" + message, String.class);
    }

    public String postHi(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User res = restTemplate.postForObject("http://CLOUD-ADMIN-SERVICE/req_post", user, User.class);
        return String.format("%s ,welcome! I am from port %s", userName, res.getPort());
    }
}
