package com.educandoweb.course.services;

import com.educandoweb.course.dto.UserDTO;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepositories;

    @Transactional(readOnly = true)
    public List<UserDTO> findByAll() {
        return userRepositories.findAll().stream().map(UserDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long userId) {
        User user = userRepositories.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
        return new UserDTO(user);
    }

    @Transactional
    public User insert(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepositories.save(user);
    }

    public void delete(Long id) {
        try {
            userRepositories.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    @Transactional
    public User update(Long id, UserDTO userDTO) {
        try {
            User entity = userRepositories.getReferenceById(id); //prepara o objeto monitorado para mexer e só depois efeturar uma operação no BD
            updatData(entity, userDTO);
            return userRepositories.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    private void updatData(User user, UserDTO userDTO) {
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
    }
}
