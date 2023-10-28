package com.oriz.backend_system.services.iservice;

import com.oriz.backend_system.exception.OrderException;
import com.oriz.backend_system.model.Address;
import com.oriz.backend_system.model.Order;
import com.oriz.backend_system.model.User;

import java.util.List;

public interface IOrderService {
    public Order createOrder(User user, Address shippingAddress);

    public Order findOrderById(Long orderId) throws OrderException;

    public List<Order> usersOrderHistory(Long userId);

    public Order placedOrder(Long orderId) throws OrderException;

    public Order confirmedOrder(Long orderId) throws OrderException;

    public Order shippedOrder(Long orderId) throws OrderException;

    public Order deliveredOrder(Long orderId) throws OrderException;

    public Order cancelledOrder(Long orderId) throws OrderException;

    public List<Order> getAllOrders();

    public void deleteOrder(Long orderId) throws OrderException;
}
