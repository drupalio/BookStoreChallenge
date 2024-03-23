-- create table Users
CREATE TABLE Users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255),
                       last_name VARCHAR(255),
                       email VARCHAR(255)
);

-- create table Genders
CREATE TABLE Genders (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255)
);

-- create table Books
CREATE TABLE Books (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255),
                       author VARCHAR(255),
                       id_gender BIGINT,
                       FOREIGN KEY (id_gender) REFERENCES Genders(id)
);

-- create table Inventory
CREATE TABLE Inventory (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           id_book BIGINT,
                           avalible BOOLEAN,
                           FOREIGN KEY (id_book) REFERENCES Books(id)
);

-- create table Loans
CREATE TABLE Loans (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       id_user BIGINT,
                       id_book BIGINT,
                       loan_date DATE,
                       return_date DATE,
                       FOREIGN KEY (id_user) REFERENCES Users(id),
                       FOREIGN KEY (id_book) REFERENCES Books(id)
);

-- create table Rating
CREATE TABLE Rating (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        id_user BIGINT,
                        id_book BIGINT,
                        stars INT,
                        comment TEXT,
                        FOREIGN KEY (id_user) REFERENCES Users(id),
                        FOREIGN KEY (id_book) REFERENCES Books(id)
);