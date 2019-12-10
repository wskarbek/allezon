CREATE SEQUENCE hibernate_sequence;

CREATE TABLE profile
(
    username    VARCHAR NOT NULL,
    password    VARCHAR NOT NULL,
    name        VARCHAR NOT NULL,
    surname     VARCHAR NOT NULL,
    email       VARCHAR NOT NULL,
    birthday    VARCHAR NOT NULL,
    admin       BOOLEAN NOT NULL,

    PRIMARY KEY (username)
);
--Admin password: Admin1
INSERT INTO profile (username, password, name, surname, email, birthday, admin) VALUES
                    ('admin',
                     '$2a$10$rWKQ3DIcvV5LQKujLPd2f.N2R/yUJsRZNJ0D2mtrV50k/2nBwHDRi',
                     'Wojciech',
                     'Skarbek',
                     'admin@fakemail.com',
                     '09/08/1998',
                     TRUE);