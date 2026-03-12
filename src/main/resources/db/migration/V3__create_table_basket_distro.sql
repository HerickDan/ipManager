CREATE TABLE basket_distro(
    id SERIAL PRIMARY KEY,
    api_id VARCHAR(255) NOT NULL UNIQUE,
    quantity INTEGER NOT NULL,
    updated_at VARCHAR(255),
    member_id VARCHAR(255),
    more_than_one BOOLEAN NOT NULL,
    justify VARCHAR(255),

   FOREIGN KEY (member_id) REFERENCES members(id)
);