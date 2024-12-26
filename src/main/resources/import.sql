INSERT INTO tb_category(name) VALUES ('IT');
INSERT INTO tb_category(name) VALUES ('Books');
INSERT INTO tb_category(name) VALUES ('Electronics');

INSERT INTO tb_product(name, description, price, img_url) VALUES ('Laptop', 'Very good', 5400.0, 'https://example.com/laptop.jpg');
INSERT INTO tb_category_product(category_id, product_id) VALUES (1, 1);
INSERT INTO tb_product(name, description, price, img_url) VALUES ('Desktop', 'High performance desktop', 6500.0, 'https://example.com/desktop.jpg');
INSERT INTO tb_category_product(category_id, product_id) VALUES (1, 2);
INSERT INTO tb_product(name, description, price, img_url) VALUES ('Monitor', '4K Ultra HD Monitor', 1200.0, 'https://example.com/monitor.jpg');
INSERT INTO tb_category_product(category_id, product_id) VALUES (1, 3);


INSERT INTO tb_product(name, description, price, img_url) VALUES ('Java Programming', 'Comprehensive guide to Java', 120.0, 'https://example.com/java-book.jpg');
INSERT INTO tb_category_product(category_id, product_id) VALUES (2, 4);
INSERT INTO tb_product(name, description, price, img_url) VALUES ('Spring Boot in Action', 'Learn Spring Boot step by step', 150.0, 'https://example.com/spring-boot.jpg');
INSERT INTO tb_category_product(category_id, product_id) VALUES (2, 5);

INSERT INTO tb_product(name, description, price, img_url) VALUES ('Smartphone', 'Latest model smartphone', 3500.0, 'https://example.com/smartphone.jpg');
INSERT INTO tb_category_product(category_id, product_id) VALUES (3, 6);
INSERT INTO tb_product(name, description, price, img_url) VALUES ('Headphones', 'Noise-cancelling headphones', 800.0, 'https://example.com/headphones.jpg');
INSERT INTO tb_category_product(category_id, product_id) VALUES (3, 7);
INSERT INTO tb_product(name, description, price, img_url) VALUES ('Smartwatch', 'Feature-packed smartwatch', 1500.0, 'https://example.com/smartwatch.jpg');
INSERT INTO tb_category_product(category_id, product_id) VALUES (3, 8);

INSERT INTO tb_user(name, email, phone, password, birth_date) VALUES ('Joao', 'joao@test.com', '9997-9999', '123456', '2001-04-20');
INSERT INTO tb_user(name, email, phone, password, birth_date) VALUES ('Ana', 'ana@test.com', '9999-9999', '13579', '1998-07-14');

INSERT INTO tb_order(moment, status, user_id) VALUES (TIMESTAMP WITH TIME ZONE '2024-05-07T20:43:12Z', 2, 1);
INSERT INTO tb_order(moment, status, user_id) VALUES (TIMESTAMP WITH TIME ZONE '2024-05-03T16:22:07Z', 3, 1);
INSERT INTO tb_order(moment, status, user_id) VALUES (TIMESTAMP WITH TIME ZONE '2024-05-07T13:11:58Z', 0, 2);

INSERT INTO tb_order_item(order_id, product_id, quantity, price) VALUES (1, 6, 1, 3500.0);
INSERT INTO tb_order_item(order_id, product_id, quantity, price) VALUES (2, 4, 1, 120.0);
INSERT INTO tb_order_item(order_id, product_id, quantity, price) VALUES (2, 3, 2, 2400.0);
INSERT INTO tb_order_item(order_id, product_id, quantity, price) VALUES (3, 7, 2, 1600.0);

INSERT INTO tb_payment(order_id, moment) VALUES (1, TIMESTAMP WITH TIME ZONE '2024-06-01T15:32:49Z');
INSERT INTO tb_payment(order_id, moment) VALUES (2, TIMESTAMP WITH TIME ZONE '2024-06-03T09:22:14Z');