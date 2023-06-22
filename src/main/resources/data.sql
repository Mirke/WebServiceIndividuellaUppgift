USE bloggheaven;

INSERT INTO address (street, postal_code, city, country)
VALUES ('Rustnings gatan 1','11111','Uppsala','Sverige'),
       ('Legends Street 8','22222','New York', 'USA'),
       ('Megaman gatan 3','33333','Helsinki','Finland'),
       ('Kirby gatan 8','44444','Oslo','Norge'),
       ('Sonic gatan 5','55555','Köpenhamn','Danmark');

INSERT INTO blog_user (first_name, last_name, email, phone, member_types,fk_address)
VALUES ('Peter', 'Andersson', 'peter@emailmail.com', '0777777777','standard',1),
       ('Angela','Rubenson','angela@emailmail.com','0777777771','enhanced',2),
       ('Robin','Larsson','robin@emailmail.com','07377777772','premium',3),
       ('Kim','Karlsson','kim@emailmail.com','0787777777773','standard',4),
       ('Morgan','Ekblad','morgan@emailmail.com','07977777775','enhanced',5);

INSERT INTO blog_post(content,fk_blog_user)
VALUES ('Today was a good day!',1),
       ('My dog sneezed',2),
       ('It will rain tomorrow.',3),
       ('I need more coffee.',4),
       ('Is there aliens out there?',5);