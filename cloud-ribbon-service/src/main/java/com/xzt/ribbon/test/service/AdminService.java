package com.xzt.ribbon.test.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xzt.ribbon.test.beans.User;
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

    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(String message) {
        return restTemplate.getForObject("http://CLOUD-ADMIN-SERVICE/hi?message=" + message, String.class);
    }

    @HystrixCommand(fallbackMethod = "hiErrorPost")
    public String postHi(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User res = restTemplate.postForObject("http://CLOUD-ADMIN-SERVICE/req_post", user, User.class);
        return String.format("%s ,welcome! I am from port %s", userName, res.getPort());
    }

    public String hiError(String message) {
        return "Hi，your message is :\"" + message + "\" but request error.";
    }
    //参数必须保持一致，否则报错fallback method wasn't found: hiErrorPost([class java.lang.String, class java.lang.String])
    public String hiErrorPost(String userName,String password) {
        return "request error.";
    }
}
