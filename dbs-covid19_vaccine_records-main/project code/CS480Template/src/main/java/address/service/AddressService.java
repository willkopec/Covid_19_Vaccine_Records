package address.service;


import java.util.List;

import contact.service.ContactException;
import address.dao.AddressDao;
import address.domain.Address;

/**
 * logic functions such as register, login
 * @author 
 *
 */
public class AddressService {
	private AddressDao dose1Dao = new AddressDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Address form) throws AddressException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Address entity1 = dose1Dao.findByID(form.getPatient_id());
		//if(entity1.getPatient_id()!=null && entity1.getPatient_id().equals(form.getPatient_id()))throw new Dose1Exception("The contact for this patient id has been registered!");
		dose1Dao.add(form);
	}

	//public List<Object> findFemalePatients() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	///	return patientDao.findFemalePatients();
		
	//}
	

}
