CREATE database user
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE users
(
  id    INT auto_increment PRIMARY KEY,
  email VARCHAR(255) unique,
  name  VARCHAR(255)
);
