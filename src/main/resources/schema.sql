drop table if exists comments;

create table comments(
    when varchar(40) primary key, comment varchar(500)
);

-- insert into comments values (now(), 'Alv');
