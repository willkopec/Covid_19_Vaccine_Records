package contact.domain;

import java.math.BigInteger;

/**
 * User object
 * 
 * @author
 * 
 */
public class Contact {
	/*
	 * Correspond to the contact table
	 */
	
	private Integer patient_id;
	private String email_address; 
	private BigInteger phone_num;

	
	/**
	 * @return the patient_id
	 */
	public Integer getPatient_id() {
		return patient_id;
	}
	/**
	 * @param patient_id the patient_id to set
	 */
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	/**
	 * @return the email_address
	 */
	public String getEmail_address() {
		return email_address;
	}
	/**
	 * @param email_address the email_address to set
	 */
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	/**
	 * @return the phone_num
	 */
	public BigInteger getPhone_num() {
		return phone_num;
	}
	/**
	 * @param phone_num the phone_num to set
	 */
	public void setPhone_num(BigInteger phone_num) {
		this.phone_num = phone_num;
	}
}
