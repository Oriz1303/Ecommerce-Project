package com.oriz.backend_system.controllers;

import com.oriz.backend_system.exception.CartItemException;
import com.oriz.backend_system.exception.UserException;
import com.oriz.backend_system.model.CartItem;
import com.oriz.backend_system.model.User;
import com.oriz.backend_system.requests.UpdateCartItem;
import com.oriz.backend_system.response.ApiResponse;
import com.oriz.backend_system.services.iservice.ICartItemService;
import com.oriz.backend_system.services.iservice.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_items")
@RequiredArgsConstructor
public class CartItemController {

    private final ICartItemService cartItemService;
    private final IUserService userService;

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItemById(
            @PathVariable Long cartItemId,
            @RequestHeader("Authorization") String jwt) throws CartItemException, UserException {
        User user = userService.findUserProfileByJwt(jwt);
        cartItemService.removeCartItem(user.getId(), cartItemId);
        ApiResponse res = new ApiResponse();
        res.setMessage("item deleted!");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(
            @PathVariable Long cartItemId,
            @RequestBody UpdateCartItem req,
            @RequestHeader("Authorization") String jwt
    ) throws CartItemException, UserException {
        User user = userService.findUserProfileByJwt(jwt);

        cartItemService.updateCartItem(user.getId(), cartItemId, req.getQuantity());

        ApiResponse res = new ApiResponse();
        res.setMessage("Item updated!");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
