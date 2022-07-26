-- DELETE ALL --
DROP SCHEMA computers CASCADE;
------------------------------

-- CREATE SCHEMA --
CREATE SCHEMA computers;
SET SCHEMA 'computers';

-- Device TABLE --
CREATE TABLE IF NOT EXISTS device
(
    device_id     serial PRIMARY KEY,
    device_type   varchar(30) NOT NULL CHECK ( device_type IN ('Chromebook', 'BIB', 'Type 3', 'Type 4')),
    purchase_date DATE CHECK ( purchase_date > TO_DATE('01-01-2000', 'dd-MM-YYYY')),
    serial_number varchar(30) NOT NULL
);

-- User TABLE --
CREATE TABLE IF NOT EXISTS users
(
    user_id      serial PRIMARY KEY,
    user_type    varchar(30) NOT NULL CHECK ( user_type IN ('Student', 'Employee', 'Set', 'Room')),
    user_name    varchar(60) NOT NULL,
    user_sec_val varchar(30)
);

-- Loan TABLE --
CREATE TABLE IF NOT EXISTS loan
(
    loan_id   serial PRIMARY KEY,
    user_id   smallint NOT NULL,
    device_id smallint NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (device_id) REFERENCES device (device_id)
);

-- TRIGGER - Is device available --
CREATE OR REPLACE FUNCTION device_available() RETURNS trigger AS
$BODY$
DECLARE
    vLoanCount NUMERIC;

BEGIN

    SELECT COUNT(*)
    INTO vLoanCount
    FROM loan
    WHERE device_id = new.device_id;

    IF (vLoanCount > 0) THEN
        RAISE EXCEPTION 'Device % is already on loan', new.device_id;
    END IF;
    RETURN new;

END;
$BODY$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS device_availability ON loan;

CREATE TRIGGER device_availability
    BEFORE INSERT
    ON loan
    FOR EACH ROW
EXECUTE PROCEDURE device_available();

-- TRIGGER - Does User already have a booking --
CREATE OR REPLACE FUNCTION user_check() RETURNS TRIGGER AS
$BODY$
DECLARE
    vLoanCount NUMERIC;

BEGIN

    SELECT COUNT(*)
    INTO vLoanCount
    FROM loan l,
         users u
    WHERE l.user_id = new.user_id
      AND (u.user_id = l.user_id AND u.user_type IN ('Employee', 'Student'));


    IF (vLoanCount > 0) THEN
        RAISE EXCEPTION 'User % already has a device!', new.user_id;
    END IF;
    RETURN new;

END;
$BODY$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS user_check_for_loans ON loan;

CREATE TRIGGER user_check_for_loans
    BEFORE INSERT
    ON loan
    FOR EACH ROW
EXECUTE PROCEDURE user_check();

-- Device TESTING --
INSERT INTO device
(device_type,
 purchase_date,
 serial_number)
VALUES ('Chromebook', '01-08-2022', 'serial1'),
       ('BIB', '01-01-2001', 'serial234');

-- User TESTING --
INSERT INTO users (user_type, user_name, user_sec_val)
VALUES ('Employee', 'Christian Pedersen', 'CHP'),
       ('Student', 'Karoline', '2.a'),
       ('Room', '131', NULL),
       ('Set', 'A', NULL);

-- Loan TESTING --
INSERT INTO loan(user_id, device_id)
VALUES (4, 1),
       (4, 2);
