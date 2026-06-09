ALTER TABLE cellphone
ADD COLUMN country_code INT;

ALTER TABLE cellphone
ADD COLUMN ddd INT;

ALTER TABLE cellphone
ADD COLUMN prefix_line INT;

ALTER TABLE cellphone
ADD COLUMN phone_owner INTEGER NOT NULL;

ALTER TABLE cellphone
ADD CONSTRAINT member_id_fk FOREIGN KEY (phone_owner) REFERENCES beneficiaries(id);

