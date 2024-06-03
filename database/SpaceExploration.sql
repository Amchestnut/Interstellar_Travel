CREATE DATABASE SpaceExploration;
USE SpaceExploration;

CREATE TABLE CelestialBodies (

                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 name VARCHAR(255) NOT NULL,
                                 type ENUM('Planet', 'Satellite') NOT NULL,
                                 researched BOOLEAN DEFAULT FALSE,
                                 mean_distance_from_star FLOAT,
                                 lowest_temperature FLOAT,
                                 highest_temperature FLOAT,
                                 oxygen_percentage FLOAT,
                                 other_gas_percentage FLOAT,
                                 gravitational_field_height FLOAT,
                                 orbital_speed FLOAT
);

CREATE TABLE Calendar (
                          today DATE
);

CREATE TABLE Missions (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          celestial_body_id INT,
                          start_date DATE,
                          end_date DATE,
                          FOREIGN KEY (celestial_body_id) REFERENCES CelestialBodies(id)
);

CREATE TABLE Journeys (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          destination_body_id INT,
                          vehicle_code VARCHAR(255) NOT NULL,
                          departure_date DATETIME,
                          arrival_date DATETIME,
                          FOREIGN KEY (destination_body_id) REFERENCES CelestialBodies(id)
);

CREATE TABLE Users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       name VARCHAR(255),
                       surname VARCHAR(255)
);

CREATE TABLE JourneysUsers (
                               user_id INT,
                               journey_id INT,
                               FOREIGN KEY (user_id) REFERENCES Users(id),
                               FOREIGN KEY (journey_id) REFERENCES Journeys(id)
);

CREATE TABLE ResidentialBuildings (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
                                      celestial_body_id INT,
                                      capacity INT NOT NULL,
                                      build_date DATE,
                                      FOREIGN KEY (celestial_body_id) REFERENCES CelestialBodies(id)
);

CREATE TABLE HousingPurchases (
                                  id INT AUTO_INCREMENT PRIMARY KEY,
                                  user_id INT,
                                  building_id INT,
                                  purchase_date DATE,
                                  FOREIGN KEY (user_id) REFERENCES Users(id),
                                  FOREIGN KEY (building_id) REFERENCES ResidentialBuildings(id)
);

CREATE TABLE Deaths (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        celestial_body_id INT,
                        user_id INT,
                        death_date DATE,
                        age_at_death INT,
                        FOREIGN KEY (celestial_body_id) REFERENCES CelestialBodies(id),
                        FOREIGN KEY (user_id) REFERENCES Users(id)
);
