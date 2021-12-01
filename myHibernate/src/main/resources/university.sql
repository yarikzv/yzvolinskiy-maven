DROP DATABASE If EXISTS university;

CREATE DATABASE university;
USE university;

CREATE TABLE study_groups
(
    id         INT NOT NULL AUTO_INCREMENT,
    group_name VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE students
(
    id             INT NOT NULL AUTO_INCREMENT,
    name           VARCHAR(255) DEFAULT NULL,
    study_group_id INT          DEFAULT NULL,
    became_year    INT          DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (study_group_id) REFERENCES study_groups (id)
);

CREATE TABLE departments
(
    id              INT NOT NULL AUTO_INCREMENT,
    department_name VARCHAR(50) DEFAULT NULL,
    department_head VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE teachers
(
    id            INT NOT NULL AUTO_INCREMENT,
    teacher_name  VARCHAR(255) DEFAULT NULL,
    department_id INT          DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (department_id) REFERENCES departments (id)
);

CREATE TABLE courses
(
    id          INT NOT NULL AUTO_INCREMENT,
    course_name VARCHAR(50) DEFAULT NULL,
    teacher_id  INT         DEFAULT NULL,
    semester    INT         DEFAULT NULL,
    year        INT         DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (teacher_id) REFERENCES teachers (id)
);

CREATE TABLE scores
(
    id         INT NOT NULL AUTO_INCREMENT,
    course_id  INT DEFAULT NULL,
    student_id INT DEFAULT NULL,
    score      INT DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (student_id) REFERENCES students (id),
    FOREIGN KEY (course_id) REFERENCES courses (id)
);