package com.demo.useraccounts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users/{id}/accounts")
    public List<Account> getAccounts(@PathVariable String id,
                                     @RequestParam String type,
                                     @RequestParam String status) {

        System.out.println("User ID: " + id);
        System.out.println("Account Type: " + type);
        System.out.println("Account Status: " + status);

        return List.of(new Account("Account 1"), new Account("Account 2"));
    }
}
