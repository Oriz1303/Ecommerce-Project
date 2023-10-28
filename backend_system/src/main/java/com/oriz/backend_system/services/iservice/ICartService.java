package com.oriz.backend_system.services.iservice;

import com.oriz.backend_system.exception.ProductException;
import com.oriz.backend_system.model.Cart;
import com.oriz.backend_system.model.User;
import com.oriz.backend_system.requests.AddItemRequest;

public interface ICartService {
    public Cart createCart(User user);
    public String addCartItem(Long userId, AddItemRequest request) throws ProductException;
    public Cart findUserCart(Long userid);
}
