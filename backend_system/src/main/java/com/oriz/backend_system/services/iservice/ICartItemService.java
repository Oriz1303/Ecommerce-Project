package com.oriz.backend_system.services.iservice;

import com.oriz.backend_system.exception.CartItemException;
import com.oriz.backend_system.exception.UserException;
import com.oriz.backend_system.model.Cart;
import com.oriz.backend_system.model.CartItem;
import com.oriz.backend_system.model.Product;

public interface ICartItemService {
    public CartItem createCartItem(CartItem cartItem);
    public CartItem updateCartItem(Long userId, Long id, int quantity) throws CartItemException, UserException;
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
    public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
