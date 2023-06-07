
    package com.cab.ride.model;
    
    import javax.persistence.*;
    
    @Entity
    @Table(name = "rides")
    public class Ride {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @Column(name = "user_id")
        private Long userId;
        
        @Column(name = "pickup_location")
        private String pickupLocation;
        
        @Column(name = "dropoff_location")
        private String dropoffLocation;
        
        private Double fare;
        
        private String status;
        
        // Getters and setters
        
        public Long getId() {
            return id;
        }
        
        public void setId(Long id) {
            this.id = id;
        }
        
        public Long getUserId() {
            return userId;
        }
        
        public void setUserId(Long userId) {
            this.userId = userId;
        }
        
        public String getPickupLocation() {
            return pickupLocation;
        }
        
        public void setPickupLocation(String pickupLocation) {
            this.pickupLocation = pickupLocation;
        }
        
        public String getDropoffLocation() {
            return dropoffLocation;
        }
        
        public void setDropoffLocation(String dropoffLocation) {
            this.dropoffLocation = dropoffLocation;
        }
        
        public Double getFare() {
            return fare;
        }
        
        public void setFare(Double fare) {
            this.fare = fare;
        }
        
        public String getStatus() {
            return status;
        }
        
        public void setStatus(String status) {
            this.status = status;
        }
    }
