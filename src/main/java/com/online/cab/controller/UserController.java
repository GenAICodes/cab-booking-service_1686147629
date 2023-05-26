
package com.online.cab.controller;

import com.online.cab.model.User;
import com.online.cab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/verify")
    public ResponseEntity<User> verifyUser(@RequestParam String email, @RequestParam String password) {
        User verifiedUser = userService.verifyUser(email, password);
        if (verifiedUser != null) {
            return new ResponseEntity<>(verifiedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/reward-points")
    public ResponseEntity<User> updateUserRewardPoints(@RequestParam String email, @RequestParam Integer rewardPoints) {
        User updatedUser = userService.updateUserRewardPoints(email, rewardPoints);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
