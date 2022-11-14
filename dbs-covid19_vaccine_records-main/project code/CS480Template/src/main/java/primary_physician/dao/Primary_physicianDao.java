package primary_physician.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import primary_physician.domain.PPComplex;

//import java.util.ArrayList;
//import java.util.List;

import primary_physician.domain.Primary_physician;


/**
 * DDL functions performed in database
 */
public class Primary_physicianDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "covid19_vaccine_records"; //TODO change user
	
	/**
	 * password of your user name to connect to the database
	 */
	private String MySQL_password = "UICCS480Project"; //TODO change password

	public Primary_physician findByID(Integer patient_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Primary_physician primary_physician = new Primary_physician();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
		    String sql = "select * from primary_physician where patient_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,patient_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer patient_id = Integer.parseInt(resultSet.getString("patient_id"));
		    	if(patient_id == patient_id_p){
		    		primary_physician.setPatient_id(Integer.parseInt(resultSet.getString("patient_id")));
		    		primary_physician.setp_first_name(resultSet.getString("p_first_name"));
		    		primary_physician.setp_last_name(resultSet.getString("p_last_name"));
		    		primary_physician.setp_street_address(resultSet.getString("p_street_address"));
		    		primary_physician.setp_city(resultSet.getString("p_city"));
		    		primary_physician.setp_state(resultSet.getString("p_state"));
		    		primary_physician.setp_zip(resultSet.getInt("p_zip"));	
		    		primary_physician.setp_phone_num(new BigInteger(resultSet.getString("p_phone_num")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return primary_physician;
	}	
	
	/**
	 * insert Primary_physician
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Primary_physician form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "insert into primary_physician (patient_id, p_first_name, p_last_name, p_street_address, p_city, p_state, p_zip, p_phone_num) values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPatient_id());
		    preparestatement.setString(2,form.getp_first_name());
		    preparestatement.setString(3,form.getp_last_name());
		    preparestatement.setString(4,form.getp_street_address());
		    preparestatement.setString(5,form.getp_city()); 
		    preparestatement.setString(6,form.getp_state());
		    preparestatement.setInt(7,form.getp_zip());
		    preparestatement.setLong(8,Long.parseLong(form.getp_phone_num().toString()));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
//	/**
//	 * @param form
//	 * @throws ClassNotFoundException
//	 * @throws InstantiationException
//	 * @throws IllegalAccessException
//	 */
	public void update(Primary_physician form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "UPDATE primary_physician SET p_first_name = ?, p_last_name = ?, p_street_address=?, p_city = ?, p_state = ?, p_zip = ?, p_phone_num=?  where patient_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getp_first_name());
			preparestatement.setString(2,form.getp_last_name());
			preparestatement.setString(3,form.getp_street_address());
			preparestatement.setString(4,form.getp_city());
			preparestatement.setString(5,form.getp_state());
			preparestatement.setInt(6,form.getp_zip());
		    preparestatement.setLong(7,Long.parseLong(form.getp_phone_num().toString()));
		    preparestatement.setInt(8,form.getPatient_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param patient_id_p
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String patient_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			
			String sql = "delete from primary_physician where patient_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setInt(1,Integer.parseInt(patient_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	public List<Object> findILPhys() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			String sql = "select * from physicians_illinois";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Primary_physician primary_physician = new Primary_physician();
				primary_physician.setp_last_name(resultSet.getString("p_last_name"));
				primary_physician.setp_first_name(resultSet.getString("p_first_name"));
	    		
	    		list.add(primary_physician);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	public List<Object> complexExist() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			String sql = "select * from complex_exist";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				PPComplex ppExist = new PPComplex();
				ppExist.setPp_state(resultSet.getString("p_state"));    
	    		list.add(ppExist);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	
	public List<Object> minAggPhone() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_vaccine_records", MySQL_user, MySQL_password);
			String sql = "select * from numeric_aggregate";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Primary_physician primary_physician = new Primary_physician();
				primary_physician.setp_phone_num(new BigInteger(resultSet.getString("Phone")));
	    		list.add(primary_physician);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	
}
