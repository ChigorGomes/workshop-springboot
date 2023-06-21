package com.educandoweb.course.controllers;

import com.educandoweb.course.dto.OrderDTO;
import com.educandoweb.course.dto.UserDTO;
import com.educandoweb.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> userDTOList = orderService.findByAll();
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long userId) {
        OrderDTO OrderDTO = orderService.findById(userId);
        return ResponseEntity.ok().body(OrderDTO);
    }

}
