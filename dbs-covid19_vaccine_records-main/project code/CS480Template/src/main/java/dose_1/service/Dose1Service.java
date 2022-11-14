package dose_1.service;


import java.util.List;

import dose_1.dao.Dose1Dao;
import dose_1.domain.dose1;

/**
 * logic functions such as register, login
 * @author 
 *
 */
public class Dose1Service {
	private Dose1Dao dose1Dao = new Dose1Dao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(dose1 form) throws Dose1Exception, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		dose1 entity1 = dose1Dao.findByID(form.getPatient_id());
		if(entity1.getPatient_id()!=null && entity1.getPatient_id().equals(form.getPatient_id()))throw new Dose1Exception("The contact for this patient id has been registered!");
			dose1Dao.add(form);
	}

	//public List<Object> findFemalePatients() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	///	return patientDao.findFemalePatients();
		
	//}
	

}
