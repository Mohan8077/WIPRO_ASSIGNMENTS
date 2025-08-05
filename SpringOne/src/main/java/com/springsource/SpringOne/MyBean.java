package com.springsource.SpringOne;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Value("${URL}")
    private String url;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    public void printProperties() {
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
