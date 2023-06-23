package com.educandoweb.course.dto;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.Payment;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderDTO {
    private Long id;
    private Instant moment;
    private OrderStatus orderStatus;
    private User client;
    private Set<OrderItem> items;
    private Payment payment;
    private Double total;

    public OrderDTO(Order entity) {
        id = entity.getClient().getId();
        moment = entity.getMoment();
        orderStatus = entity.getOrderStatus();
        client = entity.getClient();
        items = entity.getItems();
        payment = entity.getPayment();
        total = entity.getTotal();
    }
}
