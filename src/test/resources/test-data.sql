 drop table if exists purchase cascade;
CREATE TABLE IF NOT EXISTS purchase(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    buyer BIGINT,
    seller BIGINT,
    type BIGINT,
    name VARCHAR(255),
    date TIMESTAMP
);

INSERT INTO purchase (buyer, seller, type, name, date) VALUES (1, 101, 201, 'Phone', TIMESTAMP '2024-05-24 10:00:00');
INSERT INTO purchase (buyer, seller, type, name, date) VALUES (2, 102, 202, 'Laptop', TIMESTAMP '2024-05-24 11:00:00');
INSERT INTO purchase (buyer, seller, type, name, date) VALUES (3, 103, 203, 'Tablet', TIMESTAMP '2024-05-24 12:00:00');
INSERT INTO purchase (buyer, seller, type, name, date) VALUES (6, 104, 204, 'Smartwatch', TIMESTAMP '2024-05-24 13:00:00');
INSERT INTO purchase (buyer, seller, type, name, date) VALUES (5, 105, 205, 'Headphones', TIMESTAMP '2024-05-24 14:00:00');
INSERT INTO purchase (buyer, seller, type, name, date) VALUES (6, 106, 206, 'Camera', TIMESTAMP '2024-05-24 15:00:00');
INSERT INTO purchase (buyer, seller, type, name, date) VALUES (7, 107, 207, 'Speaker', TIMESTAMP '2024-05-24 16:00:00');
INSERT INTO purchase (buyer, seller, type, name, date) VALUES (8, 108, 208, 'Monitor', TIMESTAMP '2024-05-24 17:00:00');
INSERT INTO purchase (buyer, seller, type, name, date) VALUES (9, 109, 209, 'Printer', TIMESTAMP '2024-05-24 18:00:00');
INSERT INTO purchase (buyer, seller, type, name, date) VALUES (10, 110, 210, 'Router', TIMESTAMP '2024-05-24 19:00:00');