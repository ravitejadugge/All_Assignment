package com.service;

import com.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    Order getOrderById(int orderId);
    Order createOrder  (Order order);
    Order updateOrder(Order order);
    Order deleteOrder(int orderId);
}
