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
