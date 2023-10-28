package com.oriz.backend_system.services;

import com.oriz.backend_system.model.OrderItem;
import com.oriz.backend_system.repositories.OrderItemRepository;
import com.oriz.backend_system.services.iservice.IOrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemService implements IOrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
