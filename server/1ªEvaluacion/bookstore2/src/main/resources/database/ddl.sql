DROP DATABASE IF EXISTS bookstore;
CREATE DATABASE bookstore;
USE bookstore;

CREATE TABLE genres (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name_es VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL
);

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name_es VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL
);

CREATE TABLE publishers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL
);

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    isbn VARCHAR(13) UNIQUE NOT NULL,
    title_es VARCHAR(255) NOT NULL,
    title_en VARCHAR(255) NOT NULL,
    synopsis_es TEXT,
    synopsis_en TEXT,
    price DECIMAL(10, 2) NOT NULL,
    discount DECIMAL(5, 2) DEFAULT 0,
    cover VARCHAR(255),
    publisher_id INT,
    category_id INT,
    FOREIGN KEY (publisher_id) REFERENCES publishers(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE books_genres (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    genre_id INT,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (genre_id) REFERENCES genres(id)
);

CREATE TABLE authors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    nationality VARCHAR(255),
    biography_en TEXT,
    biography_es TEXT,
    birth_year INT,
    death_year INT
);

CREATE TABLE books_authors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    author_id INT,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    language VARCHAR(3) NOT NULL DEFAULT 'es',
    is_admin BOOLEAN NOT NULL DEFAULT 0
);

CREATE TABLE reviews (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    user_id INT,
    review TEXT,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    order_date DATE,
    delivery_date DATE,
    status INT NOT NULL DEFAULT 0,
    total DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE orders_details (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    book_id INT,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);