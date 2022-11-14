package booster_dose.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import booster_dose.domain.Booster_Dose;

/**
 * DDL functions performed in database
 */
public class Booster_DoseDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "covid19_vaccine_records"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "UICCS480Project"; //TODO change password

	public Booster_Dose findByID(Integer patient_id_input) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Booster_Dose booster_dose = new Booster_Dose();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
		    String sql = "select * from booster where patient_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,patient_id_input);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer patient_id_search = Integer.parseInt(resultSet.getString("patient_id"));
		    	if(patient_id_search == patient_id_input){
		    		booster_dose.setPatient_id(Integer.parseInt(resultSet.getString("patient_id")));
		    		booster_dose.setType(resultSet.getString("type_b"));
		    		booster_dose.setLot_number(resultSet.getString("lot_num_b"));
		    		booster_dose.setDate_of_dose(java.sql.Date.valueOf(resultSet.getString("dose_b_date")));
		    		booster_dose.setLocation(resultSet.getString("location_b"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return booster_dose;
	}	
	
	/**
	 * insert Booster_Dose
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Booster_Dose form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "insert into booster (patient_id, type_b, lot_num_b, dose_b_date, location_b) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPatient_id());
		    preparestatement.setString(2,form.getType());
		    preparestatement.setString(3,form.getLot_number());
		    preparestatement.setDate(4,form.getDate_of_dose());
		    preparestatement.setString(5,form.getLocation());
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
	public void update(Booster_Dose form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "UPDATE booster SET type_b = ?, lot_num_b = ?, dose_b_date = ?, location_b = ? where patient_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getType());
		    preparestatement.setString(2,form.getLot_number());
		    preparestatement.setDate(3,form.getDate_of_dose());
		    preparestatement.setString(4,form.getLocation());
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
	public void delete(String patient_id_input) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "delete from booster where patient_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(patient_id_input));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
