CREATE TABLE subjects
(
   subject_id serial primary key,
   name character varying(70)
);

CREATE TABLE groups
(
   group_id serial primary key,
   name character varying(30)
);

CREATE TABLE students
(
   student_id serial primary key,
   first_name character varying(30),
   middle_name character varying(30),
   last_name character varying(30),
   group_id integer,
   
   FOREIGN KEY (group_id) REFERENCES groups (group_id) ON DELETE RESTRICT
);

CREATE TABLE teachers
(
    teacher_id serial primary key,
    first_name character varying(30),
    middle_name character varying(30),
    last_name character varying(30)
);

CREATE TABLE classrooms
(
	classroom_id serial primary key,
	name character varying(30)
);

CREATE TABLE lectures
(
    lecture_id serial NOT NULL,
    subject_id integer NOT NULL,
    group_id integer NOT NULL,
    teacher_id integer NOT NULL,
    classroom_id integer NOT NULL,

    CONSTRAINT unq_lectures_lecture_id UNIQUE (lecture_id),
    PRIMARY KEY (subject_id, group_id, teacher_id, classroom_id),

    FOREIGN KEY (subject_id) REFERENCES subjects (subject_id) ON DELETE CASCADE,
    FOREIGN KEY (group_id) REFERENCES groups (group_id) ON DELETE CASCADE,
    FOREIGN KEY (teacher_id) REFERENCES teachers (teacher_id) ON DELETE CASCADE,
    FOREIGN KEY (classroom_id) REFERENCES classrooms (classroom_id) ON DELETE CASCADE
);

CREATE TABLE lectures_sets
(
    lectures_set_id serial NOT NULL,
    name varchar(10) NOT NULL,

    PRIMARY KEY (lectures_set_id)
);

CREATE TABLE lectures_sets_lectures
(
    lectures_set_id integer NOT NULL,
    lecture_id integer NOT NULL,

    PRIMARY KEY (lectures_set_id, Lecture_id),
    FOREIGN KEY (lectures_set_id) REFERENCES lectures_sets(lectures_set_id) ON DELETE RESTRICT,
    FOREIGN KEY (lecture_id) REFERENCES lectures(lecture_id) ON DELETE RESTRICT
);

CREATE TYPE day_of_week AS ENUM ('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY');
CREATE TYPE parity AS ENUM ('ODD', 'EVEN');
CREATE TYPE lesson AS ENUM ('FIRST', 'SECOND', 'THIRD', 'FOURTH', 'FIFTH', 'SIXTH');


CREATE TABLE schedule
(
    day_of_week day_of_week NOT NULL,
    parity parity NOT NULL,
    lesson lesson NOT NULL,
    lecture_set_id integer NOT NULL,

    PRIMARY KEY (day_of_week, parity, lesson),

    FOREIGN KEY (lecture_set_id) REFERENCES lectures_sets (lectures_set_id) ON DELETE RESTRICT
);
