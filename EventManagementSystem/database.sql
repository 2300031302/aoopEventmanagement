-- Create the database
CREATE DATABASE IF NOT EXISTS eventmgmt;
USE eventmgmt;

-- Table for Users (Module 1: User Management)
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Table for Events (Module 2: Event Management)
CREATE TABLE events (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    date VARCHAR(50) NOT NULL
);

-- Table for Registrations (Module 3: Registration Management)
CREATE TABLE registrations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    event_id VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (event_id) REFERENCES events(id)
);

-- Table for Tickets (Module 4: Ticketing System)
CREATE TABLE tickets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    event_id VARCHAR(50),
    quantity INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (event_id) REFERENCES events(id)
);

-- Table for Payments (Module 6: Payment Processing)
CREATE TABLE payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    card VARCHAR(20) NOT NULL,
    amount DOUBLE NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Sample Data
INSERT INTO users (username, email, password) VALUES 
('john_doe', 'john@example.com', 'password123'),  -- In production, hash passwords
('jane_smith', 'jane@example.com', 'password456');

INSERT INTO events (id, name, date) VALUES 
('event123', 'Concert Night', '2025-04-01 18:00:00'),
('event124', 'Tech Conference', '2025-05-15 09:00:00');

INSERT INTO registrations (user_id, event_id) VALUES 
(1, 'event123'),
(2, 'event124');

INSERT INTO tickets (user_id, event_id, quantity) VALUES 
(1, 'event123', 2),
(2, 'event124', 1);

INSERT INTO payments (user_id, card, amount) VALUES 
(1, '1234-5678-9012-3456', 50.00),
(2, '9876-5432-1098-7654', 100.00);