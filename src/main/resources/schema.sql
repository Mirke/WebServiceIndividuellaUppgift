DROP DATABASE IF EXISTS bloggheaven;
Create DATABASE bloggheaven;

USE bloggheaven;

DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS blog_user;
DROP TABLE IF EXISTS blog_post;

CREATE TABLE address
(
    id INT AUTO_INCREMENT NOT NULL,
    street VARCHAR(90) NOT NULL,
    postal_code VARCHAR(90) NOT NULL,
    city VARCHAR(90) NOT NULL,
    country VARCHAR(90) NOT NULL,
    PRIMARY KEY(id)
) ;

CREATE TABLE blog_user
(
    id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(90) NOT NULL,
    last_name VARCHAR(90) NOT NULL,
    email VARCHAR(90) NOT NULL,
    phone VARCHAR(90) NOT NULL,
    member_types VARCHAR(90) NOT NULL,
    PRIMARY KEY(id),
    fk_address INT,
    FOREIGN KEY (fk_address) REFERENCES address(id)
);

CREATE TABLE blog_post
(
    id INT AUTO_INCREMENT NOT NULL,
    content VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    fk_blog_user INT,
    FOREIGN KEY (fk_blog_user) REFERENCES blog_user(id)
);