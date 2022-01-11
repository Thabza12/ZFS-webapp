package com.vico.ZFS.service;

import com.vico.ZFS.domain.User;
import com.vico.ZFS.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepo repository;

    public User saveUser(User user){
        return repository.save(user);
    }

    public User findUserByEmailId(String email){
        return repository.findByEmailId(email);
    }

    public User findUserByEmailIdAndPassword(String email, String password){
        return repository.findByEmailIdAndPassword(email, password);
    }

}
