package booster_dose.service;


import booster_dose.dao.Booster_DoseDao;
import booster_dose.domain.Booster_Dose;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class Booster_DoseService {
	private Booster_DoseDao booster_doseDao = new Booster_DoseDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Booster_Dose form) throws Booster_DoseException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Booster_Dose booster_dose = booster_doseDao.findByID(form.getPatient_id());
		if(booster_dose.getPatient_id()!=null && booster_dose.getPatient_id().equals(form.getPatient_id())) throw new Booster_DoseException("This user name has been registered!");
		booster_doseDao.add(form);
	}
}
