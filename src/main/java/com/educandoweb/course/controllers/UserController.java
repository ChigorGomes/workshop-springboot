package com.educandoweb.course.controllers;

import com.educandoweb.course.dto.UserDTO;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> userDTOList = userService.findByAll();
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long userId) {
        UserDTO userDTO = userService.findById(userId);
        return ResponseEntity.ok().body(userDTO);
    }
}
