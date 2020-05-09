create table projects (
    projectId INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    active INTEGER,
    createdIn INT NOT NULL,
    createdBy INT NOT NULL,
    updatedIn INT NULL,
    updatedBy INT NULL,
    disabledIn INT NULL,
    disabledBy INT NULL,

    FOREIGN KEY (createdBy) REFERENCES users(userId),
    FOREIGN KEY (updatedBy) REFERENCES users(userId),
    FOREIGN KEY (disabledBy) REFERENCES users(userId)
);

insert into migrations (dbVersion) values (3);