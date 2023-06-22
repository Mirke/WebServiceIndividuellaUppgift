USE bloggheaven;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS user;

CREATE TABLE address
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(90) NOT NULL,
    postalCode VARCHAR(90) NOT NULL,
    city VARCHAR(90) NOT NULL,
    country VARCHAR(90) NOT NULL
);

CREATE TABLE user
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(90) NOT NULL,
    lastName VARCHAR(90) NOT NULL,
    AddressId INT,
    FOREIGN KEY (AddressId) REFERENCES address(id),
    email VARCHAR(90) NOT NULL,
    phone VARCHAR(90) NOT NULL,
    memberTypes ENUM('standard','enhanced','premium') NOT NULL
);

CREATE TABLE blogpost
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(255) NOT NULL,
    UserId INT,
    FOREIGN KEY (UserId) REFERENCES user(id)

);