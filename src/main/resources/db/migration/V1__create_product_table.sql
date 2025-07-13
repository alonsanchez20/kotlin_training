-- src/main/resources/db/migration/V1__create_product_table.sql
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS electronic_product CASCADE;
DROP SEQUENCE IF EXISTS product_id_seq;

CREATE TABLE IF NOT EXISTS product (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL UNIQUE,
    price DOUBLE PRECISION NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS electronic_product (
    id BIGINT NOT NULL,
    warranty_months INT NOT NULL,
    CONSTRAINT electronic_product_pk PRIMARY KEY (id),
    CONSTRAINT fk_product FOREIGN KEY (id) REFERENCES product(id)
    );

CREATE SEQUENCE IF NOT EXISTS product_id_seq START WITH 1 INCREMENT BY 1;