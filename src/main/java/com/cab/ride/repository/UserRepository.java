
    package com.cab.ride.repository;
    
    import com.cab.ride.model.User;
    import org.springframework.data.jpa.repository.JpaRepository;
    
    public interface UserRepository extends JpaRepository<User, Long> {
        // Additional methods can be added here
    }
