package com.test.model;

import java.io.Serializable;

public class User implements Serializable {

    private String loginname;

    private String username;

    private String password;

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
