package contact.web.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contact.dao.ContactDao;
import contact.domain.Contact;

/**
 * Servlet implementation class UserServlet
 */

public class ContactServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactServletUpdate() {
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

		if(method.equals("contact_search_update"))
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
				request.setAttribute("contact", contact);
				request.getRequestDispatcher("/jsps/contact/contact_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Contact not found");
				request.getRequestDispatcher("/jsps/contact/contact_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("contact_update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Contact form = new Contact();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setEmail_address(request.getParameter("contact_email_address"));
			form.setPhone_num(new BigInteger(request.getParameter("contact_phone_num")));
			form.setPatient_id(Integer.parseInt(request.getParameter("contact_patient_id")));

			try {
				contactDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Contact Updated");
			request.getRequestDispatcher("/jsps/contact/contact_read_output.jsp").forward(request, response);
		}
	}
}



