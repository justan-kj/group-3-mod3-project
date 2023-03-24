INSERT INTO users (email, password, age, gender)
VALUES ('john.doe@example.com', 'password', 30, 1),
('jane.doe@example.com', 'password', 28, 2),
('bob.smith@example.com', 'password', 35, 1),
('alice.jones@example.com', 'password', 25, 2);

INSERT INTO destinations (city, country, description)
VALUES ('New York', 'United States', 'The Big Apple'),
('London', 'United Kingdom', 'The British capital'),
('Paris', 'France', 'The City of Light'),
('Tokyo', 'Japan', 'The Land of the Rising Sun');

INSERT INTO transport (name, description, price)
VALUES ('Flight', 'This is air travel', 250.00),
('Train', 'This is railway travel', 100.00),
('Car', 'This is a personal vehicle', 50.00),
('Bus', 'This is a bus', 5.00);

INSERT INTO accommodation (name, description, price)
VALUES ('Hotel', 'Luxury accommodations', 200.00),
('Hostel', 'Budget accommodations', 50.00),
('Airbnb', 'Home-sharing accommodations', 100.00),
('Streets', 'Free real estate',0.00);

INSERT INTO itineraries (name, description, user_id, start_date, end_date, budget)
VALUES ('New York Trip', 'USA', 1, '2023-04-01', '2023-04-07', 1500.00),
('London Vacation', 'United Kingdom', 2, '2023-05-01', '2023-05-08', 2000.00),
('Paris Getaway', 'France', 1, '2023-06-01', '2023-06-03', 1000.00),
('Trouble in Tokyo','Japan',2,'2023-08-04','2023-08-11',2500.00);

INSERT INTO itinerary_items (name, description, itinerary_id, transport_id, accommodation_id, destination_id, start_date, end_date)
VALUES ('New York Day 1', 'Departure flight to New York', 1, 1, 2, 1, '2023-04-01', '2023-04-03'),
('New York Day 2', 'Luxury hotel in Manhattan', 1, 2, 1, 1, '2023-04-03', '2023-04-07'),
('Paris Day 1', 'Departure train to Paris', 3, 2, 3, 2, '2023-06-01', '2023-06-03'),
('Paris Day 2', 'Cozy apartment in central Paris', 3, 2, 3, 2, '2023-06-03', '2023-06-06'),
('London Day 1', 'Departure flight to London', 2, 1, 2, 3, '2023-05-01', '2023-05-03'),
('London Day 2', 'Stay at a boutique hotel in Camden', 2, 4, 3, 3, '2023-05-03', '2023-05-06'),
('London Day 3', 'Visit the British Museum and see Big Ben', 2, 3, 3, 3, '2023-05-06', '2023-05-08'),
('Tokyo Day 1', 'Departure flight to Tokyo', 4, 1, 2, 4, '2023-08-04', '2023-08-06'),
('Tokyo Day 2', 'Explore the city and visit Sensoji Temple', 4, 2, 3, 4, '2023-08-06', '2023-08-08'),
('Tokyo Day 3', 'Visit Tokyo Disneyland', 4, 3, 3, 4, '2023-08-08', '2023-08-10'),
('Tokyo Day 4', 'Relax and enjoy the hotel amenities', 4, 4, 1, 4, '2023-08-10', '2023-08-11');