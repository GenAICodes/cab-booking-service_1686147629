
    package com.cab.ride.service;
    
    import com.cab.ride.model.Ride;
    import com.cab.ride.repository.RideRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    
    import java.util.List;
    
    @Service
    public class RideServiceImpl implements RideService {
        @Autowired
        private RideRepository rideRepository;
        
        @Override
        public Ride createRide(Ride ride) {
            return rideRepository.save(ride);
        }
        
        @Override
        public List<Ride> getAllRidesByUserId(Long userId) {
            return rideRepository.findAllByUserId(userId);
        }
    }
