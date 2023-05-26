
    package com.online.cab.controller;
    
    import com.online.cab.model.Ride;
    import com.online.cab.service.RideService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    
    @RestController
    @RequestMapping("/rides")
    public class RideController {
        @Autowired
        private RideService rideService;
    
        @PostMapping
        public ResponseEntity<Ride> bookRide(@RequestBody Ride ride) {
            Ride bookedRide = rideService.bookRide(ride);
            return new ResponseEntity<>(bookedRide, HttpStatus.CREATED);
        }
    
        @GetMapping("/{rideId}/fare")
        public ResponseEntity<Double> estimateFare(@PathVariable Long rideId) {
            Ride ride = rideService.getRide(rideId);
            Double fare = rideService.estimateFare(ride);
            return new ResponseEntity<>(fare, HttpStatus.OK);
        }
    
        @GetMapping("/{rideId}")
        public ResponseEntity<Ride> getRide(@PathVariable Long rideId) {
            Ride ride = rideService.getRide(rideId);
            return new ResponseEntity<>(ride, HttpStatus.OK);
        }
    }
