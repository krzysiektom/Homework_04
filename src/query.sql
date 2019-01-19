CREATE database user
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE users
(
  id    INT auto_increment PRIMARY KEY,
  email VARCHAR(255) unique,
  name  VARCHAR(255)
);

CREATE database guestbook
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

CREATE TABLE Guestbooks
(
  id    INT auto_increment PRIMARY KEY,
  name VARCHAR(255),
  text  VARCHAR(255)
);