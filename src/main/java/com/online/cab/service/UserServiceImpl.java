
package com.online.cab.service;

import com.online.cab.model.User;
import com.online.cab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User verifyUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            user.setIsVerified(true);
            userRepository.save(user);
            return user;
        }
        return null;
    }

    @Override
    public User updateUserRewardPoints(String email, Integer rewardPoints) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setRewardPoints(user.getRewardPoints() + rewardPoints);
            userRepository.save(user);
            return user;
        }
        return null;
    }
}
