create table users (
    id int AUTO_INCREMENT NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    age int,
    gender int,
    created_at timestamp default current_timestamp,
    primary key (id)
);

CREATE TABLE destinations (
  id INT AUTO_INCREMENT,
  image VARCHAR(255),
  name varchar(255),
  city VARCHAR(255) NOT NULL,
  country VARCHAR(255) NOT NULL,
  description TEXT,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  primary key (id)
);

create table transport (
    id int AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    description TEXT,
    image VARCHAR(255),
    price Decimal(8,2) NOT NULL,
    created_at timestamp default current_timestamp,
    primary key (id)
);

create table accommodation (
    id int AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    description TEXT,
    image VARCHAR(255),
    price Decimal(8,2) NOT NULL,
    created_at timestamp default current_timestamp,
    primary key (id)
);

create table itineraries (
    id int AUTO_INCREMENT NOT NULL,
    name varchar(255),
    description varchar(255),
    user_id int NOT NULL,
    start_date Date NOT NULL,
    end_date Date NOT NULL,
    budget Decimal(8,2),
    created_at timestamp default current_timestamp,
    primary key (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

create table itinerary_items (
    id int AUTO_INCREMENT NOT NULL,
    name varchar(255),
    description varchar(255),
    itinerary_id int NOT NULL,
    transport_id int,
    accommodation_id int,
    destination_id INT,
    start_date Date,
    end_date Date,
    notes TEXT,
    created_at timestamp default current_timestamp,
    primary key (id),
    FOREIGN KEY (itinerary_id) REFERENCES itineraries(id),
    FOREIGN KEY (destination_id) REFERENCES destinations(id),
    FOREIGN KEY (transport_id) REFERENCES transport(id),
    FOREIGN KEY (accommodation_id) REFERENCES accommodation(id)
);



