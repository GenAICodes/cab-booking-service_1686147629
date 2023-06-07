
    CREATE DATABASE user_management_db;
    USE user_management_db;
    
    CREATE TABLE users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL UNIQUE,
        password VARCHAR(255) NOT NULL,
        phone_number VARCHAR(20) NOT NULL,
        is_verified BOOLEAN DEFAULT false,
        reward_points INT DEFAULT 0
    );
    
    CREATE TABLE rides (
        id INT AUTO_INCREMENT PRIMARY KEY,
        user_id INT NOT NULL,
        start_location VARCHAR(255) NOT NULL,
        end_location VARCHAR(255) NOT NULL,
        distance FLOAT NOT NULL,
        fare FLOAT NOT NULL,
        FOREIGN KEY (user_id) REFERENCES users(id)
    );
