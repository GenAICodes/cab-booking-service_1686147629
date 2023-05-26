
package com.online.cab.dao;

import com.online.cab.entity.RideReview;

public interface RideReviewDao {
    RideReview save(RideReview rideReview);
    RideReview update(RideReview rideReview);
    RideReview findById(Long id);
}
