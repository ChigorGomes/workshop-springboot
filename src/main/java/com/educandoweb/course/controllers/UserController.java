package com.educandoweb.course.controllers;

import com.educandoweb.course.dto.UserDTO;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping()
    public ResponseEntity<User> insert(@RequestBody UserDTO userDTO) {
        User user = userService.insert(userDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<User> update(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        User user = userService.update(userId, userDTO);
        return ResponseEntity.ok().body(user);
    }
}
