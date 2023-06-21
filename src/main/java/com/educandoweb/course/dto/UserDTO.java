package com.educandoweb.course.dto;

import com.educandoweb.course.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String name;
    private String email;
    private String phone;
    private String password;

    public UserDTO(User entity) {
        name = entity.getName();
        email = entity.getEmail();
        phone = entity.getPhone();
        password = entity.getPassword();
    }
}
