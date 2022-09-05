package com.example.spring_boot_mvc_project.repository;

import com.example.spring_boot_mvc_project.model.User;

public interface UserRepository  {

    User getUserByUsername(String name);

//    @Query("select u from User u where u.username =: username")
//    User getUserByUsername(@Param("username") String username);

}