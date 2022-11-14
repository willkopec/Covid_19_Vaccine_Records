CREATE database covid19_vaccine_records;

use covid19_vaccine_records;

CREATE TABLE patient(
	patient_id INT UNIQUE NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	dob DATE NOT NULL,
	gender CHAR(1) NOT NULL,
	
	PRIMARY KEY (patient_id)
);

CREATE TABLE address(
    	patient_id INT UNIQUE NOT NULL,
    	street_address VARCHAR(50) NOT NULL,
    	zip_code INT NOT NULL,
    	city VARCHAR(50) NOT NULL,
   	state CHAR(2) NOT NULL,
    
    	PRIMARY KEY(patient_id, street_address),
    	FOREIGN KEY(patient_id)
		REFERENCES patient(patient_id)
		ON DELETE CASCADE
);

CREATE TABLE contact(
	patient_id INT UNIQUE NOT NULL,
	email_address VARCHAR(50) NOT NULL,
	phone_num BIGINT SIGNED NOT NULL,
	
	PRIMARY KEY(patient_id),
	FOREIGN KEY(patient_id)
		REFERENCES patient(patient_id)
		ON DELETE CASCADE

);

CREATE TABLE primary_physician(
	patient_id INT UNIQUE NOT NULL,
	p_first_name VARCHAR(50) NOT NULL,
	p_last_name VARCHAR(50) NOT NULL,
	p_zip INT NOT NULL,
	p_state CHAR(2) NOT NULL,
	p_city VARCHAR(50) NOT NULL,
	p_phone_num BIGINT SIGNED NOT NULL,
	p_street_address VARCHAR(50) NOT NULL,
	
	PRIMARY KEY(p_phone_num, patient_id),
	FOREIGN KEY(patient_id)
		REFERENCES patient(patient_id)
		ON DELETE CASCADE
);


CREATE TABLE medical_history(
    	patient_id INT UNIQUE NOT NULL,
	notes VARCHAR(200),
	pre_existing_conditions VARCHAR(200),
	contracted_covid DATE,
    
    	PRIMARY KEY(patient_id),
	FOREIGN KEY(patient_id)
		REFERENCES patient(patient_id)
		ON DELETE CASCADE
);

CREATE TABLE dose_1(
    	patient_id INT NOT NULL UNIQUE,
	type_1 VARCHAR(10) NOT NULL CHECK(type_1 IN ('Moderna', 'Pfizer', 'J&J')),
	lot_num_1 VARCHAR(10) NOT NULL,
	dose_1_date DATE NOT NULL,
	location_1 VARCHAR(50) NOT NULL,
	
	PRIMARY KEY (patient_id),
	FOREIGN KEY(patient_id)
		REFERENCES patient(patient_id)
		ON DELETE CASCADE

);

CREATE TABLE dose_2(
	patient_id INT NOT NULL UNIQUE,
	type_2 VARCHAR(10) NOT NULL CHECK(type_2 IN ('Moderna', 'Pfizer', 'J&J')),
	lot_num_2 VARCHAR(10) NOT NULL,
	dose_2_date DATE NOT NULL,
	location_2 VARCHAR(50) NOT NULL,
    
	PRIMARY KEY (patient_id),
   	FOREIGN KEY (patient_id)
		REFERENCES dose_1(patient_id)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE booster(
	patient_id INT NOT NULL UNIQUE,
	type_b VARCHAR(10) NOT NULL CHECK(type_b IN ('Moderna', 'Pfizer', 'J&J')),
	lot_num_b VARCHAR(10) NOT NULL,
	dose_b_date DATE NOT NULL,
	location_b VARCHAR(50) NOT NULL,
	
	PRIMARY KEY (patient_id),
	FOREIGN KEY (patient_id)
		REFERENCES dose_2(patient_id)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE user
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);


CREATE TABLE entity1 
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);
