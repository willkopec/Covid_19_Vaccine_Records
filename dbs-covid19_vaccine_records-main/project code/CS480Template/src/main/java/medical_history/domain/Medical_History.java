package medical_history.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Priyanka Patel
 * 
 */
public class Medical_History {
	/*
	 * Correspond to the user table
	 */
	
	private Integer patient_id;
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
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * @return the pre_exisitng_conditions
	 */
	public String getPre_existing_conditions() {
		return pre_existing_conditions;
	}
	/**
	 * @param pre_exisitng_conditions the pre_exisitng_conditions to set
	 */
	public void setPre_existing_conditions(String pre_existing_conditions) {
		this.pre_existing_conditions = pre_existing_conditions;
	}
	/**
	 * @return the contracted_covid
	 */
	public Date getContracted_covid() {
		return contracted_covid;
	}
	/**
	 * @param contracted_covid the contracted_covid to set
	 */
	public void setContracted_covid(Date contracted_covid) {
		this.contracted_covid = contracted_covid;
	}
	private String notes;
	private String pre_existing_conditions;
	private Date contracted_covid;
	

}
