INSERT INTO CelestialBodies
(name, type, researched, mean_distance_from_star, lowest_temperature, highest_temperature, oxygen_percentage, other_gas_percentage, gravitational_field_height, orbital_speed) VALUES
    ('Mercury', 'Planet', 1, 58, 100, 700, 0, 100, 11.6, 47.87),
    ('Venus', 'Planet', 1, 108, 737, 737, 0, 96, 50.2, 35.02),
    ('Earth', 'Planet', 1, 151, 220, 330, 21, 78, 9.8, 29.78),
    ('Mars', 'Planet', 1, 199, 130, 308, 0.13, 95.97, 3.71, 24.07),
    ('Jupiter', 'Planet', 1, 101, 165, 165, 0, 90, 24.79, 13.07),
    ('Saturn', 'Planet', 1, 143, 134, 134, 0, 96, 10.44, 9.69),
    ('Uranus', 'Planet', 1, 287, 76, 76, 0, 83, 8.69, 6.81),
    ('Neptune', 'Planet', 1, 45, 72, 72, 0, 80, 11.15, 5.43),
    ('Pluto', 'Planet', 1, 59, 33, 55, 0, 97, 0.62, 4.74),
    ('Alpha Bb', 'Planet', 1, 160, 200, 300, 20, 75, 1200, 30),
    ('Zarmina', 'Planet', 1, 150, 180, 280, 18, 77, 100, 29),
    ('Tatooine', 'Planet', 1, 120, 160, 280, 19, 76, 100, 28),
    ('Vulcan', 'Planet', 1, 160, 210, 330, 18, 76, 100, 30),
    ('Pandora', 'Planet', 1, 145, 170, 290, 17, 78, 100, 32),
    ('Krypton', 'Planet', 1, 110, 160, 260, 20, 70, 120, 30),
    ('Coruscant', 'Planet', 1, 135, 180, 300, 21, 79, 120, 25),
    ('Nova Terra', 'Planet', 0, 180, 190, 300, 20, 75, 100, 32),
    ('Aurora Prime', 'Planet', 0, 125, 170, 290, 21, 78, 100, 30),
    ('Caelus', 'Planet', 0, 140, 180, 280, 20, 78, 100, 31),
    ('Seraphine', 'Planet', 0, 115, 160, 270, 18, 80, 100, 27),
    ('Blue Haven', 'Planet', 0, 130, 190, 300, 17, 75, 100, 29),
    ('Matejina Utopija', 'Planet', 0, 180, 220, 310, 20, 75, 120, 30),
    ('Elara', 'Planet', 0, 150, 200, 310, 16, 79, 10000, 33),
    ('Persephone', 'Planet', 0, 190, 230, 310, 17, 78, 100, 29),
    ('Astraea', 'Planet', 1, 180, 200, 300, 20, 75, 120, 30),
    ('Nostromo', 'Planet', 0, 195, 205, 315, 21, 74, 1440, 27);



INSERT INTO Missions (celestial_body_id, start_date, end_date)
VALUES
    (1, '2086-06-08', '2087-06-08'),  -- Mission to Nova Terra
    (2, '2098-10-21', '2099-10-21'),  -- Mission to Aurora Prime
    (3, '2100-02-13', '2101-02-13'),  -- Mission to Caelus
    (4, '2127-05-05', '2128-05-05'),  -- Mission to Seraphine
    (5, '2144-12-22', '2145-12-22'),  -- Mission to Blue Haven
    (6, '2149-09-28', '2150-09-28'),  -- Mission to Gallifrey
    (7, '2166-11-16', '2167-11-16'),  -- Mission to Arrakis
    (8, '2171-07-14', '2172-07-14'),  -- Mission to Cybertron
    (9, '2182-03-30', '2183-03-30'),  -- Mission to Matejina Utopija
    (10, '2199-02-02', '2200-02-02');  -- Mission to Zion

INSERT INTO Users (username, password, email, name, surname, date_of_birth)
VALUES
    ('john_doe', 'pass1234', 'john.doe@example.com', 'John', 'Doe', '2152-04-23'),
    ('jane_smith', 'pass5678', 'jane.smith@example.com', 'Jane', 'Smith', '2163-08-15'),
    ('sam_brown', 'sammy123', 'sam.brown@example.com', 'Samuel', 'Brown', '2175-11-30'),
    ('lily_evans', 'lilyflower', 'lily.evans@example.com', 'Lily', 'Evans', '2184-03-09'),
    ('tom_black', 'tommy2024', 'tom.black@example.com', 'Thomas', 'Black', '2158-07-21'),
    ('sarah_connor', 'terminator', 's.connor@example.com', 'Sarah', 'Connor', '2172-12-05'),
    ('mark_bolt', 'lightning', 'mark.bolt@example.com', 'Mark', 'Bolt', '2190-05-17'),
    ('vanja_petrovic', 'vp2020', 'vanja.petrovic@example.com', 'Vanja', 'Petrovic', '2175-05-12'),
    ('milena_pavlovic', 'mp2021', 'milena.pavlovic@example.com', 'Milena', 'Pavlovic', '2182-02-19'),
    ('nikola_jovanovic', 'nj2022', 'nikola.jovanovic@example.com', 'Nikola', 'Jovanovic', '2168-11-07'),
    ('sofija_markovic', 'sm2023', 'sofija.markovic@example.com', 'Sofija', 'Markovic', '2190-08-24'),
    ('filip_popovic', 'fp2024', 'filip.popovic@example.com', 'Filip', 'Popovic', '2185-03-15'),
    ('marija_tomic', 'mt2025', 'marija.tomic@example.com', 'Marija', 'Tomic', '2172-10-21'),
    ('luka_antic', 'la2026', 'luka.antic@example.com', 'Luka', 'Antić', '2163-07-04'),
    ('ana_milic', 'am2027', 'ana.milic@example.com', 'Ana', 'Milić', '2188-09-09'),
    ('petar_nikolic', 'pn2028', 'petar.nikolic@example.com', 'Petar', 'Nikolić', '2170-12-28'),
    ('jovana_ilić', 'ji2029', 'jovana.ilić@example.com', 'Jovana', 'Ilić', '2165-04-17'),
    ('viktor_trajkovic', 'vt2020', 'viktor.trajkovic@example.com', 'Viktor', 'Trajkovic', '2177-02-14'),
    ('miroslava_petrovic', 'mp2021', 'miroslava.petrovic@example.com', 'Miroslava', 'Petrovic', '2184-09-21'),
    ('nikola_milosevic', 'nm2022', 'nikola.milosevic@example.com', 'Nikola', 'Milošević', '2169-04-03'),
    ('sofija_radovanovic', 'sr2023', 'sofija.radovanovic@example.com', 'Sofija', 'Radovanović', '2189-06-18'),
    ('filip_lazic', 'fl2024', 'filip.lazic@example.com', 'Filip', 'Lazić', '2186-01-25'),
    ('marija_jovanovic', 'mj2025', 'marija.jovanovic@example.com', 'Marija', 'Jovanovic', '2173-10-10'),
    ('luka_popovic', 'lp2026', 'luka.popovic@example.com', 'Luka', 'Popovic', '2164-05-19'),
    ('ana_tomic', 'at2027', 'ana.tomic@example.com', 'Ana', 'Tomić', '2180-12-06'),
    ('petar_markovic', 'pm2028', 'petar.markovic@example.com', 'Petar', 'Marković', '2171-07-23'),
    ('jovana_milic', 'jm2029', 'jovana.milic@example.com', 'Jovana', 'Milić', '2166-02-12'),
    ('alex_smith', 'password123', 'alex.smith@example.com', 'Alex', 'Smith', '2157-02-13'),
    ('clara_johnson', 'pass2345', 'clara.johnson@example.com', 'Clara', 'Johnson', '2164-06-06'),
    ('michael_williams', 'michael123', 'michael.williams@example.com', 'Michael', 'Williams', '2172-04-11'),
    ('emily_taylor', 'emily2024', 'emily.taylor@example.com', 'Emily', 'Taylor', '2181-01-18'),
    ('david_carter', 'david1234', 'david.carter@example.com', 'David', 'Carter', '2159-09-24'),
    ('rachel_walker', 'rachel2025', 'rachel.walker@example.com', 'Rachel', 'Walker', '2174-03-07'),
    ('steven_garcia', 'steven123', 'steven.garcia@example.com', 'Steven', 'Garcia', '2186-12-19'),
    ('maria_sanchez', 'maria2026', 'maria.sanchez@example.com', 'Maria', 'Sanchez', '2176-11-08'),
    ('jose_martinez', 'jose1234', 'jose.martinez@example.com', 'Jose', 'Martinez', '2167-10-25'),
    ('ana_lopez', 'ana2027', 'ana.lopez@example.com', 'Ana', 'Lopez', '2183-08-22'),
    ('pedro_gomez', 'pedro123', 'pedro.gomez@example.com', 'Pedro', 'Gomez', '2158-07-16'),
    ('isabel_hernandez', 'isabel2028', 'isabel.hernandez@example.com', 'Isabel', 'Hernandez', '2175-05-09'),
    ('carlos_rodriguez', 'carlos1234', 'carlos.rodriguez@example.com', 'Carlos', 'Rodriguez', '2166-04-02'),
    ('andrea_garcia', 'andrea2029', 'andrea.garcia@example.com', 'Andrea', 'Garcia', '2182-02-15'),
    ('manuel_sanchez', 'manuel123', 'manuel.sanchez@example.com', 'Manuel', 'Sanchez', '2159-11-28'),
    ('carolina_martinez', 'carolina2024', 'carolina.martinez@example.com', 'Carolina', 'Martinez', '2176-10-11'),
    ('jorge_lopez', 'jorge1234', 'jorge.lopez@example.com', 'Jorge', 'Lopez', '2167-09-20'),
    ('laura_gomez', 'laura2025', 'laura.gomez@example.com', 'Laura', 'Gomez', '2184-07-13'),
    ('diego_hernandez', 'diego123', 'diego.hernandez@example.com', 'Diego', 'Hernandez', '2161-06-05'),
    ('alejandra_rodriguez', 'alejandra2026', 'alejandra.rodriguez@example.com', 'Alejandra', 'Rodriguez', '2178-05-08'),
    ('luis_garcia', 'luis1234', 'luis.garcia@example.com', 'Luis', 'Garcia', '2163-04-01'),
    ('paola_sanchez', 'paola2027', 'paola.sanchez@example.com', 'Paola', 'Sanchez', '2180-02-14'),
    ('ricardo_martinez', 'ricardo123', 'ricardo.martinez@example.com', 'Ricardo', 'Martinez', '2155-11-27'),
    ('celestial_explorer', 'deepsky2042', 'celestial.explorer@voyager.net', 'Celestial', 'Explorer', '2193-09-08'),
    ('nova.horizon', 'nebulawanderer', 'nova.horizon@galactic.org', 'Nova', 'Horizon', '2179-03-27'),
    ('cosmic.navigator', 'astraljourney', 'cosmic.navigator@exploration.gov', 'Cosmic', 'Navigator', '2162-11-15'),
    ('starlight.pioneer', 'blazingskies', 'starlight.pioneer@pioneer.com', 'Starlight', 'Pioneer', '2190-08-04'),
    ('astral.seeker', 'nebulaexplorer', 'astral2.seeker@exploration.net', 'Astral', 'Seeker', '2187-05-22');


INSERT INTO ResidentialBuildings (name, celestial_body_id, capacity, build_date)
VALUES
    ('Colony One', 1, 5, '2175-01-01'),  -- Mercury
    ('Colony Two', 1, 8, '2180-06-15'),  -- Mercury
    ('Haven Alpha', 2, 12, '2180-01-15'),  -- Venus
    ('Haven Beta', 2, 15, '2185-08-20'),  -- Venus
    ('Terra Prime', 3, 20, '2180-01-15'),  -- Earth
    ('Colony Alpha', 3, 10, '2180-01-15'), -- Earth
    ('Terra Nova', 3, 25, '2185-03-20'),  -- Earth
    ('Red Haven', 4, 10, '2190-04-10'),  -- Mars
    ('Dust Colony', 4, 8, '2195-07-25'),  -- Mars
    ('Jupiter Base', 5, 30, '2198-02-22'),  -- Jupiter
    ('Saturn Ring', 6, 25, '2198-05-30'),  -- Saturn
    ('Uranus Outpost', 7, 5, '2198-11-15'),  -- Uranus
    ('Neptune Retreat', 8, 7, '2198-01-25'),  -- Neptune
    ('Pluto Camp', 9, 3, '2198-10-30'),  -- Pluto
    ('Alpha Station', 10, 18, '2198-01-01'),  -- Alpha Bb
    ('Alpha bb home deluxe extra', 10, 24, '2198-01-01'),  -- Alpha Bb
    ('Alpha i omega', 10, 6, '2198-01-01'),  -- Alpha Bb
    ('Zarmina Colony', 11, 22, '2196-02-15'),  -- Zarmina
    ('Desert Springs', 12, 10, '2198-03-15'),  -- Tatooine
    ('Forge Town', 13, 16, '2198-04-15'),  -- Vulcan
    ('Pandora Fields', 14, 14, '2196-05-15'),  -- Pandora
    ('Krypton Haven', 15, 20, '2198-06-15'),  -- Krypton
    ('Coruscant City', 16, 35, '2198-07-15'),  -- Coruscant
    ('Terra Two', 17, 28, '2198-08-15'),  -- Nova Terra
    ('Colony Beta', 17, 15, '2198-03-20'), -- Nova Terra
    ('Colony Gamma', 18, 8, '2196-05-10'), -- Aurora Prime
    ('Prime Colony', 18, 25, '2196-09-15'),  -- Aurora Prime
    ('Caelus Home', 19, 15, '2196-10-15'),  -- Caelus
    ('Colony Delta', 19, 12, '2190-07-25'), -- Caelus
    ('Seraphine Spires', 20, 12, '2196-11-15'),  -- Seraphine
    ('Blue Haven Shores', 21, 18, '2196-12-15'),  -- Blue Haven
    ('Utopia Complex', 22, 30, '2196-01-15'),  -- Matejina Utopija
    ('Colony Epsilon', 22, 10, '2195-09-30'), -- Blue Haven
    ('Colony Zeta', 23, 9, '2199-12-05'), -- Gallifrey
    ('Elara Nest', 23, 9, '2196-02-15'),  -- Elara
    ('Persephone Park', 24, 11, '2196-03-15'),  -- Persephone
    ('Astraea Arboretum', 25, 17, '2192-04-15'),  -- Astraea
    ('Nostromo Dock', 26, 14, '2192-05-15');  -- Nostromo


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
    (4, 6, '2101-02-20');


INSERT INTO Journeys (destination_body_id, vehicle_code, departure_date, arrival_date)
VALUES
    (10, 'XCV-777', '2200-01-01 06:00:00', '2200-01-02 12:00:00'),  -- alpha bb ja msm
    (10, 'YZT-123', '2200-02-01 06:00:00', '2200-02-02 12:00:00'),
    (10, 'XCV-777', '2200-03-01 06:00:00', '2200-03-02 12:00:00'),
    (10, 'YZT-123', '2200-04-01 06:00:00', '2200-04-02 12:00:00'),
    (10, 'XCV-777', '2200-05-01 06:00:00', '2200-05-02 12:00:00'),
    (10, 'YZT-123', '2200-06-01 06:00:00', '2200-06-02 12:00:00'),
    (10, 'XCV-777', '2200-07-01 06:00:00', '2200-07-02 12:00:00'),
    (10, 'YZT-123', '2200-08-01 06:00:00', '2200-08-02 12:00:00'),
    (10, 'XCV-777', '2200-09-01 06:00:00', '2200-09-02 12:00:00'),
    (10, 'YZT-123', '2200-10-01 06:00:00', '2200-10-02 12:00:00'),
    (10, 'XCV-777', '2200-11-01 06:00:00', '2200-11-02 12:00:00'),
    (10, 'YZT-123', '2200-12-01 06:00:00', '2200-12-02 12:00:00'),
    (10, 'XCV-777', '2201-01-01 06:00:00', '2201-01-02 12:00:00'),
    (10, 'YZT-123', '2201-02-01 06:00:00', '2201-02-02 12:00:00'),
    (10, 'XCV-777', '2201-03-01 06:00:00', '2201-03-02 12:00:00'),
    (10, 'YZT-123', '2201-04-01 06:00:00', '2201-04-02 12:00:00'),
    (10, 'XCV-777', '2201-05-01 06:00:00', '2201-05-02 12:00:00'),
    (10, 'YZT-123', '2201-06-01 06:00:00', '2201-06-02 12:00:00'),
    (10, 'XCV-777', '2201-07-01 06:00:00', '2201-07-02 12:00:00'),
    (10, 'YZT-123', '2201-08-01 06:00:00', '2201-08-02 12:00:00'),
    (10, 'XCV-777', '2201-09-01 06:00:00', '2201-09-02 12:00:00'),
    (10, 'YZT-123', '2201-10-01 06:00:00', '2201-10-02 12:00:00'),
    (10, 'XCV-777', '2201-11-01 06:00:00', '2201-11-02 12:00:00'),
    (10, 'YZT-123', '2201-12-01 06:00:00', '2201-12-02 12:00:00'),

    (3 , 'YZT-123', '2200-01-01 06:00:00', '2200-01-02 12:00:00'),  -- putovanja do nazad
    (3 , 'YZT-123', '2200-02-01 06:00:00', '2200-02-02 12:00:00'),
    (3 , 'YZT-123', '2200-03-01 06:00:00', '2200-03-02 12:00:00'),
    (3 , 'YZT-123', '2200-04-01 06:00:00', '2200-04-02 12:00:00'),
    (3 , 'YZT-123', '2200-05-01 06:00:00', '2200-05-02 12:00:00'),
    (3 , 'YZT-123', '2200-06-01 06:00:00', '2200-06-02 12:00:00'),
    (3 , 'YZT-123', '2200-07-01 06:00:00', '2200-07-02 12:00:00'),
    (3 , 'YZT-123', '2200-08-01 06:00:00', '2200-08-02 12:00:00'),
    (3 , 'YZT-123', '2200-09-01 06:00:00', '2200-09-02 12:00:00'),
    (3 , 'YZT-123', '2200-10-01 06:00:00', '2200-10-02 12:00:00'),
    (3 , 'YZT-123', '2200-11-01 06:00:00', '2200-11-02 12:00:00'),
    (3 , 'YZT-123', '2200-12-01 06:00:00', '2200-12-02 12:00:00'),

    (13, 'XCV-777', '2200-01-01 06:00:00', '2200-01-02 12:00:00'),
    (13, 'YZT-123', '2200-02-01 06:00:00', '2200-02-02 12:00:00'),
    (13, 'XCV-777', '2200-03-01 06:00:00', '2200-03-02 12:00:00'),
    (13, 'YZKF500', '2200-04-01 06:00:00', '2200-04-02 12:00:00'),
    (13, 'YZT-123', '2200-05-01 06:00:00', '2200-05-02 12:00:00'),
    (13, 'XCV-777', '2200-06-01 06:00:00', '2200-06-02 12:00:00'),
    (13, 'YZKF500', '2200-07-01 06:00:00', '2200-07-02 12:00:00'),
    (13, 'YZT-123', '2200-08-01 06:00:00', '2200-08-02 12:00:00'),
    (13, 'XCV-777', '2200-09-01 06:00:00', '2200-09-02 12:00:00'),
    (13, 'YZKF500', '2200-10-01 06:00:00', '2200-10-02 12:00:00'),
    (13, 'YZT-123', '2200-11-01 06:00:00', '2200-11-02 12:00:00'),
    (13, 'XCV-777', '2200-12-01 06:00:00', '2200-12-02 12:00:00'),
    (13, 'YZKF500', '2201-01-01 06:00:00', '2201-01-02 12:00:00'),
    (13, 'YZT-123', '2201-02-01 06:00:00', '2201-02-02 12:00:00'),
    (13, 'XCV-777', '2201-03-01 06:00:00', '2201-03-02 12:00:00'),
    (13, 'YZKF500', '2201-04-01 06:00:00', '2201-04-02 12:00:00'),
    (13, 'YZT-123', '2201-05-01 06:00:00', '2201-05-02 12:00:00'),
    (13, 'XCV-777', '2201-06-01 06:00:00', '2201-06-02 12:00:00'),
    (13, 'YZKF500', '2201-07-01 06:00:00', '2201-07-02 12:00:00'),
    (13, 'YZT-123', '2201-08-01 06:00:00', '2201-08-02 12:00:00'),
    (13, 'XCV-777', '2201-09-01 06:00:00', '2201-09-02 12:00:00'),
    (13, 'YZKF500', '2201-10-01 06:00:00', '2201-10-02 12:00:00'),
    (13, 'YZT-123', '2201-11-01 06:00:00', '2201-11-02 12:00:00'),
    (13, 'XCV-777', '2201-12-01 06:00:00', '2201-12-02 12:00:00'),

    (14, 'XCV-777', '2200-01-01 06:00:00', '2200-01-02 12:00:00'),
    (14, 'YZT-123', '2200-02-01 06:00:00', '2200-02-02 12:00:00'),
    (14, 'XCV-777', '2200-03-01 06:00:00', '2200-03-02 12:00:00'),
    (14, 'YZ50033', '2200-04-01 06:00:00', '2200-04-02 12:00:00'),
    (14, 'YZT-123', '2200-05-01 06:00:00', '2200-05-02 12:00:00'),
    (14, 'XCV-777', '2200-06-01 06:00:00', '2200-06-02 12:00:00'),
    (14, 'YZT-123', '2200-07-01 06:00:00', '2200-07-02 12:00:00'),
    (14, 'XCV-777', '2200-08-01 06:00:00', '2200-08-02 12:00:00'),
    (14, 'YZT-123', '2200-09-01 06:00:00', '2200-09-02 12:00:00'),
    (14, 'XCV-777', '2200-10-01 06:00:00', '2200-10-02 12:00:00'),
    (14, 'YZ50033', '2200-11-01 06:00:00', '2200-11-02 12:00:00'),
    (14, 'YZT-123', '2200-12-01 06:00:00', '2200-12-02 12:00:00'),
    (14, 'XCV-777', '2201-01-01 06:00:00', '2201-01-02 12:00:00'),
    (14, 'YZT-123', '2201-02-01 06:00:00', '2201-02-02 12:00:00'),
    (14, 'XCV-777', '2201-03-01 06:00:00', '2201-03-02 12:00:00'),
    (14, 'YZ50022', '2201-04-01 06:00:00', '2201-04-02 12:00:00'),
    (14, 'YZT-123', '2201-05-01 06:00:00', '2201-05-02 12:00:00'),
    (14, 'XCV-777', '2201-06-01 06:00:00', '2201-06-02 12:00:00'),
    (14, 'YZT-123', '2201-07-01 06:00:00', '2201-07-02 12:00:00'),
    (14, 'XCV-777', '2201-08-01 06:00:00', '2201-08-02 12:00:00'),
    (14, 'YZT-123', '2201-09-01 06:00:00', '2201-09-02 12:00:00'),
    (14, 'XCV-777', '2201-10-01 06:00:00', '2201-10-02 12:00:00'),
    (14, 'YZ50022', '2201-11-01 06:00:00', '2201-11-02 12:00:00'),
    (14, 'YZT-123', '2201-12-01 06:00:00', '2201-12-02 12:00:00'),

    (15, 'XCV-777', '2200-01-01 06:00:00', '2200-01-02 12:00:00'),
    (15, 'YZT-123', '2200-02-01 06:00:00', '2200-02-02 12:00:00'),
    (15, 'XCV-777', '2200-03-01 06:00:00', '2200-03-02 12:00:00'),
    (15, 'YZ500', '2200-04-01 06:00:00',   '2200-04-02 12:00:00'),
    (15, 'YZT-123', '2200-05-01 06:00:00', '2200-05-02 12:00:00'),
    (15, 'XCV-777', '2200-06-01 06:00:00', '2200-06-02 12:00:00'),
    (15, 'YZT-123', '2200-07-01 06:00:00', '2200-07-02 12:00:00'),
    (15, 'XCV-777', '2200-08-01 06:00:00', '2200-08-02 12:00:00'),
    (15, 'YZ500', '2200-09-01 06:00:00',   '2200-09-02 12:00:00'),
    (15, 'YZT-123', '2200-10-01 06:00:00', '2200-10-02 12:00:00'),
    (15, 'XCV-777', '2200-11-01 06:00:00', '2200-11-02 12:00:00'),
    (15, 'YZT-123', '2200-12-01 06:00:00', '2200-12-02 12:00:00'),
    (15, 'XCV-777', '2201-01-01 06:00:00', '2201-01-02 12:00:00'),
    (15, 'YZT-123', '2201-02-01 06:00:00', '2201-02-02 12:00:00'),
    (15, 'XCV-777', '2201-03-01 06:00:00', '2201-03-02 12:00:00'),
    (15, 'YZ500', '2201-04-01 06:00:00',   '2201-04-02 12:00:00'),
    (15, 'YZT-123', '2201-05-01 06:00:00', '2201-05-02 12:00:00'),
    (15, 'XCV-777', '2201-06-01 06:00:00', '2201-06-02 12:00:00'),
    (15, 'YZT-123', '2201-07-01 06:00:00', '2201-07-02 12:00:00'),
    (15, 'XCV-777', '2201-08-01 06:00:00', '2201-08-02 12:00:00'),
    (15, 'YZ500', '2201-09-01 06:00:00',   '2201-09-02 12:00:00'),
    (15, 'YZT-123', '2201-10-01 06:00:00', '2201-10-02 12:00:00'),
    (15, 'XCV-777', '2201-11-01 06:00:00', '2201-11-02 12:00:00'),
    (15, 'YZT-123', '2201-12-01 06:00:00', '2201-12-02 12:00:00'),

(18, 'XCV-777', '2200-01-01 06:00:00', '2200-01-02 12:00:00'),  -- Aurora prime id 18
(18, 'YZT-123', '2200-02-01 06:00:00', '2200-02-02 12:00:00'),
(18, 'XCV-777', '2200-03-01 06:00:00', '2200-03-02 12:00:00'),
(18, 'YZT-123', '2200-04-01 06:00:00', '2200-04-02 12:00:00'),
(18, 'XCV-777', '2200-05-01 06:00:00', '2200-05-02 12:00:00'),
(18, 'YZT-123', '2200-06-01 06:00:00', '2200-06-02 12:00:00'),
(18, 'XCV-777', '2200-07-01 06:00:00', '2200-07-02 12:00:00'),
(18, 'YZT-123', '2200-08-01 06:00:00', '2200-08-02 12:00:00'),
(18, 'XCV-777', '2200-09-01 06:00:00', '2200-09-02 12:00:00'),
(18, 'YZT-123', '2200-10-01 06:00:00', '2200-10-02 12:00:00'),
(18, 'XCV-777', '2200-11-01 06:00:00', '2200-11-02 12:00:00'),
(18, 'YZT-123', '2200-12-01 06:00:00', '2200-12-02 12:00:00'),
(18, 'XCV-777', '2201-01-01 06:00:00', '2201-01-02 12:00:00'),
(18, 'YZT-123', '2201-02-01 06:00:00', '2201-02-02 12:00:00'),
(18, 'XCV-777', '2201-03-01 06:00:00', '2201-03-02 12:00:00'),
(18, 'YZT-123', '2201-04-01 06:00:00', '2201-04-02 12:00:00'),
(18, 'XCV-777', '2201-05-01 06:00:00', '2201-05-02 12:00:00'),
(18, 'YZT-123', '2201-06-01 06:00:00', '2201-06-02 12:00:00'),
(18, 'XCV-777', '2201-07-01 06:00:00', '2201-07-02 12:00:00'),
(18, 'YZT-123', '2201-08-01 06:00:00', '2201-09-02 12:00:00'),
(18, 'YZT-123', '2201-09-01 06:00:00', '2201-09-02 12:00:00'),
(18, 'XCV-777', '2201-10-01 06:00:00', '2201-11-02 12:00:00'),
(18, 'YZT-123', '2201-11-01 06:00:00', '2201-11-02 12:00:00'),
(18, 'YZT-123', '2201-12-01 06:00:00', '2201-12-02 12:00:00'),

(18, 'XCV-777', '2200-08-01 10:00:00', '2200-09-05 12:00:00'), -- ne svidja mi se , brisacemo ovo
(19, 'YZT-123', '2200-05-08 15:00:00', '2200-06-02 18:00:00'),
(20, 'XCV-777', '2200-08-15 12:30:00', '2200-10-12 15:00:00'),
(21, 'YZT-123', '2127-06-22 09:00:00', '2127-09-15 11:00:00'),
(22, 'XCV-777', '2128-02-09 18:00:00', '2128-05-25 14:00:00'),
(23, 'ZZT-999', '2129-04-12 07:00:00', '2129-09-12 10:00:00'),
(24, 'XCV-777', '2130-01-18 16:00:00', '2130-08-18 09:00:00'),
(25, 'YZT-123', '2131-10-26 05:00:00', '2132-04-26 12:00:00'),
(26, 'XCV-777', '2132-07-04 20:00:00', '2132-11-20 17:00:00');


INSERT INTO Calendar (today)
VALUES
    ('2200-01-01');