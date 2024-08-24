package com.roms.authentication.service.service;

import com.roms.authentication.entity.Caregiver;
import com.roms.authentication.entity.User;

import java.util.List;

public interface RegisterService {
    User saveUser(User user);

    public List<User> fetchUserList();

    public User updateUser(Long id, User user);

    public User updateUserByName(String username, User user);

    public User fetchUserByName(String username);

    public Caregiver assignCaregiver(String uname, String cname);
}
