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
    description TEXT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (owner) REFERENCES profile(username),
    FOREIGN KEY (category) REFERENCES category(id)
);

CREATE TABLE photos
(
    id INTEGER NOT NULL,
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