create table tasks
(
    taskId        INTEGER PRIMARY KEY,
    name          TEXT NOT NULL,
    description   TEXT NOT NULL,
    currentStatus TEXT NOT NULL,
    responsible   INT  NOT NULL,
    createdIn     INT  NOT NULL,
    updatedIn     INT  NULL,
    projectId     INT  NOT NULL,
    FOREIGN KEY (responsible) REFERENCES users (userId),
    FOREIGN KEY (projectId) REFERENCES projects (projectId)
);

insert into migrations (dbVersion) values (5);