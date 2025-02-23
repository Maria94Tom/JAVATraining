package com.employee.services;

import com.employee.repo.User;
import com.employee.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceimpl implements UserService {
    private UserRepo userRepo;
    @Autowired
    public UserServiceimpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void addUserEntity(User userEntity) {
        userRepo.save(userEntity);

    }
}
