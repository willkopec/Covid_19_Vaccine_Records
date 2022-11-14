package patient.domain;

import java.sql.Date;

/**
 * Patient object
 * 
 * @author Aayush Makharia
 * 
 */
public class Patient {
	/*
	 * Correspond to the user table
	 */
	
	private Integer patient_id;
	private String first_name;
	private String last_name; 
	private Date dob;
	private Character gender;



	public Integer getPatient_id() {
		return patient_id;
	}



	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public Character getGender() {
		return gender;
	}



	public void setGender(Character gender) {
		this.gender = gender;
	}


}
