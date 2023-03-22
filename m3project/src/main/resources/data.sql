INSERT INTO users (email, password, age, gender) VALUES
('johndoe@example.com', 'password123', 25, 1),
('janedoe@example.com', 'secret123', 35, 0),
('bobsmith@example.com', 'qwerty123', 42, 1);

INSERT INTO transport (name,description, price) VALUES
('Singapore Airlines','Flight from London to Paris', 120.00),
('EuroRail','Train from Rome to Florence', 50.00),
('FlixBus','Bus from Madrid to Barcelona', 25.00);

INSERT INTO accommodation (name,description, price) VALUES
('Four Seasons','Luxury hotel in Paris', 2500.00),
('Roma Saveilli','Apartment in Rome', 120.00),
('One Paralelo','Hostel in Barcelona', 40.00);

INSERT INTO destinations (city, country, description)
VALUES 
  ('Paris', 'France', 'The City of Light and Love'),
  ('Rome', 'Italy', 'The Eternal City'),
  ('Barcelona', 'Spain', 'The City of Gaudi');

INSERT INTO itineraries (user_id, start_date, end_date, budget) VALUES
(1, '2023-05-01', '2023-05-10', 2000.00),
(2, '2023-07-15', '2023-07-22', 1500.00),
(3, '2024-02-01', '2024-02-08', 3000.00);

INSERT INTO itinerary_items (itinerary_id, transport_id, accommodation_id, destination_id, start_date, end_date) VALUES
(1, 2, 2, 2, '2023-05-05', '2023-05-10'),
(2, 3, 3, 3, '2023-07-15', '2023-07-22'),
(3, 1, 2, 1, '2024-02-01', '2024-02-05');