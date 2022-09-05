package com.example.spring_boot_mvc_project.service.serviceImpl;

import com.example.spring_boot_mvc_project.model.SecurityUser;
import com.example.spring_boot_mvc_project.model.User;
import com.example.spring_boot_mvc_project.repository.repositoryImpl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Could not found user");
        }
        return new SecurityUser(user);
    }
}