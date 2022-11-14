package patient.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patient.domain.FPatientCount;

//import java.util.ArrayList;
//import java.util.List;

import patient.domain.Patient;
import user.domain.User;


/**
 * DDL functions performed in database
 */
public class PatientDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "covid19_vaccine_records"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "UICCS480Project"; //TODO change password

	public Patient findByFirstLast(String first_name_p, String last_name_p, Date dob_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Patient patient = new Patient();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
		    String sql = "select * from patient where first_name = ? and last_name=? and dob = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,first_name_p);
		    preparestatement.setString(2, last_name_p);
		    preparestatement.setDate(3, dob_p);

		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String first_name= (resultSet.getString("first_name"));
		    	String last_name= (resultSet.getString("last_name"));
		    	Date dob = (java.sql.Date.valueOf(resultSet.getString("dob")));

		    	if(first_name.equals(first_name_p) && last_name.equals(last_name_p)&&dob.equals(dob_p)){
		    		patient.setPatient_id((resultSet.getInt("patient_id")));
		    		patient.setFirst_name(resultSet.getString("first_name"));
		    		patient.setLast_name(resultSet.getString("last_name"));
		    		patient.setDob(java.sql.Date.valueOf(resultSet.getString("dob")));
		    		patient.setGender(resultSet.getString("gender").charAt(0));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return patient;
	}	
	
	public Patient findByID(Integer patient_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Patient patient = new Patient();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
		    String sql = "select * from patient where patient_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,patient_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer patient_id= Integer.parseInt(resultSet.getString("patient_id"));

		    	if(patient_id == patient_id_p){
		    		patient.setPatient_id((resultSet.getInt("patient_id")));
		    		patient.setFirst_name(resultSet.getString("first_name"));
		    		patient.setLast_name(resultSet.getString("last_name"));
		    		patient.setDob(java.sql.Date.valueOf(resultSet.getString("dob")));
		    		patient.setGender(resultSet.getString("gender").charAt(0));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return patient;
	}
	
	/**
	 * insert Patient
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Patient form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "insert into patient (first_name, last_name, dob, gender) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFirst_name());
		    preparestatement.setString(2,form.getLast_name());
		    preparestatement.setDate(3,form.getDob());
		    preparestatement.setString(4,form.getGender().toString());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Patient form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "UPDATE patient SET first_name = ?, last_name = ?, dob = ?, gender = ? where patient_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,form.getFirst_name());
			preparestatement.setString(2,form.getLast_name());
		    preparestatement.setDate(3,form.getDob());
		    preparestatement.setString(4,form.getGender().toString());
			preparestatement.setInt(5,form.getPatient_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String patient_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "delete from patient where patient_id = ?"; 
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(patient_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Object> findFemalePatients() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			String sql = "select * from string_aggregate";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				FPatientCount fPatient = new FPatientCount();
				fPatient.setCount(Integer.parseInt(resultSet.getString("Count")));
	    
	    		list.add(fPatient);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}

