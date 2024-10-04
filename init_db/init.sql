CREATE DATABASE IF NOT EXISTS Pagamento CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE Pagamento;
INSERT INTO users (username, password) VALUES ('admin', 'hashed_password') ON DUPLICATE KEY UPDATE username = username;