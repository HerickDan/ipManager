CREATE TABLE basket_stock(
    id SERIAL PRIMARY KEY,
    api_id VARCHAR(255) NOT NULL UNIQUE,
    quantity INTEGER NOT NULL,
    updated_at VARCHAR(255)
);