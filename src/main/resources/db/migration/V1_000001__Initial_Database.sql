CREATE TABLE dbo.customer (
    id uniqueidentifier NOT NULL UNIQUE,
    created_at datetime NOT NULL,
    updated_at datetime NULL,
    first_name varchar(50),
    last_name varchar(50),
    birthdate date NOT NULL,
    email varchar(100) UNIQUE ,
    document varchar(20) UNIQUE ,
    cellphone varchar(15) NULL UNIQUE ,
    is_active BIT DEFAULT 'TRUE',
    PRIMARY KEY (id)
);

CREATE TABLE dbo.address (
    id uniqueidentifier NOT NULL UNIQUE,
    created_at datetime NULL,
    updated_at datetime NULL,
    street varchar(60),
    number varchar(6),
    complement varchar(10),
    district varchar(50),
    zipcode varchar(10),
    city varchar(50),
    state varchar(2),
    country varchar(30),
    id_customer UNIQUEIDENTIFIER,
    PRIMARY KEY (id),
    FOREIGN key(id_customer) REFERENCES customer(id)
);