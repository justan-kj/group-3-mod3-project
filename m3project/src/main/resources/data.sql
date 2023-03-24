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
('Paris Getaway', 'France', 1, '2023-06-01', '2023-06-03', 1000.00),
('Tokyo Adventure', 'Japan', 3, '2023-07-01', '2023-07-07', 3000.00);

INSERT INTO itinerary_items (name, description, itinerary_id, transport_id, accommodation_id, destination_id, start_date, end_date)
VALUES ('New York Day 1', 'Departure flight to New York', 1, 1, 1, 1, '2023-04-01', '2023-04-01'),
('New York Day 2', 'Luxury hotel in Manhattan', 1, 2, 2, 1, '2023-04-02', '2023-04-04'),
('New York Day 3', 'Guided tour of the Statue of Liberty', 1, 3, 2, 1, '2023-04-05', '2023-04-06'),
('London Day 1', 'Arrival flight to London', 2, 1, 1, 2, '2023-05-01', '2023-05-02'),
('London Day 2', 'Hotel in central London', 2, 2, 3, 2, '2023-05-02', '2023-05-06'),
('Paris Day 1', 'Departure train to Paris', 3, 2, 4, 3, '2023-06-01', '2023-06-01'),
('Paris Day 2', 'Cozy apartment in central Paris', 3, 1, 5, 3, '2023-06-02', '2023-06-04'),
('Tokyo Day 1', 'Arrival flight to Tokyo', 4, 1, 3, 4, '2023-07-01', '2023-07-02'),
('Tokyo Day 2', 'Ryokan in the countryside', 4, 1, 6, 4, '2023-07-03', '2023-07-04'),
('Tokyo Day 3', 'City hotel in Shinjuku', 4, 2, 7, 4, '2023-07-05', '2023-07-06');
