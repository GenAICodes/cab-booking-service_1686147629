
    package com.cab.ride.repository;
    
    import com.cab.ride.model.Ride;
    import org.springframework.data.jpa.repository.JpaRepository;
    
    public interface RideRepository extends JpaRepository<Ride, Long> {
        // Additional methods can be added here
    }
