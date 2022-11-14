package primary_physician.domain;

import java.math.BigInteger;

/**
 * User object
 * 
 * @author Priyanka Patel
 * 
 */
public class Primary_physician {
	
	
	private Integer patient_id;
	private String p_first_name;
	private String p_last_name;
	private Integer p_zip;
	private String p_state;
	private String p_city;
	private BigInteger p_phone_num;
	private String p_street_address;
	
	

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
	 * @return the p_first_name
	 */
	public String getp_first_name() {
		return p_first_name;
	}
	/**
	 * @param p_first_name the p_first_name to set
	 */
	public void setp_first_name(String p_first_name) {
		this.p_first_name = p_first_name;
	}
	
	
	/**
	 * @return the p_last_name
	 */
	public String getp_last_name() {
		return p_last_name;
	}
	/**
	 * @param p_last_name the p_first_name to set
	 */
	public void setp_last_name(String p_last_name) {
		this.p_last_name = p_last_name;
	}
	
	
	/**
	 * @return the p_zip
	 */
	public Integer getp_zip() {
		return p_zip;
	}
	/**
	 * @param p_zip the p_zip to set
	 */
	public void setp_zip(Integer p_zip) {
		this.p_zip = p_zip;
	}
	
	
	/**
	 * @return the p_state
	 */
	public String getp_state() {
		return p_state;
	}
	/**
	 * @param p_zip the p_zip to set
	 */
	public void setp_state(String p_state) {
		this.p_state = p_state;
	}
	
	
	/**
	 * @return the p_phone_num
	 */
	public BigInteger getp_phone_num() {
		return p_phone_num;
	}
	/**
	 * @param p_phone_num the p_phone_num to set
	 */
	public void setp_phone_num(BigInteger p_phone_num) {
		this.p_phone_num = p_phone_num;
	}
	
	
	/**
	 * @return the p_city
	 */
	public String getp_city() {
		return p_city;
	}
	/**
	 * @param p_phone_num the p_phone_num to set
	 */
	public void setp_city(String p_city) {
		this.p_city = p_city;
	}
	
	
	
	
	/**
	 * @return the p_street_address
	 */
	public String getp_street_address() {
		return p_street_address;
	}
	/**
	 * @param p_street_address the p_street_address to set
	 */
	public void setp_street_address(String p_street_address) {
		this.p_street_address = p_street_address;
	}
	
	
}
