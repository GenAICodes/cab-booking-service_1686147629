
CREATE DATABASE cab_service_db;

USE cab_service_db;

CREATE TABLE ride (
    id BIGINT NOT NULL AUTO_INCREMENT,
    pickup_location VARCHAR(255) NOT NULL,
    dropoff_location VARCHAR(255) NOT NULL,
    fare DOUBLE NOT NULL,
    driver_name VARCHAR(255) NOT NULL,
    driver_phone VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ride_review (
    id BIGINT NOT NULL AUTO_INCREMENT,
    ride_id BIGINT NOT NULL,
    rating INT NOT NULL,
    review VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (ride_id) REFERENCES ride(id)
);

CREATE TABLE ride_history (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    ride_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (ride_id) REFERENCES ride(id)
);

CREATE TABLE frequent_location (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    location_name VARCHAR(255) NOT NULL,
    location_address VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
