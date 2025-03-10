DROP DATABASE IF EXISTS sportspile;

CREATE DATABASE sportspile CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci;

USE sportspile;

CREATE TABLE IF NOT EXISTS discipline (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(500));

CREATE TABLE IF NOT EXISTS user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    registration_date DATETIME NOT NULL,
    password VARCHAR(100) NOT NULL);

CREATE TABLE IF NOT EXISTS user_role (
    username VARCHAR(50) NOT NULL,
    role_name VARCHAR(20) NOT NULL DEFAULT 'USER',
    PRIMARY KEY (username, role_name),
    FOREIGN KEY (username) REFERENCES user(username));

CREATE TABLE IF NOT EXISTS news (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(80) NOT NULL,
    url VARCHAR(500) NOT NULL UNIQUE,
    description VARCHAR(500) NOT NULL,
    date_added DATETIME NOT NULL,
    disciplineId INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (disciplineId) REFERENCES discipline(id),
    FOREIGN KEY (user_id) REFERENCES user(id));

CREATE TABLE IF NOT EXISTS vote (
    user_id INT NOT NULL,
    news_id INT NOT NULL,
    type ENUM('UP', 'DOWN') NOT NULL,
    date_added DATETIME NOT NULL,
    PRIMARY KEY (user_id, news_id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (news_id) REFERENCES news(id));