package com.employee.services;

import com.employee.repo.User;

public interface UserService {
    public User findByUsername(String username);
    public void addUserEntity(User userEntity);
}
