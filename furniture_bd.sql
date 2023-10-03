CREATE DATABASE furniture_bd;

\c furniture_bd;

CREATE TABLE IF NOT EXISTS public.furniture
(
    id          serial PRIMARY KEY,
    name        character varying(100) NOT NULL,
    description text                   NOT NULL,
    color       character varying(50)  NOT NULL,
    price       numeric(9, 2)          NOT NULL,
    weight      numeric(9, 2)          NOT NULL
);