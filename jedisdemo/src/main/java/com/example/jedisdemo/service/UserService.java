package com.example.jedisdemo.service;

import com.example.jedisdemo.pojo.User;

public interface UserService {
    public User getUser(String usrId);
    public void setUser(User user);
}
