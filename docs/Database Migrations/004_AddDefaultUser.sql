insert into users (username, email, name, password, active, createdIn)
values ('admin', 'admin@email', 'admin', 'admin',1, strftime('%s', 'now'));

insert into migrations (dbVersion) values (4);