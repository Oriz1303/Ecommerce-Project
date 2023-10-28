package com.oriz.backend_system.controllers;

import com.oriz.backend_system.exception.OrderException;
import com.oriz.backend_system.model.Order;
import com.oriz.backend_system.response.ApiResponse;
import com.oriz.backend_system.services.iservice.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {

    @Autowired
    private IOrderService IOrderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrdersHandler() {
        List<Order> orders = IOrderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{orderId}/confirmed")
    public ResponseEntity<Order> confirmedOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws OrderException {
        Order order = IOrderService.confirmedOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/ship")
    public ResponseEntity<Order> shippedOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt
    ) throws OrderException {
        Order order = IOrderService.shippedOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/deliver")
    public ResponseEntity<Order> deliverOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt
    ) throws OrderException {
        Order order = IOrderService.deliveredOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}/delete")
    public ResponseEntity<ApiResponse> deleteOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt
    ) throws OrderException {
        IOrderService.deleteOrder(orderId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Order deleted successfully!");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
