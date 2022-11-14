package dose_1.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dose_1.dao.Dose1Dao;
import dose_1.domain.dose1;


/**
 * Servlet implementation class UserServlet
 */

public class Dose1ServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dose1ServletRead() {
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
		dose1 dose1 = null;
		Dose1Dao dose1Dao = new Dose1Dao();
		
		try {
			dose1 = dose1Dao.findByID(Integer.parseInt(request.getParameter("patient_id")));
			//System.out.print(dose1.getdose_type());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(dose1.getPatient_id() != null){
					//System.out.println("THIS" + dose1.getdose_type());
					request.setAttribute("dose_1", dose1);
					request.getRequestDispatcher("/jsps/dose_1/dose_1_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Patient not found");
			request.getRequestDispatcher("/jsps/dose_1/dose_1_read_output.jsp").forward(request, response);
		}
	}
}



