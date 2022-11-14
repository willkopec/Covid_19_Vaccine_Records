package address.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import address.dao.AddressDao;
import address.domain.Address;


/**
 * Servlet implementation class UserServlet
 */

public class AddressServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServletDelete() {
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
		AddressDao patientDao = new AddressDao();
		Address patient = null;
		if(method.equals("search"))
		{
			try {
				patient = patientDao.findByID(Integer.parseInt(request.getParameter("patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(patient.getPatient_id()!=null){
						System.out.println(patient);
						request.setAttribute("address", patient);
						request.getRequestDispatcher("/jsps/address/address_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Patient not found");
				request.getRequestDispatcher("/jsps/address/address_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				patientDao.delete(request.getParameter("patient_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Address Deleted");
			request.getRequestDispatcher("/jsps/address/address_read_output.jsp").forward(request, response);
		}
	}
}



