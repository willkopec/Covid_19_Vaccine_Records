package primary_physician.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import primary_physician.dao.Primary_physicianDao;
import primary_physician.domain.Primary_physician;


/**
 * Servlet implementation class UserServlet
 */

public class Primary_physicianServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Primary_physicianServletRead() {
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
		Primary_physician primary_physician = null;
		Primary_physicianDao primary_physicianDao = new Primary_physicianDao();
		
		try {
			primary_physician = primary_physicianDao.findByID(Integer.parseInt(request.getParameter("primary_physician_patient_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(primary_physician.getPatient_id()!=null){
					System.out.println(primary_physician);
					request.setAttribute("primary_physician", primary_physician);
					request.getRequestDispatcher("/jsps/primary_physician/primary_physician_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Primary Physician for patient not found");
			request.getRequestDispatcher("/jsps/primary_physician/primary_physician_read_output.jsp").forward(request, response);
		}
	}
}



