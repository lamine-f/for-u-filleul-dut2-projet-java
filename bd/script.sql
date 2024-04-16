/*
CREATE DATABASE gestiondetaches;
GestionDesTaches.db 
**/

CREATE TABLE user (

    id_user INT AUTO_INCREMENT PRIMARY KEY, 
    `login` VARCHAR(100) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    firstname VARCHAR(150),
    lastname VARCHAR(50)

);

CREATE TABLE tasks(

    id_task INT AUTO_INCREMENT,
    title VARCHAR(250) NOT NULL,
    `data` TEXT NOT NULL,
    `state` VARCHAR(25) DEFAULT "in_process",
    
    `start` DATE NOT NULL,
    `end` DATE,
    to_id_user INT NOT NULL,

    FOREIGN KEY (to_id_user) REFERENCES user(id_user)

);