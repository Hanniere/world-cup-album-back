CREATE TABLE IF NOT EXISTS album (
  id INT NOT NULL PRIMARY KEY,
  user_id INT NOT NULL,
  price DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS sticker (
  id INT NOT NULL PRIMARY KEY,
  team VARCHAR(50) DEFAULT NULL,
  picture VARCHAR(50) DEFAULT NULL,
  name VARCHAR(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS album_sticker (
    album_id VARCHAR(50) NOT NULL,
    sticker_id VARCHAR(50) NOT NULL,
    FOREIGN KEY (album_id) REFERENCES album (id),
    FOREIGN KEY (sticker_id) REFERENCES sticker (id),
    UNIQUE INDEX user_authority_idx_1 (album_id, sticker_id)
);