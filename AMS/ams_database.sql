DROP TABLE IF EXISTS user_table;
CREATE TABLE user_table (
    user_id INT UNSIGNED AUTO_INCREMENT,
    user_name VARCHAR(32) NOT NULL UNIQUE,
    user_password VARCHAR(32) NOT NULL UNIQUE,
    occupation TINYINT NOT NULL,
    id_number VARCHAR(8) NOT NULL,
    real_name VARCHAR(16) NOT NULL,
    PRIMARY KEY(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS assignment_table;
CREATE TABLE assignment_table (
    assignment_id INT UNSIGNED AUTO_INCREMENT,
    subject_id INT UNSIGNED NOT NULL,
    teacher_id VARCHAR(8) NOT NULL,
    teacher_name VARCHAR(16) NOT NULL,
    file_name VARCHAR(64) NOT NULL UNIQUE,
    submission_date DATE,
    PRIMARY KEY(assignment_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS submission_table;
CREATE TABLE submission_table (
    submission_id INT UNSIGNED AUTO_INCREMENT,
    subject_id INT UNSIGNED NOT NULL,
    student_id VARCHAR(8) NOT NULL,
    student_name VARCHAR(16) NOT NULL,
    file_name VARCHAR(64) NOT NULL UNIQUE,
    score TINYINT,
    submission_date DATE,
    PRIMARY KEY(submission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS subject_table;
CREATE TABLE subject_table (
    subject_id INT UNSIGNED AUTO_INCREMENT,
    subject_name VARCHAR(32) NOT NULL,
    teacher_id VARCHAR(8) NOT NULL,
    teacher_name VARCHAR(16) NOT NULL,
    PRIMARY KEY(subject_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO subject_table(subject_id, subject_name, teacher_id, teacher_name)
VALUES
    (1, "微分几何", "t0000001", "陈省身"),
    (2, "量子力学", "t0000002", "Feynman"),
    (3, "面向对象程序设计", "t0000003", "高连生"),
    (4, "英语写作", "t0000004", "Jackson");
