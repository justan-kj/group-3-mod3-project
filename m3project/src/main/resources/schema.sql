create table users (
    id int AUTO_INCREMENT NOT NULL,
    email varchar(255) NOT NULL,
    password char(50) NOT NULL,
    age int,
    gender int,
    created_at timestamp default current_timestamp,
    primary key (id)
);

create table transport (
    id int AUTO_INCREMENT NOT NULL,
    description varchar(255) NOT NULL,
    price Decimal(8,2) NOT NULL,
    created_at timestamp default current_timestamp,
    primary key (id)
);

create table accommodation (
    id int AUTO_INCREMENT NOT NULL,
    description varchar(255) NOT NULL,
    price Decimal(8,2) NOT NULL,
    created_at timestamp default current_timestamp,
    primary key (id)
);

create table itineraries (
    id int AUTO_INCREMENT NOT NULL,
    user_id int NOT NULL,
    transport_id int,
    accommodation_id int,
    destination_city varchar(255) NOT NULL,
    destination_country varchar(255) NOT NULL,
    destination_start_date varchar(255) NOT NULL,
    destination_end_date varchar(255) NOT NULL,
    budget Decimal(8,2),
    created_at timestamp default current_timestamp,
    primary key (id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (transport_id) REFERENCES transport(id),
    FOREIGN KEY (accommodation_id) REFERENCES accommodation(id)
);
