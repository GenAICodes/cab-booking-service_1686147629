
    package com.online.cab.service;
    
    import com.online.cab.model.Ride;
    
    public interface RideService {
        Ride bookRide(Ride ride);
        Double estimateFare(Ride ride);
        Ride getRide(Long rideId);
    }
