
    package com.cab.ride.controller;
    
    import com.cab.ride.model.Ride;
    import com.cab.ride.service.RideService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    
    import java.util.List;
    
    @RestController
    @RequestMapping("/rides")
    public class RideController {
        @Autowired
        private RideService rideService;
        
        @PostMapping
        public ResponseEntity<Ride> createRide(@RequestBody Ride ride) {
            Ride createdRide = rideService.createRide(ride);
            return new ResponseEntity<>(createdRide, HttpStatus.CREATED);
        }
        
        @GetMapping("/{userId}")
        public ResponseEntity<List<Ride>> getAllRidesByUserId(@PathVariable Long userId) {
            List<Ride> rides = rideService.getAllRidesByUserId(userId);
            return new ResponseEntity<>(rides, HttpStatus.OK);
        }
    }
