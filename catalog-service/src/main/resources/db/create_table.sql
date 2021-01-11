CREATE TABLE IF NOT EXISTS products (
    ID CHAR(36) NOT NULL PRIMARY KEY,
    CATEGORY_ID CHAR(36) NOT NULL,
    TITLE VARCHAR(60) NOT NULL,
    PRICE DECIMAL(12, 2) NOT NULL,
    DESCRIPTION VARCHAR(200) NULL,
    QUANTITY INT DEFAULT 1,
    CREATED_AT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT DATETIME NULL
);

CREATE TABLE IF NOT EXISTS pictures (
    ID CHAR(36) NOT NULL PRIMARY KEY,
    PRODUCT_ID CHAR(36) NOT NULL,
    ADDRESS VARCHAR(120) NOT NULL,
    CREATED_AT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
