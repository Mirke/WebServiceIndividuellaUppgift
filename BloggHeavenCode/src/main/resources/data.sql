USE bloggheaven;

INSERT INTO address (street, postalCode, city, country)
VALUES ('Rustnings gatan 1','11111','Uppsala','Sverige'),
       ('Legends Street 8','22222','New York', 'USA'),
       ('Megaman gatan 3','33333','Helsinki','Finland'),
       ('Kirby gatan 8','44444','Oslo','Norge'),
       ('Sonic gatan 5','55555','Köpenhamn','Danmark');

INSERT INTO user (firstName, lastName, AddressId, email, phone, memberTypes)
VALUES ('Peter', 'Andersson', 1,'peter@emailmail.com', '0777777777','standard'),
       ('Angela','Rubenson',2,'angela@emailmail.com','0777777771','enhanced'),
       ('Robin','Larsson',3,'robin@emailmail.com','07377777772','premium'),
       ('Kim','Karlsson',4,'kim@emailmail.com','0787777777773','standard'),
       ('Morgan','Ekblad',5,'morgan@emailmail.com','07977777775','enhanced');

