CREATE DATABASE IF NOT EXISTS jpa_exercise_db;

CREATE USER jpa_user@localhost IDENTIFIED BY 'password';
GRANT ALL ON jpa_exercise_db.* TO jpa_user@localhost;

USE jpa_exercise_db;
USE posts;

INSERT INTO posts (id, title, body)
VALUES
  (2, 'Chuck', 'asjjadsfjdfskjlfdskjlfsd'),
  (5, 'Fred', 'dfklfsdklfskjlfsa'),
  (3, 'Bud', 'adsfjlafsdlfsdklj'),
  (10, 'Bailey', 'sdfjklfsjlkafsd'),
  (11, 'Lexie', 'dfsjklfjklfsa'),
  (1, 'Snickers', 'fknfaslkfsdlkfsd'),
  (6, 'Red', 'kfasdkfadskjfs'),
  (8, 'Barney', 'slafjklfsajklsf'),
  (12, 'Bowser', 'sdakmfdskmlfda');