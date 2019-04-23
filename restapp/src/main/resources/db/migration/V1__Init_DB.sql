create sequence hibernate_sequence start with 6 increment by 1;

create table busy_date_range (
	range_id integer not null, 
	departure timestamp not null, 
	arrival timestamp not null, 
	primary key (range_id, arrival)
);

create table room (
	id integer not null,
	category varchar(255),
	breakfast boolean ,  
	cleaning boolean ,
	number integer not null, 
	is_busy boolean not null, 
	price integer not null, 
	price_breakfast integer, 
	price_cleaning integer, 
	primary key (id)
);

alter table busy_date_range 
	add constraint bdr_room_fk
	foreign key (range_id) references room;