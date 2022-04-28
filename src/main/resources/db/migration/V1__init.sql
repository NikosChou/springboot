create table USER_ENTITY (
    uuid uuid not null primary key,
    last_name varchar,
    first_name varchar,
    created_at date,
    gender varchar(1)
);

INSERT INTO
    USER_ENTITY (uuid, last_name, first_name, created_at, gender)
VALUES
    (gen_random_uuid() ,'Choustoulakis', 'Nikolaos', CURRENT_DATE, 'M');