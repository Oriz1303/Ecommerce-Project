package com.oriz.backend_system.services.iservice;

import com.oriz.backend_system.model.OrderItem;

public interface IOrderItemService {
    public OrderItem createOrderItem(OrderItem orderItem);
}
