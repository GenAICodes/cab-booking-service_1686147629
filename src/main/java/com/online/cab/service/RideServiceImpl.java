
package com.online.cab.service;

import com.online.cab.model.Ride;
import com.online.cab.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {
    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

    @Autowired
    private RideRepository rideRepository;

    @Override
    public Ride bookRide(Ride ride) {
        return rideRepository.save(ride);
    }

    @Override
    public Double estimateFare(Ride ride) {
        Double distance = calculateDistance(ride.getPickupLocation(), ride.getDropoffLocation());
        return distance * 1.0;
    }

    @Override
    public Ride getRide(Long rideId) {
        return rideRepository.findById(rideId).orElse(null);
    }

    private Double calculateDistance(String pickupLocation, String dropoffLocation) {
        String[] pickupCoords = pickupLocation.split(",");
        String[] dropoffCoords = dropoffLocation.split(",");
        Double lat1 = Double.parseDouble(pickupCoords[0]);
        Double lon1 = Double.parseDouble(pickupCoords[1]);
        Double lat2 = Double.parseDouble(dropoffCoords[0]);
        Double lon2 = Double.parseDouble(dropoffCoords[1]);
        Double dLat = Math.toRadians(lat2 - lat1);
        Double dLon = Math.toRadians(lon2 - lon1);
        Double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double distance = EARTH_RADIUS * c;
        return distance;
    }
}
