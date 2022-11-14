package booster_dose.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booster_dose.dao.Booster_DoseDao;
import booster_dose.domain.Booster_Dose;


/**
 * Servlet implementation class UserServlet
 */

public class Booster_DoseServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booster_DoseServletDelete() {
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
		Booster_DoseDao booster_doseDao = new Booster_DoseDao();
		Booster_Dose booster_dose = null;
		if(method.equals("booster_dose_search"))
		{
			try {
				booster_dose = booster_doseDao.findByID(Integer.parseInt(request.getParameter("patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(booster_dose.getPatient_id()!=null){
						System.out.println(booster_dose);
						request.setAttribute("booster", booster_dose);
						request.getRequestDispatcher("/jsps/booster/booster_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/booster/booster_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("booster_dose_delete"))
		{	
			try {
				booster_doseDao.delete(request.getParameter("patient_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/booster/booster_read_output.jsp").forward(request, response);
		}
	}
}



