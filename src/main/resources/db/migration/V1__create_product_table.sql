-- src/main/resources/db/migration/V1__create_product_table.sql


CREATE TABLE IF NOT EXISTS product (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL UNIQUE,
    price INT NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS product_id_seq START WITH 1 INCREMENT BY 1;