CREATE SEQUENCE hibernate_sequence;

CREATE TABLE profile
(
    username    VARCHAR NOT NULL,
    password    VARCHAR NOT NULL,
    name        VARCHAR NOT NULL,
    surname     VARCHAR NOT NULL,
    email       VARCHAR NOT NULL,
    birthday    VARCHAR NOT NULL,

    PRIMARY KEY (username)
);