package org.example.service;

import org.example.dto.UserDto;
import org.example.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    User save(UserDto user);

    List<User> findAll();

    User findOne(String userName);

}
