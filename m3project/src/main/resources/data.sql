INSERT INTO users (email, password, age, gender)
VALUES ('john.doe@example.com', 'password', 30, 1),
('jane.doe@example.com', 'password', 28, 2),
('bob.smith@example.com', 'password', 35, 1),
('alice.jones@example.com', 'password', 25, 2);

INSERT INTO destinations (name, city, country, description, image)
VALUES 
('Big Ben', 'London', 'United Kingdom', 'Iconic clock tower and landmark of London', 'https://images.pexels.com/photos/632653/pexels-photo-632653.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Sensoji Temple', 'Tokyo', 'Japan', 'Historic Buddhist temple with a large lantern', 'https://images.pexels.com/photos/6493153/pexels-photo-6493153.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Eiffel Tower', 'Paris', 'France', 'Iconic landmark of Paris with views of the city', 'https://images.pexels.com/photos/532826/pexels-photo-532826.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Statue of Liberty', 'New York', 'United States', 'Iconic statue of a woman holding a torch', 'https://images.pexels.com/photos/722014/pexels-photo-722014.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Tower Bridge', 'London', 'United Kingdom', 'Iconic bridge with views of the River Thames', 'https://images.pexels.com/photos/427679/pexels-photo-427679.jpeg'),
('Tokyo Skytree', 'Tokyo', 'Japan', 'Tallest structure in Japan with views of the city', 'https://images.pexels.com/photos/12536732/pexels-photo-12536732.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Champs-Elysees', 'Paris', 'France', 'Famous avenue with shops and landmarks', 'https://images.pexels.com/photos/9933073/pexels-photo-9933073.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('The Shard', 'London', 'United Kingdom', 'Tallest building in the UK with views of the city', 'https://images.pexels.com/photos/13990958/pexels-photo-13990958.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Shibuya Crossing', 'Tokyo', 'Japan', 'Iconic intersection with crowds of pedestrians', 'https://images.pexels.com/photos/3800103/pexels-photo-3800103.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('The Louvre', 'Paris', 'France', 'Famous art museum with the Mona Lisa and more', 'https://images.pexels.com/photos/2675266/pexels-photo-2675266.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Central Park', 'New York', 'United States', 'Large urban park with lakes, gardens, and attractions', 'https://images.pexels.com/photos/2850444/pexels-photo-2850444.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Empire State Building', 'New York', 'United States', 'Iconic skyscraper with views of the city', 'https://images.pexels.com/photos/5847768/pexels-photo-5847768.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');


INSERT INTO transport (name, description, price, image)
VALUES ('Flight', 'This is air travel', 250.00,'https://images.pexels.com/photos/113017/pexels-photo-113017.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Train', 'This is railway travel', 100.00,'https://images.pexels.com/photos/5699984/pexels-photo-5699984.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Car', 'This is a personal vehicle', 50.00,'https://images.pexels.com/photos/2920064/pexels-photo-2920064.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Bus', 'This is a bus', 5.00, 'https://images.pexels.com/photos/3829175/pexels-photo-3829175.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');

INSERT INTO accommodation (name, description, price, image)
VALUES ('Hotel', 'Luxury accommodations', 200.00,'https://images.pexels.com/photos/1579253/pexels-photo-1579253.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Hostel', 'Budget accommodations', 50.00,'https://images.pexels.com/photos/4907235/pexels-photo-4907235.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Airbnb', 'Home-sharing accommodations', 100.00,'https://images.pexels.com/photos/1428348/pexels-photo-1428348.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
('Streets', 'Free real estate',0.00,'https://images.pexels.com/photos/8078456/pexels-photo-8078456.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');

INSERT INTO itineraries (name, description, user_id, start_date, end_date, budget)
VALUES ('New York Trip', 'USA', 1, '2023-04-03', '2023-04-07', 1500.00),
('London Vacation', 'United Kingdom', 2, '2023-05-01', '2023-05-05', 2000.00),
('Paris Getaway', 'France', 1, '2023-06-08', '2023-06-12', 1000.00),
('Trouble in Tokyo','Japan',2,'2023-08-04','2023-08-08',2500.00);

INSERT INTO itinerary_items (name, description, itinerary_id, transport_id, accommodation_id, destination_id, start_date, end_date)
VALUES ('New York Day 1', 'Departure flight to New York', 1, 1, 2, 4, '2023-04-01', '2023-04-03'),
('New York Day 2', 'Luxury hotel in Manhattan', 1, 2, 1, 11, '2023-04-03', '2023-04-07'),
('Paris Day 1', 'Departure train to Paris', 3, 2, 3, 3, '2023-06-01', '2023-06-03'),
('Paris Day 2', 'Cozy apartment in central Paris', 3, 2, 3, 10, '2023-06-03', '2023-06-06'),
('London Day 1', 'Departure flight to London', 2, 1, 2, 1, '2023-05-01', '2023-05-03'),
('London Day 2', 'Stay at a boutique hotel in Camden', 2, 4, 3, 5, '2023-05-03', '2023-05-06'),
('London Day 3', 'Visit the British Museum and see Big Ben', 2, 3, 3, 8, '2023-05-06', '2023-05-08'),
('Tokyo Day 1', 'Departure flight to Tokyo', 4, 1, 2, 2, '2023-08-04', '2023-08-06'),
('Tokyo Day 2', 'Explore the city and visit Sensoji Temple', 4, 2, 3, 6, '2023-08-06', '2023-08-08'),
('Tokyo Day 3', 'Visit Tokyo Disneyland', 4, 3, 4, 9, '2023-08-08', '2023-08-10'),
('Tokyo Day 4', 'Relax and enjoy the hotel amenities', 4, 4, 4, 9, '2023-08-10', '2023-08-11');