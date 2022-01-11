package com.vico.ZFS.controller;

import com.vico.ZFS.domain.User;
import com.vico.ZFS.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        if (tempEmailId != null && !"".equals(tempEmailId)){
            User user1 = service.findUserByEmailId(tempEmailId);
            if (user1 != null){
                throw new Exception("User with "+tempEmailId+" already exists.!!");
            }
        }
        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        String tempPassword = user.getPassword();
        User userObj = null;
        if (tempEmailId != null && tempPassword != null){
            userObj = service.findUserByEmailIdAndPassword(tempEmailId, tempPassword);
        }
        if (userObj == null){
            throw new Exception("Bad credentials.!!");
        }
        return userObj;
    }
}
