package dose_2.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Jonathan Chen
 * 
 */
public class Dose_2 {
	/*
	 * Correspond to the user table
	 */
	
	private Integer patient_id;
	private String type;
	private String lot_number;
	private Date date_of_dose;
	private String location;
	
	
	public Integer getPatient_id() {
		return this.patient_id;
	}
	
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getLot_number() {
		return this.lot_number;
	}
	
	public void setLot_number(String lot_number) {
		this.lot_number = lot_number;
	}
	
	public Date getDate_of_dose() {
		return this.date_of_dose;
	}
	
	public void setDate_of_dose(Date date_of_dose) {
		this.date_of_dose = date_of_dose;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
}
