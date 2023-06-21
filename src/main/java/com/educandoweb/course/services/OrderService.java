package com.educandoweb.course.services;

import com.educandoweb.course.dto.OrderDTO;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepositories;

    @Transactional(readOnly = true)
    public List<OrderDTO> findByAll() {
        return orderRepositories.findAll().stream().map(OrderDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepositories.findById(id).get();
        return new OrderDTO(order);
    }


}
