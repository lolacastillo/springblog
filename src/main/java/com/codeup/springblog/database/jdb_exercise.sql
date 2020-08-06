CREATE DATABASE IF NOT EXISTS jpa_exercise_db;

CREATE USER jpa_user@localhost IDENTIFIED BY 'password';
GRANT ALL ON jpa_exercise_db.* TO jpa_user@localhost;

USE jpa_exercise_db;
USE posts;

Drop table posts;
Drop table users;

TRUNCATE

INSERT INTO posts (id, title, body,user_id)
VALUES
  (1, 'Post 1', 'You know what? It is beets. I''ve crashed into a beet truck.',1),
  (2, 'Post 2', 'They''re using our own satellites against us.',1),
  (3, 'Post 3', 'My dad once told me, laugh and the world laughs with you, Cry, and I''ll give you something to cry about you little bastard!',1),
  (4, 'Post 4', 'Hey, you know how I''m, like, always trying to save the planet? ',2),
  (5, 'Post 5', 'Here''s my chance. Life finds a way.',3),
  (6, 'Post 6', 'You''re a very talented young man, with your own clever thoughts and ideas.',4),
  (7, 'Post 7', 'Do you need a manager? So you two dig up, dig up dinosaurs? Forget the fat lady! ',5),
  (8, 'Post 8', 'You''re obsessed with the fat lady! Drive us out of here!',5),
  (9, 'Post 9', 'Did he just throw my cat out of the window? I gave it a cold? I gave it a virus.',2);

INSERT INTO users (id,email,password,username)
VALUES
  (1, 'chuck@example.com', 'password','chuck'),
  (2, 'fred@example.com', 'password','fred'),
  (3, 'bud@example.com', 'password','bud'),
  (4, 'bailey@example.com', 'password','bailey'),
  (5, 'lexie@example.com', 'password','lexie');
