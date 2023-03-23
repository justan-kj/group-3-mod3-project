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
('Car', 'This is a personal vehicle', 50.00);

INSERT INTO accommodation (name, description, price)
VALUES ('Hotel', 'Luxury accommodations', 200.00),
('Hostel', 'Budget accommodations', 50.00),
('Airbnb', 'Home-sharing accommodations', 100.00);

INSERT INTO itineraries (name, description, user_id, start_date, end_date, budget)
VALUES ('New York Trip', 'USA', 1, '2023-04-01', '2023-04-07', 1500.00),
('London Vacation', 'United Kingdom', 2, '2023-05-01', '2023-05-08', 2000.00),
('Paris Getaway', 'France', 1, '2023-06-01', '2023-06-03', 1000.00);

INSERT INTO itinerary_items (name, description, itinerary_id, transport_id, accommodation_id, destination_id, start_date, end_date)
VALUES ('New York Day 1', 'Departure flight to New York', 1, 1, NULL, NULL, '2023-04-01', NULL),
('New York Day 2', 'Luxury hotel in Manhattan', 1, NULL, 1, NULL, '2023-04-01', '2023-04-07'),
('Paris Day 1', 'Departure train to Paris', 3, 2, NULL, NULL, '2023-06-01', NULL),
('Paris Day 2', 'Cozy apartment in central Paris', 3, NULL, 3, NULL, '2023-06-01', '2023-06-03');