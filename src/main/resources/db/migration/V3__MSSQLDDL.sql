CREATE TABLE addresses (
  address_id bigint IDENTITY (1, 1) NOT NULL,
   address_city varchar(255),
   address_street varchar(255),
   CONSTRAINT pk_addresses PRIMARY KEY (address_id)
)
GO

CREATE TABLE contacts (
  contact_id bigint IDENTITY (1, 1) NOT NULL,
   contact_email_address varchar(255),
   contact_phone_number varchar(255),
   contact_address_id bigint,
   CONSTRAINT pk_contacts PRIMARY KEY (contact_id)
)
GO

CREATE TABLE persons (
  person_id bigint IDENTITY (1, 1) NOT NULL,
   person_name varchar(255),
   temporary_address_address_id bigint,
   permanent_address_address_id bigint,
   CONSTRAINT pk_persons PRIMARY KEY (person_id)
)
GO

ALTER TABLE contacts ADD CONSTRAINT FK_CONTACTS_ON_CONTACT_ADDRESS FOREIGN KEY (contact_address_id) REFERENCES addresses (address_id)
GO

ALTER TABLE persons ADD CONSTRAINT FK_PERSONS_ON_PERMANENTADDRESS_ADDRESS FOREIGN KEY (permanent_address_address_id) REFERENCES addresses (address_id)
GO

ALTER TABLE persons ADD CONSTRAINT FK_PERSONS_ON_TEMPORARYADDRESS_ADDRESS FOREIGN KEY (temporary_address_address_id) REFERENCES addresses (address_id)
GO