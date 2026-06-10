CREATE TABLE basket_distro(
    id SERIAL PRIMARY KEY,
    api_id VARCHAR(255) NOT NULL UNIQUE,
    quantity INTEGER NOT NULL,
    distributed_in TIMESTAMP,
    admin_id INTEGER,
    beneficiary_id INTEGER,
    more_than_one BOOLEAN NOT NULL,
    justify VARCHAR(255),

    CONSTRAINT admin_id_fk FOREIGN KEY (admin_id) REFERENCES admins(id),
    CONSTRAINT beneficiary_id_fk FOREIGN KEY (beneficiary_id) REFERENCES beneficiaries(id)
);