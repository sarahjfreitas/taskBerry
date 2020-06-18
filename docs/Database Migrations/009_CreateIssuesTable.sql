create table issues
(
    issueId INTEGER PRIMARY KEY,
    taskId    INT  NOT NULL,
    title   TEXT NOT NULL,
    createdIn INT  NOT NULL,
    createdBy INT  NOT NULL,

    FOREIGN KEY (createdBy) REFERENCES users (userId),
    FOREIGN KEY (taskId) REFERENCES tasks (taskId)
);

drop table comments;

create table comments
(
    commentId INTEGER PRIMARY KEY,
    issueId    INT  NOT NULL,
    content   TEXT NOT NULL,
    createdIn INT  NOT NULL,
    createdBy INT  NOT NULL,

    FOREIGN KEY (createdBy) REFERENCES users (userId),
    FOREIGN KEY (issueId) REFERENCES issues (issueId)
);

insert into migrations (dbVersion) values (9);