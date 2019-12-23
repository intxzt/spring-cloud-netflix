package com.xzt.ribbon.test.beans;

public class User {
    private String userName;
    private String password;
    private String port;

    public User() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
