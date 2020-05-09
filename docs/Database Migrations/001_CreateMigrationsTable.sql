create table migrations (
    migrationId INTEGER PRIMARY KEY,
    dbVersion INTEGER NOT NULL
);

insert into migrations (dbVersion) values (1);