-- products table
CREATE TABLE products (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    description TEXT NOT NULL
);

CREATE SEQUENCE products_id_sequence INCREMENT 50;

INSERT INTO products (id, name, price, description)
VALUES
(1, 'Pork ear', 1.55, 'Delisious pork ear for your pet.'),
(2, 'Granules', 2.99, 'Delisious granules for your pet.'),
(3, 'Seeds', 1.0, 'Delisious seeds for your pet.'),
(4, 'Leash', 4.0, 'Practical leash for your pet.'),
(5, 'Toy', 2.55, 'Awesome toy for your pet.'),
(6, 'Pork ear 2', 1.55, 'Delisious pork ear for your pet.'),
(7, 'Granules 2', 2.99, 'Delisious granules for your pet.'),
(8, 'Seeds 2', 1.0, 'Delisious seeds for your pet.'),
(9, 'Leash 2', 4.0, 'Practical leash for your pet.'),
(10, 'Toy 2', 2.55, 'Awesome toy for your pet.'),
(11, 'Pork ear 3', 1.55, 'Delisious pork ear for your pet.'),
(12, 'Granules 3', 2.99, 'Delisious granules for your pet.'),
(13, 'Seeds 3', 1.0, 'Delisious seeds for your pet.'),
(14, 'Leash 3', 4.0, 'Practical leash for your pet.'),
(15, 'Toy 3', 2.55, 'Awesome toy for your pet.');

-- animal categories table
CREATE TABLE animal_categories (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE SEQUENCE animal_categories_id_sequence INCREMENT 50;

INSERT INTO animal_categories (id, name)
VALUES
(1, 'DOG'),
(2, 'CAT'),
(3, 'OTHER');

-- association table for products and animal categories
CREATE TABLE products_animal_categories (
    products_fk INTEGER REFERENCES products(id),
    animal_categories_fk INTEGER REFERENCES animal_categories(id),
    PRIMARY KEY (products_fk, animal_categories_fk)
);

CREATE SEQUENCE products_animal_categories_id_sequence INCREMENT 50;

INSERT INTO products_animal_categories (products_fk, animal_categories_fk)
VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 3),
(4, 1),
(4, 2),
(5, 1),
(5, 2),
(5, 3),
(6, 1),
(6, 2),
(7, 1),
(8, 3),
(9, 1),
(9, 2),
(10, 1),
(10, 2),
(10, 3),
(11, 1),
(11, 2),
(12, 1),
(13, 3),
(14, 1),
(14, 2),
(15, 1),
(15, 2),
(15, 3);

-- orders table
CREATE TABLE orders (
    id INTEGER PRIMARY KEY,
    total_price DOUBLE PRECISION NOT NULL,
    created_at TIMESTAMP NOT NULL,
    amount INTEGER NOT NULL
);

CREATE SEQUENCE orders_id_sequence INCREMENT 50;

INSERT INTO orders (id, total_price, created_at, amount)
VALUES
(1, 4.65, now(), 3);

-- association table for products and orders
CREATE TABLE products_orders (
    products_fk INTEGER REFERENCES products(id),
    orders_fk INTEGER REFERENCES orders(id),
    PRIMARY KEY (products_fk, orders_fk)
);

CREATE SEQUENCE products_orders_id_sequence INCREMENT 50;

INSERT INTO products_orders ( products_fk, orders_fk)
VALUES
(1, 1);
