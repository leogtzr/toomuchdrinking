INSERT INTO drink_type(type) VALUES('Beer');
INSERT INTO drink_type(type) VALUES('Whiskey');

INSERT INTO drink(abv,description,drink_date,milliliters,quantity,drink_type_id)
VALUES(1.1, 'Test desc 1', '2018-03-01', 10, 1, 1);
INSERT INTO drink(abv,description,drink_date,milliliters,quantity,drink_type_id)
VALUES(1.1, 'Test desc 2', '2018-03-02', 10, 2, 1);
INSERT INTO drink(abv,description,drink_date,milliliters,quantity,drink_type_id)
VALUES(1.1, 'Test desc 2', '2018-03-03', 10, 1, 1);
INSERT INTO drink(abv,description,drink_date,milliliters,quantity,drink_type_id)
VALUES(1.1, 'Test desc 2', '2018-03-04', 10, 3, 1);
INSERT INTO drink(abv,description,drink_date,milliliters,quantity,drink_type_id)
VALUES(1.1, 'Test desc 2', '2018-03-05', 10, 0, 1);