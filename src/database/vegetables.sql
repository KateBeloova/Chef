DROP DATABASE IF EXISTS vegetables;
CREATE DATABASE vegetables;
USE vegetables;

CREATE TABLE vegetable ( ID int(100), NAME VARCHAR(255), CALORIES DOUBLE, FAT DOUBLE, CARBS DOUBLE);

INSERT INTO vegetable VALUES (1, 'carrot', 89.12, 56.23, 56.24);
INSERT INTO vegetable VALUES (2, 'cabbage', 57.12, 12.23, 65.24);
INSERT INTO vegetable VALUES (3, 'beet', 845.84, 77.83, 89.64);
INSERT INTO vegetable VALUES (4, 'pumpkin', 92.65, 237.53, 89.45);