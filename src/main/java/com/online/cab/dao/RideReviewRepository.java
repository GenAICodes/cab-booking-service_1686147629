
package com.online.cab.dao;

import com.online.cab.entity.RideReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideReviewRepository extends JpaRepository<RideReview, Long> {
}
