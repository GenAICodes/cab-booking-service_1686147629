
    package com.cab.ride.service;
    
    import com.cab.ride.model.User;
    
    public interface UserService {
        User createUser(User user);
        User getUserById(Long id);
        User getUserByEmail(String email);
    }
