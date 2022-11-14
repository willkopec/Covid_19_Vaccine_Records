package dose_1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patient.domain.FPatientCount;
import patient.domain.Patient;

//import java.util.ArrayList;
//import java.util.List;

import dose_1.domain.dose1;
import user.domain.User;


/**
 * DDL functions performed in database
 */
public class Dose1Dao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "covid19_vaccine_records"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "UICCS480Project"; //TODO change password
	
	public dose1 findByID(Integer patient_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		dose1 patient = new dose1();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
		    String sql = "select * from dose_1 where patient_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,patient_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer patient_id= Integer.parseInt(resultSet.getString("patient_id"));

		    	if(patient_id == patient_id_p){
		    		patient.setPatient_id((resultSet.getInt("patient_id")));
		    		patient.setdose_type(resultSet.getString("type_1"));
		    		patient.setlot_num(resultSet.getString("lot_num_1"));
		    		patient.setlocation(resultSet.getString("location_1"));
		    		patient.setDoseDate(java.sql.Date.valueOf(resultSet.getString("dose_1_date")));
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
	
	public void add(dose1 form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "insert into dose_1 (patient_id, type_1, lot_num_1, dose_1_date, location_1) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPatient_id());
		    preparestatement.setString(2,form.getdose_type());
		    preparestatement.setString(3,form.getlot_num());
		    preparestatement.setDate(4,form.getDoseDate());
		    preparestatement.setString(5,form.getlocation());
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
	public void update(dose1 form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "UPDATE dose_1 SET type_1 = ?, lot_num_1 = ?, location_1 = ?, dose_1_date = ? where patient_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
		    preparestatement.setString(1,form.getdose_type());
		    preparestatement.setString(2,form.getlot_num());
		    preparestatement.setString(3,form.getlocation());
		    preparestatement.setDate(4,form.getDoseDate());
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
			
			String sql = "delete from dose_1 where patient_id = ?"; 
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

