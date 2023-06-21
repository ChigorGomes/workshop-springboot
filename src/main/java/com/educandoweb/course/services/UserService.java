package com.educandoweb.course.services;

import com.educandoweb.course.dto.UserDTO;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositories userRepositories;

    @Transactional(readOnly = true)
    public List<UserDTO> findByAll() {
        return userRepositories.findAll().stream().map(UserDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long userId) {
        User user = userRepositories.findById(userId).get();
        return new UserDTO(user);
    }
}
