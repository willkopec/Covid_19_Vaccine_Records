package medical_history.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical_history.dao.Medical_HistoryDao;
import medical_history.domain.Medical_History;

/**
 * Servlet implementation class UserServlet
 */

public class Medical_HistoryServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Medical_HistoryServletUpdate() {
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
		Medical_History medical_history = null;

		if(method.equals("medical_history_search_update"))
		{
			try {
				medical_history = medicalHistoryDao.findByID(Integer.parseInt(request.getParameter("medical_history_patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(medical_history.getPatient_id()!=null){
				request.setAttribute("medical_history", medical_history);
				request.getRequestDispatcher("/jsps/medical_history/medical_history_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Medical History not found");
				request.getRequestDispatcher("/jsps/medical_history/medical_history_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("medical_history_update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Medical_History form = new Medical_History();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setNotes(request.getParameter("medical_history_notes"));
			form.setPre_existing_conditions(request.getParameter("medical_history_pre_exisiting_conditions"));
			form.setContracted_covid(java.sql.Date.valueOf(request.getParameter("medical_history_contracted_covid")));
			form.setPatient_id(Integer.parseInt(request.getParameter("medical_history_patient_id")));

			
			
			
			
			try {
				medicalHistoryDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Medical History Updated");
			request.getRequestDispatcher("/jsps/medical_history/medical_history_read_output.jsp").forward(request, response);
		}
	}
}



