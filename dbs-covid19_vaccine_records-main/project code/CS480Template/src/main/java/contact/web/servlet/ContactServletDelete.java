package contact.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contact.dao.ContactDao;
import contact.domain.Contact;


/**
 * Servlet implementation class UserServlet
 */

public class ContactServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServletDelete() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		ContactDao contactDao = new ContactDao();
		Contact contact = null;
		if(method.equals("contact_search"))
		{
			try {
				contact = contactDao.findByID(Integer.parseInt(request.getParameter("contact_patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(contact.getPatient_id()!=null){
						System.out.println(contact.getPatient_id());
						request.setAttribute("contact", contact);
						request.getRequestDispatcher("/jsps/contact/contact_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Contact for patient not found");
				request.getRequestDispatcher("/jsps/contact/contact_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("contact_delete"))
		{	
			try {
				contactDao.delete(request.getParameter("contact_patient_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Contact Deleted");
			request.getRequestDispatcher("/jsps/contact/contact_read_output.jsp").forward(request, response);
		}
	}
}



