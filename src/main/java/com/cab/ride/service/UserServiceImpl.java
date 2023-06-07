
    package com.cab.ride.service;
    
    import com.cab.ride.model.User;
    import com.cab.ride.repository.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    
    @Service
    public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepository userRepository;
        
        @Override
        public User createUser(User user) {
            return userRepository.save(user);
        }
        
        @Override
        public User getUserById(Long id) {
            return userRepository.findById(id).orElse(null);
        }
        
        @Override
        public User getUserByEmail(String email) {
            return userRepository.findByEmail(email);
        }
    }
