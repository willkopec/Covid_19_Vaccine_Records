package medical_history.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import medical_history.domain.CovidDate;

//import java.util.ArrayList;
//import java.util.List;

import medical_history.domain.Medical_History;
import primary_physician.domain.Primary_physician;

/**
 * DDL functions performed in database
 */
public class Medical_HistoryDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "covid19_vaccine_records"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "UICCS480Project"; //TODO change password

	public Medical_History findByID(Integer patient_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Medical_History medical_history = new Medical_History();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
		    String sql = "select * from medical_history where patient_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,patient_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer patient_id = Integer.parseInt(resultSet.getString("patient_id"));
		    	if(patient_id == patient_id_p){
		    		medical_history.setPatient_id(Integer.parseInt(resultSet.getString("patient_id")));
		    		medical_history.setNotes(resultSet.getString("notes"));
		    		medical_history.setPre_existing_conditions(resultSet.getString("pre_existing_conditions"));
		    		medical_history.setContracted_covid(java.sql.Date.valueOf(resultSet.getString("contracted_covid")));		
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return medical_history;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Medical_History form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "insert into medical_history (patient_id, notes, pre_existing_conditions, contracted_covid)  values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPatient_id());
		    preparestatement.setString(2,form.getNotes());
		    preparestatement.setString(3,form.getPre_existing_conditions());
		    preparestatement.setDate(4,form.getContracted_covid());
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
	public void update(Medical_History form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "UPDATE medical_history SET notes = ?, pre_existing_conditions = ?, contracted_covid=? where patient_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getNotes());
			preparestatement.setString(2,form.getPre_existing_conditions());
		    preparestatement.setDate(3,form.getContracted_covid());
		    preparestatement.setInt(4, form.getPatient_id());
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
	public void delete(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "delete from medical_history where patient_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findCovidDate() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			String sql = "select * from complex_join_covid";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				CovidDate covid_date = new CovidDate();
				covid_date.setNotes(resultSet.getString("notes"));
				covid_date.setP_last_name(resultSet.getString("p_last_name"));		
	    		list.add(covid_date);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
