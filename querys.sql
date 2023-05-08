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
    
     
CREATE TABLE courses (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE coordinators (
    id UUID PRIMARY KEY,
    user_id UUID REFERENCES users(id),
    created_at DATE NOT NULL DEFAULT CURRENT_DATE,
    updated_at DATE
);

CREATE TABLE coordinators_courses (
    coordinator_id UUID NOT NULL,
    course_id UUID NOT NULL,
    PRIMARY KEY (coordinator_id, course_id),
    FOREIGN KEY (coordinator_id) REFERENCES coordinators(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);

