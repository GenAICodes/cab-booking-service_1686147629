
package com.online.cab.service;

import com.online.cab.model.User;

public interface UserService {
    User registerUser(User user);
    User verifyUser(String email, String password);
    User updateUserRewardPoints(String email, Integer rewardPoints);
}
