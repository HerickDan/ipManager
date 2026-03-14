CREATE TABLE basket_distro(
    id SERIAL PRIMARY KEY,
    api_id VARCHAR(255) NOT NULL UNIQUE,
    quantity INTEGER NOT NULL,
    updated_at TIMESTAMP,
    member_id INTEGER,
    more_than_one BOOLEAN NOT NULL,
    justify VARCHAR(255),

    CONSTRAINT member_id_fk FOREIGN KEY (member_id) REFERENCES members(id)
);