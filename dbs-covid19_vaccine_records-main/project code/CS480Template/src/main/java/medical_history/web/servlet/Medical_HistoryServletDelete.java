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

public class Medical_HistoryServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Medical_HistoryServletDelete() {
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
		Medical_HistoryDao medicalHistoryDao = new Medical_HistoryDao();
		Medical_History medicalHistory = null;
		if(method.equals("medical_history_search"))
		{
			try {
				medicalHistory = medicalHistoryDao.findByID(Integer.parseInt(request.getParameter("medical_history_patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(medicalHistory.getPatient_id()!=null){
						//System.out.println(medicalHistory);
						request.setAttribute("medical_history", medicalHistory);
						request.getRequestDispatcher("/jsps/medical_history/medical_history_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Medical History not found");
				request.getRequestDispatcher("/jsps/medical_history/medical_history_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("medical_history_delete"))
		{	
			try {
				medicalHistoryDao.delete(request.getParameter("medical_history_patient_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Medical History Deleted");
			request.getRequestDispatcher("/jsps/medical_history/medical_history_read_output.jsp").forward(request, response);
		}
	}
}



