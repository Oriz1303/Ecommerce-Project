package com.oriz.backend_system.services;

import com.oriz.backend_system.config.JwtProvider;
import com.oriz.backend_system.exception.UserException;
import com.oriz.backend_system.model.User;
import com.oriz.backend_system.repositories.UserRepository;
import com.oriz.backend_system.services.iservice.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;


    @Override
    public User findUserById(Long userId) throws UserException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            return user.get();
        }
        throw new UserException("User not found id: "+ userId);
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {

        String email = jwtProvider.getEmailFromToken(jwt);

        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UserException("User not found with email" + email);
        }
        return user;
    }
}
