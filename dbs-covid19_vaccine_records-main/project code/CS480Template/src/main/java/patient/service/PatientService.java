package patient.service;


import java.util.List;

import patient.dao.PatientDao;
import patient.domain.Patient;

/**
 * logic functions such as register, login
 * @author 
 *
 */
public class PatientService {
	private PatientDao patientDao = new PatientDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Patient form) throws PatientException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Patient entity1 = patientDao.findByFirstLast(form.getFirst_name(), form.getLast_name(), form.getDob());
		//if(entity1()!=null && entity1.getFirst_name().equals(form.getFirst_name())) throw new PatientException("This user name has been registered!");
		patientDao.add(form);
	}

	public List<Object> findFemalePatients() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return patientDao.findFemalePatients();
		
	}
	

}
