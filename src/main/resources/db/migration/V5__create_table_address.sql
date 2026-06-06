CREATE TABLE address(
    name VARCHAR(255) NOT NULL,
    complement VARCHAR(255),
    number INT NOT NULL,
    resident INTEGER,
    CONSTRAINT member_id_fk FOREIGN KEY (resident) REFERENCES beneficiaries(id)
)