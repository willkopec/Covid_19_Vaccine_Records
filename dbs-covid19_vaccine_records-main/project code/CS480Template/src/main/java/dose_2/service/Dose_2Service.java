package dose_2.service;


import java.util.List;

import dose_2.dao.Dose_2Dao;
import dose_2.domain.Dose_2;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class Dose_2Service {
	private Dose_2Dao dose_2Dao = new Dose_2Dao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Dose_2 form) throws Dose_2Exception, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Dose_2 dose_2 = dose_2Dao.findByID(form.getPatient_id());
		if(dose_2.getPatient_id()!=null && dose_2.getPatient_id().equals(form.getPatient_id())) throw new Dose_2Exception("This user name has been registered!");
		dose_2Dao.add(form);
	}
	
	public List<Object> findLatestDoseByType() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return dose_2Dao.findLatestDoseByType();
		
	}
}
