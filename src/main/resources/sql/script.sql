CREATE TABLE COMPANIES
(
    id_company BIGINT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(250) NOT NULL UNIQUE
);

CREATE TABLE Persons
(
    id_person  BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_company BIGINT       NOT NULL,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    age        INTEGER      NOT NULL,
    gender     VARCHAR(20)  NOT NULL,
    weight     DOUBLE       NOT NULL,
    height     DOUBLE       NOT NULL,
    FOREIGN KEY (id_company) REFERENCES COMPANIES (id_company)
);

DROP TABLE Persons;

DROP TABLE COMPANIES;

CREATE TABLE Events
(
    id_event    BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(250) NOT NULL UNIQUE,
    description VARCHAR(250) NULL,
    date_start  DATETIME     NOT NULL,
    date_finish DATETIME     NOT NULL
);

CREATE TABLE Persons_events
(
    id_person_event   BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_event          BIGINT   NOT NULL,
    id_person         BIGINT   NOT NULL,
    date_registration DATETIME NOT NULL,
    FOREIGN KEY (id_event) REFERENCES Events (id_event),
    FOREIGN KEY (id_person) REFERENCES Persons (id_person)
);

DROP TABLE Events;

DROP TABLE Persons_events;