-- Drop the table if it exists
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS author;

-- Create the table
CREATE TABLE author (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name TEXT,
    age NUMERIC
);

CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title TEXT,
    authorId BIGINT,
    FOREIGN KEY (authorId) REFERENCES author(id)
);