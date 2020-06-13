create table history
(
    historyId INTEGER PRIMARY KEY,
    taskId   INT NOT NULL,
    oldStatus TEXT NOT NULL,
    newStatus TEXT NOT NULL,
    oldResponsible INT NOT NULL,
    newResponsible INT NOT NULL,
    createdIn INT  NOT NULL,
    createdBy INT  NOT NULL,
    description TEXT NULL,

    FOREIGN KEY (createdBy) REFERENCES users (userId),
    FOREIGN KEY (taskId) REFERENCES tasks (taskId)
);
insert into migrations (dbVersion) values (8);