package contact.service;


import java.util.List;

import contact.dao.ContactDao;
import contact.domain.Contact;

/**
 *
 *
 */
public class ContactService {
	private ContactDao contactDao = new ContactDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Contact form) throws ContactException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Contact contact = contactDao.findByID(form.getPatient_id());
		if(contact.getPatient_id()!=null && contact.getPatient_id().equals(form.getPatient_id()))throw new ContactException("The contact for this patient id has been registered!");
		contactDao.add(form);
	}
	
	public List<Object> findGmail() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return contactDao.findGmail();
		
	}
}
