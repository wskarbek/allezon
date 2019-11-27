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

INSERT INTO profile (username, password, name, surname, email, birthday, admin) VALUES
                    ('jesieniarz',
                     '$2a$10$aE.SCh1tvQSs6wV0V8GowO36WV2oKpQYSHc9/qTlJ4g/m4LukH/ge',
                     'Wojciech',
                     'Skarbek',
                     'woj.skarbek@gmail.com',
                     '09/08/1998',
                     TRUE);