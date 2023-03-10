package org.example.service;

import org.example.dto.UserDto;
import org.example.entitys.User;

import java.util.List;

public interface UserService {

    User save(UserDto user);

    List<User> findAll();

    User findOne(String userName);

}
