-- populate customer_types table.
INSERT INTO customer_types (id, type) VALUES ('1', 'client');
INSERT INTO customer_types (id, type) VALUES ('2', 'manager');

-- populating customers table.
INSERT INTO customers (id, password, name, email, address, customer_type, status) VALUES ('Rhagrid', 'Rhagrid', 'Rubeus Hagrid', 'rhagrid@cs', '123 MyStreet, Goleta apt A, Ca', '1', 'Gold');
INSERT INTO customers (id, password, name, email, address, customer_type, status) VALUES ('Mhooch', 'Mhooch', 'Madam Hooch', 'mhooch@cs', '123 MyStreet, Goleta apt B, Ca', '1', 'Silver');
INSERT INTO customers (id, password, name, email, address, customer_type, status) VALUES ('Amoody', 'Amoody', 'Alastor Moody', 'amoody@cs', '123 MyStreet, Goleta apt C, Ca', '1', 'New');
INSERT INTO customers (id, password, name, email, address, customer_type, status) VALUES ('Pquirrell', 'Pquirrell', 'Professor Quirrell', 'pquirrell@cs', '123 MyStreet, Goleta apt D, Ca', '1', 'New');
INSERT INTO customers (id, password, name, email, address, customer_type, status) VALUES ('Sblack', 'Sblack', 'Sirius Black', 'sblack@cs', '123 MyStreet, Goleta apt E, Ca', '2', 'Green');
INSERT INTO customers (id, password, name, email, address, customer_type, status) VALUES ('Ddiggle', 'Ddiggle', 'Dedalus Diggle', 'ddiggle@cs', '123 MyStreet, Goleta apt F, Ca', '1', 'Green');

-- populating categories table.
INSERT INTO categories (id, name) VALUES ('1', 'Laptop');
INSERT INTO categories (id, name) VALUES ('2', 'Desktop');
INSERT INTO categories (id, name) VALUES ('3', 'Monitor');
INSERT INTO categories (id, name) VALUES ('4', 'Software');
INSERT INTO categories (id, name) VALUES ('5', 'Printer');
INSERT INTO categories (id, name) VALUES ('6', 'Camera');

-- populating manufacturers table.
INSERT INTO manufacturers (id, name) VALUES ('1', 'HP');
INSERT INTO manufacturers (id, name) VALUES ('2', 'Dell');
INSERT INTO manufacturers (id, name) VALUES ('3', 'Emachine');
INSERT INTO manufacturers (id, name) VALUES ('4', 'Envision');
INSERT INTO manufacturers (id, name) VALUES ('5', 'Samsung');
INSERT INTO manufacturers (id, name) VALUES ('6', 'Symantec');
INSERT INTO manufacturers (id, name) VALUES ('7', 'Mcafee');
INSERT INTO manufacturers (id, name) VALUES ('8', 'Cannon');

-- populating product_attributes table.
INSERT INTO product_attributes (id, name) VALUES ('1', 'Processor speed');
INSERT INTO product_attributes (id, name) VALUES ('2', 'Ram size');
INSERT INTO product_attributes (id, name) VALUES ('3', 'Hard disk size');
INSERT INTO product_attributes (id, name) VALUES ('4', 'Display size');
INSERT INTO product_attributes (id, name) VALUES ('5', 'OS');
INSERT INTO product_attributes (id, name) VALUES ('6', 'Size');
INSERT INTO product_attributes (id, name) VALUES ('7', 'Weight');
INSERT INTO product_attributes (id, name) VALUES ('8', 'Required disk size');
INSERT INTO product_attributes (id, name) VALUES ('9', 'Required RAM size');
INSERT INTO product_attributes (id, name) VALUES ('10', 'Resolution');
INSERT INTO product_attributes (id, name) VALUES ('11', 'Sheet capacity');
INSERT INTO product_attributes (id, name) VALUES ('12', 'Max zoom');

-- populating products table.
INSERT INTO products (id, categories_id, manufacturers_id, model_number, warranty, price) VALUES ('AA00101', '1', '1', '6111', 12, 1630);
INSERT INTO products (id, categories_id, manufacturers_id, model_number, warranty, price) VALUES ('AA00201', '2', '2', '420', 12, 239);
INSERT INTO products (id, categories_id, manufacturers_id, model_number, warranty, price) VALUES ('AA00202', '2', '3', '3958', 12, 369.99);
INSERT INTO products (id, categories_id, manufacturers_id, model_number, warranty, price) VALUES ('AA00301', '3', '4', '720', 36, 69.99);
INSERT INTO products (id, categories_id, manufacturers_id, model_number, warranty, price) VALUES ('AA00302', '3', '5', '712', 36, 279.99);
INSERT INTO products (id, categories_id, manufacturers_id, model_number, warranty, price) VALUES ('AA00401', '4', '6', '2005', 60, 19.99);
INSERT INTO products (id, categories_id, manufacturers_id, model_number, warranty, price) VALUES ('AA00402', '4', '7', '2005', 60, 19.99);
INSERT INTO products (id, categories_id, manufacturers_id, model_number, warranty, price) VALUES ('AA00501', '5', '1', '1320', 12, 299.99);
INSERT INTO products (id, categories_id, manufacturers_id, model_number, warranty, price) VALUES ('AA00601', '6', '1', '435', 3, 119.99);
INSERT INTO products (id, categories_id, manufacturers_id, model_number, warranty, price) VALUES ('AA00602', '6', '8', '738', 1, 329.99);

-- populating product_attributes_values table.
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00101', '1', 3.33, 'Ghz');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00101', '2', 512, 'Mb');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00101', '3', 100, 'Gb');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00101', '4', 17, '"');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00201', '1', 2.53, 'Ghz');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00201', '2', 256, 'Mb');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00201', '3', 80, 'Gb');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00201', '5', NULL, NULL);
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00202', '1', 2.9, 'Ghz');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00202', '2', 512, 'Mb');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00202', '3', 80, 'Gb');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00301', '6', 17, '"');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00301', '7', 25, ' lb.');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00302', '6', 17, '"');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00302', '7', 9.6, ' lb.');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00401', '8', 128, 'Mb');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00401', '9', 64, 'Mb');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00402', '8', 128, 'Mb');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00402', '9', 64, 'Mb');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00501', '10', 1200, 'dpi');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00501', '11', 500, NULL);
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00501', '7', 0.4, ' lb.');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00601', '10', 3.1, 'Mp');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00601', '12', 5, ' times');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00601', '7', 24.7, ' lb.');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00602', '10', 3.1, 'Mp');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00602', '12', 5, ' times');
INSERT INTO product_attributes_values (products_id, product_attributes_id, value, units) VALUES ('AA00602', '7', 24.7, ' lb.');

-- populating the product_compatibilities table.
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00301', 'AA00201');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00301', 'AA00202');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00302', 'AA00201');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00302', 'AA00202');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00401', 'AA00101');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00401', 'AA00201');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00401', 'AA00202');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00402', 'AA00101');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00402', 'AA00201');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00402', 'AA00202');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00501', 'AA00201');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00501', 'AA00202');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00601', 'AA00201');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00601', 'AA00202');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00602', 'AA00201');
INSERT INTO product_compatibilities (products_id, compatible_products_id) VALUES ('AA00602', 'AA00202');

-- orders table starts out as empty.
-- order_lines table starts out as empty.

-- populating pricing_rules table.
INSERT INTO pricing_rules (id, name, value) VALUES (1, 'new', -0.1);
INSERT INTO pricing_rules (id, name, value) VALUES (2, 'silver', -0.05);
INSERT INTO pricing_rules (id, name, value) VALUES (3, 'gold', -0.1);
INSERT INTO pricing_rules (id, name, value) VALUES (4, 'shipping_and_handling', 0.1);
INSERT INTO pricing_rules (id, name, value) VALUES (5, 'free_shipping_threshold', 100);
INSERT INTO pricing_rules (id, name, value) VALUES (6, 'green', 0);