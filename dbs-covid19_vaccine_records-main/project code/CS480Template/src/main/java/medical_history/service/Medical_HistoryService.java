package medical_history.service;


import java.util.List;

import medical_history.dao.Medical_HistoryDao;
import medical_history.domain.Medical_History;

/**
 * logic functions such as register, login
 * @author Priyanka Patel
 *
 */
public class Medical_HistoryService {
	private Medical_HistoryDao entity1Dao = new Medical_HistoryDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Medical_History form) throws Medical_HistoryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Medical_History entity1 = entity1Dao.findByID(form.getPatient_id());
		if(entity1.getPatient_id()!=null && entity1.getPatient_id() == form.getPatient_id()) throw new Medical_HistoryException("This medical history has been registered!");
		entity1Dao.add(form);
	}
	
	public List<Object> findCovidDate() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return entity1Dao.findCovidDate();
		
	}
}
