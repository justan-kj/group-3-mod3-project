create table users (
    id int AUTO_INCREMENT NOT NULL,
    email varchar(255) NOT NULL,
    password char(50) NOT NULL,
    age int,
    gender int,
    created_at timestamp default current_timestamp,
    primary key (id)
);

CREATE TABLE destinations (
  id INT AUTO_INCREMENT,
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
    price Decimal(8,2) NOT NULL,
    created_at timestamp default current_timestamp,
    primary key (id)
);

create table accommodation (
    id int AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    description TEXT,
    price Decimal(8,2) NOT NULL,
    created_at timestamp default current_timestamp,
    primary key (id)
);

create table itineraries (
    id int AUTO_INCREMENT NOT NULL,
    user_id int NOT NULL,
    transport_id int,
    accommodation_id int,
    destination_id INT NOT NULL,
    start_date Date NOT NULL,
    end_date Date NOT NULL,
    budget Decimal(8,2),
    created_at timestamp default current_timestamp,
    primary key (id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (destination_id) REFERENCES destinations(id),
    FOREIGN KEY (transport_id) REFERENCES transport(id),
    FOREIGN KEY (accommodation_id) REFERENCES accommodation(id)
);
