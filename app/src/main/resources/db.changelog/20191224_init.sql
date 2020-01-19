CREATE TABLE parameter
(
    id SERIAL NOT NULL,
    name VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE branch
(
    id SERIAL NOT NULL,
    name VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE category
(
    id SERIAL NOT NULL,
    name VARCHAR(255) NOT NULL,
    branch INTEGER NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (branch) REFERENCES branch(id)
);

CREATE TABLE auction
(
    id SERIAL NOT NULL,
    owner VARCHAR NOT NULL,
    category INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    description TEXT,
    is_edited BOOLEAN DEFAULT FALSE,

    PRIMARY KEY (id),
    FOREIGN KEY (owner) REFERENCES profile(username),
    FOREIGN KEY (category) REFERENCES category(id)
);

CREATE TABLE photos
(
    id SERIAL NOT NULL,
    auction_id INTEGER NOT NULL,
    file VARCHAR(255) NOT NULL,

    FOREIGN KEY (auction_id) REFERENCES auction(id),
    PRIMARY KEY (id)
);

CREATE TABLE auction_parameter
(
    auction INTEGER,
    param INTEGER NOT NULL,
    value VARCHAR(255) NOT NULL,

    PRIMARY KEY (auction, param),
    FOREIGN KEY (param) REFERENCES parameter(id),
    FOREIGN KEY (auction) REFERENCES auction(id)
);

ALTER TABLE profile ADD admin boolean;

--Admin password: Admin1
INSERT INTO profile (username, password, name, surname, email, birthday, admin) VALUES
('admin',
 '$2a$10$rWKQ3DIcvV5LQKujLPd2f.N2R/yUJsRZNJ0D2mtrV50k/2nBwHDRi',
 'Wojciech',
 'Skarbek',
 'admin@fakemail.com',
 '09/08/1998',
 TRUE);

INSERT INTO profile (username, password, name, surname, email, birthday, admin) VALUES
('pivo',
 '$2a$10$awP/IolGB5HN6Fh7hhypre/IZNE1bFFIzu4NPAJVQeSp5HW0NEr/q',
 'Ivo',
 'Piotr',
 'pivo@fakemail.com',
 '17/03/1928',
 false);

INSERT INTO branch (id, name) VALUES (0, 'Mobile Phones and Smartphones'),
                                     (1, 'Computers and Tablets'),
                                     (2, 'RTV'),
                                     (3, 'Video games'),
                                     (4, 'AGD'),
                                     (5, 'Cameras');

INSERT INTO category (name, branch) VALUES ('Mobile Phones', 0),
                                           ('Smartphones', 0),
                                           ('Desktop computers', 1),
                                           ('Laptops', 1),
                                           ('Tablets', 1),
                                           ('Television', 2),
                                           ('Video game consoles', 3),
                                           ('Video games', 3),
                                           ('Washing machines', 4),
                                           ('4k Cameras', 5);

