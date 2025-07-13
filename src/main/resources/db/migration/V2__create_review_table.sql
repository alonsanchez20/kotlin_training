
CREATE TABLE IF NOT EXISTS review (
    id BIGSERIAL PRIMARY KEY,
    comment VARCHAR(255) NOT NULL,
    product_id BIGINT NOT NULL,
    CONSTRAINT fk_review_product FOREIGN KEY (product_id) REFERENCES product(id)
    );