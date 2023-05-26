
package com.online.cab.dao;

import com.online.cab.entity.Ride;

public interface RideDao {
    Ride save(Ride ride);
    Ride update(Ride ride);
    Ride findById(Long id);
}
