 package medical_history.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical_history.dao.Medical_HistoryDao;
import medical_history.domain.Medical_History;


/**
 * Servlet implementation class UserServlet
 */

public class Medical_HistoryServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Medical_HistoryServletRead() {
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
		Medical_History medical_history = null;
		Medical_HistoryDao medical_historyDao = new Medical_HistoryDao();
		
		try {
			medical_history = medical_historyDao.findByID(Integer.parseInt(request.getParameter("medical_history_patient_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(medical_history.getPatient_id()!=null){
					System.out.println(medical_history);
					request.setAttribute("medical_history", medical_history);
					request.getRequestDispatcher("/jsps/medical_history/medical_history_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Medical History not found");
			request.getRequestDispatcher("/jsps/medical_history/medical_history_read_output.jsp").forward(request, response);
		}
	}
}



