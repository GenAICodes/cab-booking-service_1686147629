
    package com.cab.ride.controller;
    
    import com.cab.ride.model.User;
    import com.cab.ride.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    
    @RestController
    @RequestMapping("/users")
    public class UserController {
        @Autowired
        private UserService userService;
        
        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }
        
        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable Long id) {
            User user = userService.getUserById(id);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        
        @GetMapping
        public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
            User user = userService.getUserByEmail(email);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }
