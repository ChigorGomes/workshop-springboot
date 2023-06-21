package com.educandoweb.course.dto;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderDTO {
    private Long id;
    private Instant moment;
    private User user;

    public OrderDTO(Order entity){
        id = entity.getClient().getId();
        user = entity.getClient();
        moment = entity.getMoment();
    }
}
