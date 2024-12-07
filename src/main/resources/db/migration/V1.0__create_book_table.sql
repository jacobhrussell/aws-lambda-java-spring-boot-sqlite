-- SQLite
-- CREATE TABLE book
-- (
--     id    INTEGER PRIMARY KEY AUTOINCREMENT,
--     title TEXT NOT NULL
-- );

-- Postgres
CREATE TABLE book
(
    id    integer generated always as identity primary key,
    title varchar not null
);