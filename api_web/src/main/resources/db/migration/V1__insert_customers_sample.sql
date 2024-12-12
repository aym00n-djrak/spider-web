-- Ajout de l'extension uuid-ossp pour générer des uuid de type 4
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Création de la table "customer"
CREATE TABLE IF NOT EXISTS customer (
    id UUID PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
    );

-- Insertion de quelques données dans la table "customer"
INSERT INTO customer (id, first_name, last_name, email)
VALUES
    (uuid_generate_v4(), 'John', 'Doe', 'john.doe@example.com'),
    (uuid_generate_v4(), 'Jane', 'Doe', 'jane.doe@example.com'),
    (uuid_generate_v4(), 'Jim', 'Beam', 'jim.beam@example.com'),
    (uuid_generate_v4(), 'Jack', 'Daniels', 'jack.daniels@example.com');
