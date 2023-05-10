CREATE TABLE users (
  id UUID PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL,
  registration_number VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  created_at DATE NOT NULL DEFAULT CURRENT_DATE,
  updated_at DATE
);

CREATE TABLE roles (
  id UUID PRIMARY KEY NOT NULL,
  name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users_roles (
  user_id UUID NOT NULL,
  role_id UUID NOT NULL,
  PRIMARY KEY (user_id, role_id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id)
);


INSERT INTO roles (id, name) VALUES 
    (gen_random_uuid(), 'ROLE_ADMIN'), 
    (gen_random_uuid(), 'ROLE_TEACHER'), 
    (gen_random_uuid(), 'ROLE_COORDINATOR'), 
    (gen_random_uuid(), 'ROLE_USER');
    
     
CREATE TABLE COURSES (
  id UUID PRIMARY KEY NOT NULL,
  name varchar(50) not null unique,
  acronym varchar(10) not null unique,
  description varchar(250) not null 
);

Create table courses_coordinators (
	course_id UUID NOT NULL,
   user_id UUID NOT NULL,
  primary key (course_id, user_id),
  Foreign key (user_id) references users(id),
  Foreign key (course_id) references courses(id)
);
 
Create table courses_teachers (
	course_id UUID NOT NULL,
   user_id UUID NOT NULL,
  primary key (course_id, user_id),
  Foreign key (user_id) references users(id),
  Foreign key (course_id) references courses(id)
);

Create Table Class (
	    id UUID PRIMARY KEY NOT NULL,
    	acronym VARCHAR(50) NOT NULL,
  		course_id UUID References Courses(id) NOT NULL
);


Create table class_teachers (
	class_id UUID NOT NULL,
   user_id UUID NOT NULL,
  primary key (class_id, user_id),
  Foreign key (user_id) references users(id),
  Foreign key (class_id) references class(id)
);