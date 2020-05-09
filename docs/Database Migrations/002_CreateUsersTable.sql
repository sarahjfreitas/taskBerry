create table users (
    userId INTEGER PRIMARY KEY,
    username TEXT NOT NULL,
    email TEXT NOT NULL,
    name TEXT NOT NULL,
    password TEXT NOT NULL,
    active INTEGER,
    createdIn INT NOT NULL,
    createdBy INT NOT NULL,
    updatedIn INT NULL,
    updatedBy INT NULL,
    disabledIn INT NULL,
    disabledBy INT NULL
);

insert into migrations (dbVersion) values (2);