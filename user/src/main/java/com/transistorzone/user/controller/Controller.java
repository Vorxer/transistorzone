package com.transistorzone.user.controller;

import com.transistorzone.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping("/userName")
    public String getUserName(@RequestParam int id){
        return userService.getUserName(id);
    }
}
