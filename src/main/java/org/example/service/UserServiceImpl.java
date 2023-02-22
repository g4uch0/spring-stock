package org.example.service;

import org.example.dto.UserDto;
import org.example.entitys.User;
import org.example.exceptions.EmailAlreadyExistsException;
import org.example.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserServiceImpl implements UserDetailsService, UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("invalid username");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getTypeUser().name()));

        return authorities;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(userList::add);
        return userList;
    }

    @Override
    public User save(UserDto user) {
        User nUser = user.getUserFromDto();
        if (userRepository.existsByEmail(nUser.getUserEmail()))
            throw new EmailAlreadyExistsException("email already exists in database");

        nUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(nUser);
    }

    @Override
    public User findOne(String username) {
        return userRepository.findByUserName(username);
    }
}
