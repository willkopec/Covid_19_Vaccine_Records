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

public class AddressServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServletRead() {
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
		Address dose1 = null;
		AddressDao dose1Dao = new AddressDao();
		
		try {
			dose1 = dose1Dao.findByID(Integer.parseInt(request.getParameter("patient_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(dose1.getPatient_id() != null){
					System.out.println(dose1);
					request.setAttribute("address", dose1);
					request.getRequestDispatcher("/jsps/address/address_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Address not found");
			request.getRequestDispatcher("/jsps/address/address_read_output.jsp").forward(request, response);
		}
	}
}



