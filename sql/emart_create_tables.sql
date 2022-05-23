CREATE SCHEMA AUTHORIZATION glushchenko;

-- integrity constraints for varchar field lengths
-- will be adjusted at the end of this project.

CREATE TABLE customer_types(
    id VARCHAR2(256) NOT NULL,
    type VARCHAR2(256) NOT NULL,
    CONSTRAINT customer_types_pk PRIMARY KEY (id)
);

CREATE TABLE customers(
    id VARCHAR2(256) NOT NULL,
    password VARCHAR2(256) NOT NULL,
    name VARCHAR2(256),
    email VARCHAR2(256) NOT NULL,
    address VARCHAR2(256),
    customer_type VARCHAR2(256) NOT NULL,
    status VARCHAR2(256) NOT NULL,
    CONSTRAINT customers_pk PRIMARY KEY (id),
    CONSTRAINT customers_email_unique UNIQUE (email),
    CONSTRAINT customers_customer_types_fk FOREIGN KEY (customer_type) REFERENCES customer_types(id)
);

CREATE TABLE categories(
    id VARCHAR2(256) NOT NULL,
    name VARCHAR2(256) NOT NULL,
    CONSTRAINT categories_pk PRIMARY KEY (id),
    CONSTRAINT categories_name_unique UNIQUE (name)
);

CREATE TABLE manufacturers(
    id VARCHAR2(256) NOT NULL,
    name VARCHAR2(256) NOT NULL,
    CONSTRAINT manufacturers_pk PRIMARY KEY (id),
    CONSTRAINT msnufacturers_name_unique UNIQUE (name)
);

CREATE TABLE products(
    id VARCHAR2(256) NOT NULL,
    categories_id VARCHAR2(256) NOT NULL,
    manufacturers_id VARCHAR2(256) NOT NULL,
    model_number VARCHAR2(256) NOT NULL,
    warranty NUMBER(38),
    price FLOAT(63) NOT NULL,
    CONSTRAINT products_pk PRIMARY KEY (id),
    CONSTRAINT products_categories_fk FOREIGN KEY (categories_id) REFERENCES categories(id),
    CONSTRAINT products_manufacturers_fk FOREIGN KEY (manufacturers_id) REFERENCES manufacturers(id)
);

CREATE TABLE product_attributes(
    id VARCHAR2(256) NOT NULL,
    name VARCHAR2(256) NOT NULL,
    CONSTRAINT product_attributes_pk PRIMARY KEY (id),
    CONSTRAINT product_attributes_name_unique UNIQUE (name)
);

CREATE TABLE product_attributes_values(
    products_id VARCHAR2(256) NOT NULL,
    product_attributes_id VARCHAR2(256) NOT NULL,
    value FLOAT(63),
    units VARCHAR2(10),
    CONSTRAINT product_attributes_values_pk PRIMARY KEY (products_id, product_attributes_id),
    CONSTRAINT product_attributes_values_products_fk FOREIGN KEY (products_id) REFERENCES products(id),
    CONSTRAINT product_attributes_values_product_attributes_fk FOREIGN KEY (product_attributes_id) REFERENCES product_attributes(id)
);

CREATE TABLE product_compatibilities(
    products_id VARCHAR2(256) NOT NULL,
    compatible_products_id VARCHAR2(256) NOT NULL,
    CONSTRAINT product_compatibilities_pk PRIMARY KEY (products_id, compatible_products_id),
    CONSTRAINT product_compatibilities_products_fk FOREIGN KEY (products_id) REFERENCES products(id),
    CONSTRAINT product_compatibilities_compatible_products_fk FOREIGN KEY (compatible_products_id) REFERENCES products(id)
);

CREATE TABLE orders(
    id VARCHAR2(256) NOT NULL,
    customers_id VARCHAR2(256) NOT NULL,
    checked_out_at NUMBER(38),
    discount FLOAT(63),
    shipping_and_handling FLOAT(63),
    total FLOAT(63),
    CONSTRAINT orders_pk PRIMARY KEY (id),
    CONSTRAINT orders_customers_fk FOREIGN KEY (customers_id) REFERENCES customers(id)
);

CREATE TABLE order_lines(
    orders_id VARCHAR2(256) NOT NULL,
    products_id VARCHAR2(256) NOT NULL,
    created_at NUMBER(38) NOT NULL,
    price FLOAT(63) NOT NULL,
    count NUMBER(10) NOT NULL,
    CONSTRAINT order_lines_pk PRIMARY KEY (orders_id, products_id),
    CONSTRAINT order_lines_orders_fk FOREIGN KEY (orders_id) REFERENCES orders(id),
    CONSTRAINT order_lines_products_fk FOREIGN KEY (products_id) REFERENCES products(id)
);

CREATE TABLE pricing_rules(
    id VARCHAR2(256) NOT NULL,
    name VARCHAR2(256) NOT NULL,
    value FLOAT(63) NOT NULL,
    CONSTRAINT pricing_rules_pk PRIMARY KEY (id),
    CONSTRAINT pricing_rules_name_unique UNIQUE (name)
);