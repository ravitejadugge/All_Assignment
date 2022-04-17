package com.controllers;

import com.models.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class OrderController {
    @Autowired
    @Qualifier("database")
    private OrderService orderService;

    public OrderController(){
    }
    @RequestMapping("/get")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }
    @RequestMapping("/get/{id}")
    public Order getOrderById(@PathVariable("id") int orderId){
        return orderService.getOrderById(orderId);
    }
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order){
        orderService.createOrder(order);
        return order;
    }
    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order){
        orderService.updateOrder(order);
        return order;
    }
    @DeleteMapping("delete/{id}")
    public Order deleteOrder(@PathVariable("id") int orderId){
        Order order = getOrderById(orderId);
        orderService.deleteOrder(orderId);
        return order;
    }
}