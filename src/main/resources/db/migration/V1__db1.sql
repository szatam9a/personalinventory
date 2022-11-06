CREATE TABLE addresses (
  address_id BIGINT AUTO_INCREMENT NOT NULL,
   address_city VARCHAR(255) NULL,
   address_street VARCHAR(255) NULL,
   CONSTRAINT pk_addresses PRIMARY KEY (address_id)
);

CREATE TABLE contacts (
  contact_id BIGINT AUTO_INCREMENT NOT NULL,
   contact_email_address VARCHAR(255) NULL,
   contact_phone_number VARCHAR(255) NULL,
   contact_address_id BIGINT NULL,
   CONSTRAINT pk_contacts PRIMARY KEY (contact_id)
);

CREATE TABLE persons (
  person_id BIGINT AUTO_INCREMENT NOT NULL,
   person_name VARCHAR(255) NULL,
   temporary_address_address_id BIGINT NULL,
   permanent_address_address_id BIGINT NULL,
   CONSTRAINT pk_persons PRIMARY KEY (person_id)
);

ALTER TABLE contacts ADD CONSTRAINT FK_CONTACTS_ON_CONTACT_ADDRESS FOREIGN KEY (contact_address_id) REFERENCES addresses (address_id);

ALTER TABLE persons ADD CONSTRAINT FK_PERSONS_ON_PERMANENTADDRESS_ADDRESS FOREIGN KEY (permanent_address_address_id) REFERENCES addresses (address_id);

ALTER TABLE persons ADD CONSTRAINT FK_PERSONS_ON_TEMPORARYADDRESS_ADDRESS FOREIGN KEY (temporary_address_address_id) REFERENCES addresses (address_id);