create table country(
    id bigint(8) not null auto_increment primary key,
    name varchar(255) not null
);

create table hotel(
    id bigint(8) not null auto_increment primary key,
    name varchar(255) not null,
    city varchar(255) not null,
    description varchar(255) not null,
    photo varchar(255) not null,
    stars int not null,
    country_id bigint(8) not null,
    
    constraint FK_hotel_country foreign key(country_id) references country(id)
);

create table user_role(
    id bigint(8) not null auto_increment primary key,
    role varchar(255) not null
);

create table user(
    id bigint(8) not null auto_increment primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    age int not null,
    email varchar(255) not null,
    phone varchar(255) not null,
    username varchar(255) not null unique,
    password varchar(255) not null,
    is_enabled tinyint(1) not null,
    
    constraint foreign key(user_role_id) references user_role(id)
);

create table user_user_role(
    user_id bigint(8) not null,
    role_id bigint(8) not null,
    
    constraint primary key(user_id, role_id),
    constraint foreign key(user_id) references user(id),
    constraint foreign key(role_id) references user_role(id)
);

create table room_type(
    id bigint(8) not null auto_increment primary key,
    type varchar(255) not null
);

create table room(
    id bigint(8) not null auto_increment primary key,
    number_of_people int not null,
    price decimal(10, 2) not null,
    description varchar(255) not null,
    quantity int not null,
    photo varchar(255) not null,
    hotel_id bigint(8) not null,
    room_type_id bigint(8) not null,
    
    constraint FK_room_hotel foreign key(hotel_id) references hotel(id),
    constraint FK_room_room_type foreign key(room_type_id) references room_type(id)
);

create table booking(
    id bigint(8) not null primary key auto_increment,
    arrival_date date not null,
    departure_date date not null,
    price decimal(10, 2) not null,
    number_of_rooms int not null,
    user_id bigint(8) not null,
    room_id bigint(8) not null,
    
    constraint FK_booking_user foreign key(user_id) references user(id),
    constraint FK_booking_room foreign key(room_id) references room(id)
);

insert into user_role(role) values('ROLE_USER');
insert into user_role(role) values('ROLE_ADMIN');

insert into room_type(type) values('APARTMENT'),('BALCONY'),('BDR'),('BUSINESS'),('CONNECTED_ROOMS'),('DE LUXE'),('FAMILY ROOM');