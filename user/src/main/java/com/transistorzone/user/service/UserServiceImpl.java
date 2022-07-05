package com.transistorzone.user.service;

import com.transistorzone.user.repository.Repository;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public String getUserName(int id) {
        return Repository.users.get(id);
    }
}
