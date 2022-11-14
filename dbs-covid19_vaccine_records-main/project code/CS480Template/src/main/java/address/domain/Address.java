package address.domain;

import java.sql.Date;

/**
 * Patient object
 * 
 * @author Aayush Makharia
 * 
 */
public class Address {
	/*
	 * Correspond to the user table
	 */
	
	private Integer patient_id;
	private String streetAddress;
	private Integer zipCode; 
	private String city; 
	private String state;



	public Integer getPatient_id() {
		return patient_id;
	}



	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}



	public String getAddress() {
		return streetAddress;
	}



	public void setAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}



	public Integer getZip() {
		return zipCode;
	}



	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}


}
