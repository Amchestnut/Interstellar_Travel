INSERT INTO CelestialBodies
    (name, type, researched, mean_distance_from_star, lowest_temperature, highest_temperature, oxygen_percentage, other_gas_percentage, gravitational_field_height, orbital_speed) VALUES
                 ('Mercury', 'Planet', 1, 58, 100, 700, 0, 100, 11.6, 47.87),
                 ('Venus', 'Planet', 1, 108, 737, 737, 0, 96, 50.2, 35.02),
                 ('Earth', 'Planet', 1, 151, 184, 330, 21, 78, 9.8, 29.78),
                 ('Mars', 'Planet', 1, 199, 130, 308, 0.13, 95.97, 3.71, 24.07),
                 ('Jupiter', 'Planet', 1, 101, 165, 165, 0, 90, 24.79, 13.07),
                 ('Saturn', 'Planet', 1, 143, 134, 134, 0, 96, 10.44, 9.69),
                 ('Uranus', 'Planet', 1, 287, 76, 76, 0, 83, 8.69, 6.81),
                 ('Neptune', 'Planet', 1, 45, 72, 72, 0, 80, 11.15, 5.43),
                 ('Pluto', 'Planet', 1, 59, 33, 55, 0, 97, 0.62, 4.74),
                 ('Alpha Bb', 'Planet', 1, 60, 1200, 1200, 0, 0, 52.88, 25),
                 ('Zarmina', 'Planet', 1, 21, 240, 300, 5, 80, 7.5, 30),
                 ('Tatooine', 'Planet', 1, 31, 200, 317, 0, 95, 9.0, 20),
                 ('Vulcan', 'Planet', 1, 160, 400, 500, 5, 85, 11.0, 35),
                 ('Pandora', 'Planet', 1, 19, 180, 310, 15, 75, 8.2, 12),
                 ('Krypton', 'Planet', 1, 27, 173, 273, 20, 70, 22.0, 28),
                 ('Coruscant', 'Planet', 1, 35, 220, 300, 21, 79, 12.5, 25),
                 ('Hoth', 'Satellite', 1, 42, 70, 100, 0.1, 99.9, 1.8, 10),
                 ('Nova Terra', 'Planet', 0, 15, 200, 300, 20, 75, 1000, 30),
                 ('Aurora Prime', 'Planet', 0, 18, 220, 340, 22, 70, 1000, 32),
                 ('Caelus', 'Planet', 0, 12, 150, 250, 23, 72, 1000, 25),
                 ('Seraphine', 'Planet', 0, 17, 180, 280, 25, 65, 1000, 29),
                 ('Blue Haven', 'Planet', 0, 20, 210, 330, 18, 77, 1000, 31),
                 ('Gallifrey', 'Planet', 0, 14, 250, 320, 18, 82, 9.7, 15),
                 ('Arrakis', 'Planet', 0, 5, 150, 450, 0.5, 99.5, 12.0, 22),
                 ('Cybertron', 'Planet', 0, 15, 100, 300, 0, 100, 13.0, 17),
                 ('Matejina Utopija', 'Planet', 0, 10, 290, 310, 99, 1, 500, 20),
                 ('Zion', 'Satellite', 0, 21, 190, 290, 20, 75, 1000, 33),
                 ('Elara', 'Planet', 0, 30, 140, 260, 0, 99, 6.5, 19),
                 ('Persephone', 'Planet', 0, 19, 230, 310, 17, 78, 1000, 29),
                 ('Astraea', 'Planet', 1, 180, 160, 260, 20, 70, 1200, 30),
                 ('Nostromo', 'Planet', 0, 18, 195, 315, 21, 74, 1000, 27);



INSERT INTO Missions (celestial_body_id, start_date, end_date)
VALUES
    (18, '2086-06-08', '2087-06-08'),  -- Mission to Nova Terra
    (19, '2098-10-21', '2099-10-21'),  -- Mission to Aurora Prime
    (20, '2100-02-13', '2101-02-13'),  -- Mission to Caelus
    (21, '2127-05-05', '2128-05-05'),  -- Mission to Seraphine
    (22, '2144-12-22', '2145-12-22'),  -- Mission to Blue Haven
    (23, '2149-09-28', '2150-09-28'),  -- Mission to Gallifrey
    (24, '2166-11-16', '2167-11-16'),  -- Mission to Arrakis
    (25, '2171-07-14', '2172-07-14'),  -- Mission to Cybertron
    (26, '2182-03-30', '2183-03-30'),  -- Mission to Matejina Utopija
    (27, '2199-02-02', '2200-02-02');  -- Mission to Zion

INSERT INTO Users (username, password, email, name, surname)
VALUES
    ('john_doe', 'pass1234', 'john.doe@example.com', 'John', 'Doe'),
    ('jane_smith', 'pass5678', 'jane.smith@example.com', 'Jane', 'Smith'),
    ('sam_brown', 'sammy123', 'sam.brown@example.com', 'Samuel', 'Brown'),
    ('lily_evans', 'lilyflower', 'lily.evans@example.com', 'Lily', 'Evans'),
    ('tom_black', 'tommy2024', 'tom.black@example.com', 'Thomas', 'Black'),
    ('sarah_connor', 'terminator', 's.connor@example.com', 'Sarah', 'Connor'),
    ('mark_bolt', 'lightning', 'mark.bolt@example.com', 'Mark', 'Bolt');


INSERT INTO ResidentialBuildings (name, celestial_body_id, capacity, build_date)
VALUES
    ('Colony Alpha', 3, 100, '2075-01-15'), -- Earth
    ('Colony Beta', 17, 50, '2080-03-20'), -- Nova Terra
    ('Colony Gamma', 18, 80, '2085-05-10'), -- Aurora Prime
    ('Colony Delta', 19, 120, '2090-07-25'), -- Caelus
    ('Colony Epsilon', 22, 70, '2095-09-30'), -- Blue Haven
    ('Colony Zeta', 23, 90, '2100-12-05'); -- Gallifrey


INSERT INTO HousingPurchases (user_id, building_id, purchase_date)
VALUES
    (1, 1, '2076-02-01'), -- John Doe at Colony Alpha
    (2, 1, '2076-02-15'), -- Jane Smith at Colony Alpha
    (3, 2, '2081-04-18'), -- Samuel Brown at Colony Beta
    (4, 2, '2081-05-20'), -- Lily Evans at Colony Beta
    (5, 3, '2086-06-25'), -- Thomas Black at Colony Gamma
    (6, 4, '2091-08-30'), -- Sarah Connor at Colony Delta
    (1, 5, '2096-10-12'), -- John Doe at Colony Epsilon
    (2, 5, '2096-11-01'), -- Jane Smith at Colony Epsilon
    (3, 6, '2101-01-17'), -- Samuel Brown at Colony Zeta
    (4, 6, '2101-02-20'); -- Lily Evans at Colony Zeta


INSERT INTO Journeys (destination_body_id, vehicle_code, departure_date, arrival_date)
VALUES
(18, 'XCV-777', '2124-08-01 10:00:00', '2124-10-01 12:00:00'),  -- Nova Terra (2 month travel)
(19, 'YZT-123', '2125-05-08 15:00:00', '2125-08-08 18:00:00'),  -- Aurora Prime (3 month travel)
(20, 'XCV-777', '2126-08-15 12:30:00', '2126-12-15 15:00:00'),  -- Caelus (4 month travel)
(21, 'YZT-123', '2127-06-22 09:00:00', '2127-09-15 11:00:00'),  -- Seraphine (2.5 month travel)
(22, 'XCV-777', '2128-02-09 18:00:00', '2128-05-25 14:00:00'),  -- Blue Haven (3.5 month travel)
(23, 'ZZT-999', '2129-04-12 07:00:00', '2129-09-12 10:00:00'),  -- Gallifrey (5 month travel)
(24, 'XCV-777', '2130-01-18 16:00:00', '2130-08-18 09:00:00'),  -- Arrakis (7 month travel)
(25, 'YZT-123', '2131-10-26 05:00:00', '2132-04-26 12:00:00'),  -- Cybertron (6 month travel)
(26, 'XCV-777', '2132-07-04 20:00:00', '2132-11-20 17:00:00'),  -- Matejina Utopija (4.5 month travel)
(27, 'YZT-123', '2133-03-15 08:00:00', '2133-05-01 15:00:00');  -- Zion (1.5 month travel)



INSERT INTO Calendar (today) VALUES ('2100-06-04');