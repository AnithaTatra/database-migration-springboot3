ALTER TABLE authors ADD COLUMN email VARCHAR(100) NOT NULL;
ALTER TABLE authors ADD CONSTRAINT uc_authors_email UNIQUE(email);