package dose_2.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dose_2.dao.Dose_2Dao;
import dose_2.domain.Dose_2;


/**
 * Servlet implementation class UserServlet
 */

public class Dose_2ServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dose_2ServletRead() {
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
		Dose_2 dose_2 = null;
		Dose_2Dao dose_2Dao = new Dose_2Dao();
		
		try {
			dose_2 = dose_2Dao.findByID(Integer.parseInt(request.getParameter("patient_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(dose_2.getPatient_id()!=null){
					System.out.println(dose_2);
					request.setAttribute("dose_2", dose_2);
					request.getRequestDispatcher("/jsps/dose_2/dose_2_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/dose_2/dose_2_read_output.jsp").forward(request, response);
		}
	}
}



