DROP DATABASE IF EXISTS sportspile;

CREATE DATABASE sportspile CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci;

USE sportspile;

CREATE TABLE IF NOT EXISTS discipline (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(500));
    
CREATE TABLE IF NOT EXISTS news (
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(80) NOT NULL,
    url VARCHAR(500) NOT NULL UNIQUE,
    description VARCHAR(500) NOT NULL,
    date_added DATETIME NOT NULL,
    discipline_id INT NOT NULL,
    FOREIGN KEY (discipline_id) REFERENCES discipline(id));