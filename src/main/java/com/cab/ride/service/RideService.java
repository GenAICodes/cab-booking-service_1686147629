
    package com.cab.ride.service;
    
    import com.cab.ride.model.Ride;
    
    import java.util.List;
    
    public interface RideService {
        Ride createRide(Ride ride);
        List<Ride> getAllRidesByUserId(Long userId);
    }
