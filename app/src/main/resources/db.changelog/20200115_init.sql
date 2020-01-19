CREATE TABLE auction_cart
(
    id SERIAL NOT NULL,
    auction INTEGER NOT NULL,
    amount INTEGER NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (auction) REFERENCES auction(id)
);

CREATE TABLE shopping_cart
(
    id SERIAL NOT NULL,
    auction_cart INTEGER NOT NULL,
    owner VARCHAR NOT NULL,
    last_change DATE NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (auction_cart) REFERENCES auction_cart(id),
    FOREIGN KEY (owner) REFERENCES profile(username)
);