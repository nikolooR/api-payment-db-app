--liquibase formatted sql

--changeset nikolajs:1

CREATE TABLE payment
(
    payment_id UUID NOT NULL PRIMARY KEY,
    amount DECIMAL(19,4) NOT NULL,
    debtor_iban VARCHAR(34) NOT NULL,
    created_at TIMESTAMP NOT NULL
)