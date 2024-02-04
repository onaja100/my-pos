CREATE TABLE accounts (
      no INTEGER AUTO_INCREMENT PRIMARY KEY,
      type VARCHAR(255),
      name VARCHAR(255),
      balance DECIMAL
);

CREATE TABLE items (
      id INTEGER AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255),
      category VARCHAR(255),
      barcode VARCHAR(255) UNIQUE,
      price DECIMAL
);

CREATE TABLE cart (
      id INTEGER AUTO_INCREMENT PRIMARY KEY,
      code VARCHAR(255),
      quantity INTEGER,
      price DECIMAL,
      buyid INTEGER,
      date_time DATETIME,
      FOREIGN KEY (code) REFERENCES items(barcode)
);


CREATE TABLE update_item (
      id INTEGER AUTO_INCREMENT PRIMARY KEY,
      price DECIMAL,         
      date DATE,              -- YYYY-MM-DD
      code VARCHAR(255)
);

CREATE TABLE venders (
      id INTEGER AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255),
      code VARCHAR(255),
      qty_pack INTEGER,
      price DECIMAL
);