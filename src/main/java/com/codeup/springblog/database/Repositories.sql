CREATE DATABASE IF NOT EXISTS jpa_exercise_db;

CREATE USER jpa_user@localhost IDENTIFIED BY 'password';
GRANT ALL ON jpa_exercise_db.* TO jpa_user@localhost;