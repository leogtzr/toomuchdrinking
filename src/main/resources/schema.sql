DROP TABLE IF EXISTS DrinkType;
DROP TABLE IF EXISTS Drinks;

create table DrinkType (
    id integer primary key auto_increment not null,
    type varchar(40) not null
);

create table Drinks (
    id integer primary key auto_increment not null,
    drink_date date not null,
    type varchar(50) not null,
    qty integer not null,
    milliliters integer not null,
    abv decimal not null,
    description varchar(70) not null
    -- FOREIGN KEY (type) references DrinkType(type)
);

CREATE INDEX drinks_drink_date_idx ON Drinks(drink_date);
CREATE INDEX drink_type_type_idx ON DrinkType(type);

INSERT INTO DrinkType(type) VALUES('Beer'); --1
INSERT INTO DrinkType(type) VALUES('Whiskey'); --2
