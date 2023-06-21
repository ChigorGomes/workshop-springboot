package com.educandoweb.course.services;

import com.educandoweb.course.dto.OrderDTO;
import com.educandoweb.course.dto.UserDTO;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepositories orderRepositories;

    @Transactional(readOnly = true)
    public List<OrderDTO> findByAll() {
        return orderRepositories.findAll().stream().map(OrderDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long userId) {
        Order order = orderRepositories.findById(userId).get();
        return new OrderDTO(order);
    }


}
