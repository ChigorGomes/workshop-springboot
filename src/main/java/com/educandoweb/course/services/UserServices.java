package com.educandoweb.course.services;

import com.educandoweb.course.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServices {

    @Autowired
    private UserRepositories userRepositories;


}
