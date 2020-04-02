CREATE TABLE Persons
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY UNIQUE,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    age        INTEGER      NOT NULL,
    gender     VARCHAR(20)  NOT NULL,
    weight     DOUBLE       NOT NULL,
    height     DOUBLE       NOT NULL
);