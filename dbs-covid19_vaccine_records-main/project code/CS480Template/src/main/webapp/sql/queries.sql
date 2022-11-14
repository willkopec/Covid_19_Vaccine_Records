CREATE VIEW string_aggregate AS
SELECT COUNT(*) AS Count
FROM patient
WHERE gender = "F";

CREATE VIEW numeric_aggregate AS
SELECT MIN(p_phone_num) AS Phone
FROM primary_physician;

CREATE VIEW dose_2_date_aggregate AS
SELECT type_2, MAX(dose_2_date) AS latest_date
FROM dose_2
GROUP BY type_2;

CREATE VIEW dose_1_group_aggregate AS
SELECT COUNT(type_1)
FROM dose_1
GROUP BY(type_1);


CREATE VIEW gmail_email AS
Select *
FROM Contact
WHERE email_address LIKE "%@gmail.com"
ORDER BY email_address;

CREATE VIEW physicians_illinois AS
SELECT p_last_name, p_first_name
FROM primary_physician
WHERE p_state = "IL"
ORDER BY p_last_name;

CREATE VIEW address_chicago AS
SELECT *
FROM address
WHERE city = "Chicago";

CREATE VIEW dose_1_moderna AS
SELECT *
FROM dose_1
WHERE type_1 = "Moderna"
ORDER BY patient_id;



CREATE VIEW complex_exist AS
SELECT p_state
FROM primary_physician 
WHERE EXISTS (SELECT patient_id FROM patient);

CREATE VIEW complex_join_covid AS
SELECT mh.notes, pp.p_last_name
FROM medical_history mh JOIN primary_physician pp USING(patient_id)
WHERE mh.contracted_covid IN ("2022-01-05") AND pp.p_zip = 60606
GROUP BY pp.p_last_name, mh.notes
ORDER BY pp.p_last_name;

CREATE VIEW complex_join_p_and_c AS
SELECT *
FROM patient p JOIN contact c USING(patient_id)
WHERE EXISTS(SELECT patient_id FROM patient);

CREATE VIEW complex_not_exist AS
SELECT first_name, last_name 
FROM patient 
WHERE NOT EXISTS (SELECT * FROM dose_1);

