INSERT INTO users (email, password, age, gender) VALUES
('johndoe@example.com', 'password123', 25, 1),
('janedoe@example.com', 'secret123', 35, 0),
('bobsmith@example.com', 'qwerty123', 42, 1);

INSERT INTO transport (description, price) VALUES
('Flight from London to Paris', 120.00),
('Train from Rome to Florence', 50.00),
('Bus from Madrid to Barcelona', 25.00);

INSERT INTO accommodation (description, price) VALUES
('Luxury hotel in Paris', 250.00),
('Apartment in Rome', 100.00),
('Hostel in Barcelona', 30.00);

INSERT INTO itineraries (user_id, transport_id, accommodation_id, destination_city, destination_country, destination_start_date, destination_end_date, budget) VALUES
(1, 1, 1, 'Paris', 'France', '2023-05-01', '2023-05-05', 1000.00),
(2, 2, 2, 'Rome', 'Italy', '2023-06-10', '2023-06-15', 1500.00),
(3, 3, 3, 'Barcelona', 'Spain', '2023-07-20', '2023-07-25', 800.00);
