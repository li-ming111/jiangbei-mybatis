package com.hxx.mapper;

import com.hxx.domain.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> findByIdOrder(int id);
    List<Order> findByIdOrder1(int id);
}
