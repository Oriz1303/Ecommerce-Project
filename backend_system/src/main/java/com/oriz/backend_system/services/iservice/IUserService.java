package com.oriz.backend_system.services.iservice;

import com.oriz.backend_system.exception.UserException;
import com.oriz.backend_system.model.User;

public interface IUserService {
    public User findUserById(Long userId) throws UserException;
    public User findUserProfileByJwt(String jwt) throws UserException;
}
