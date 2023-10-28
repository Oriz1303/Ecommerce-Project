package com.oriz.backend_system.services;

import com.oriz.backend_system.exception.CartItemException;
import com.oriz.backend_system.exception.UserException;
import com.oriz.backend_system.model.Cart;
import com.oriz.backend_system.model.CartItem;
import com.oriz.backend_system.model.Product;
import com.oriz.backend_system.model.User;
import com.oriz.backend_system.repositories.CartItemRepository;
import com.oriz.backend_system.repositories.CartRepository;
import com.oriz.backend_system.services.iservice.ICartItemService;
import com.oriz.backend_system.services.iservice.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CartItemService implements ICartItemService {

    private final CartItemRepository cartItemRepository;
    private final IUserService userService;
    private final CartRepository cartRepository;


    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice() * cartItem.getQuantity());

        CartItem createdCartItem = cartItemRepository.save(cartItem);

        return createdCartItem;
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, int quantity) throws CartItemException, UserException {
        CartItem item = findCartItemById(id);
        User user = userService.findUserById(item.getUserId());

        if (user.getId().equals(userId)) {
            item.setQuantity(quantity);
            item.setPrice(item.getQuantity() * item.getProduct().getPrice());
            item.setDiscountedPrice(item.getProduct().getDiscountedPrice() * item.getQuantity());
        } else {
            throw new UserException("u cant remove another users item");
        }
//        cartRepository.save();
        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        CartItem cartItem = cartItemRepository.isCartItemExist(cart, product, size, userId);
        return cartItem;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
        CartItem cartItem = findCartItemById(cartItemId);
        User user = userService.findUserById(cartItem.getUserId());
        User requestUser = userService.findUserById(userId);
        if (user.getId().equals(requestUser.getId())) {
            cartItemRepository.deleteById(cartItemId);
        } else {
            throw new UserException("u cant remove another users item");
        }
    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        Optional<CartItem> op = cartItemRepository.findById(cartItemId);
        if (op.isPresent()) {
            return op.get();
        }
        throw new CartItemException("cart item not found with id" + cartItemId);
    }
}
