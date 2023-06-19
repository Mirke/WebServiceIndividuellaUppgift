USE bloggheaven;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS address;

CREATE TABLE user
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(90) NOT NULL,
    lastName VARCHAR(90) NOT NULL,
    address VARCHAR(90) NOT NULL,
    email VARCHAR(90) NOT NULL,
    phone VARCHAR(90) NOT NULL,
    memberTypes ENUM('standard','enhanced','premium') NOT NULL
);

CREATE TABLE address
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(90) NOT NULL,
    postalCode VARCHAR(90) NOT NULL,
    city VARCHAR(90) NOT NULL,
    country VARCHAR(90) NOT NULL
);