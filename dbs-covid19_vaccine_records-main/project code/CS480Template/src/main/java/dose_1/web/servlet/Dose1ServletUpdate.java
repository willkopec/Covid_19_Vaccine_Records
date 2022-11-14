package dose_1.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dose_1.dao.Dose1Dao;
import dose_1.domain.dose1;

/**
 * Servlet implementation class UserServlet
 */

public class Dose1ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dose1ServletUpdate() {
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
		Dose1Dao patientdao = new Dose1Dao();
		dose1 patient = null;

		if(method.equals("search"))
		{
			try {
				patient = patientdao.findByID(Integer.parseInt(request.getParameter("patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(patient.getPatient_id()!=null){
				request.setAttribute("dose_1", patient);
				request.getRequestDispatcher("/jsps/dose_1/dose_1_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Patient not found");
				request.getRequestDispatcher("/jsps/dose_1/dose_1_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			dose1 form = new dose1();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setPatient_id(Integer.parseInt(info.get(1)));
			form.setdose_type(info.get(2));
			form.setlot_num(info.get(3));
			form.setlocation(info.get(4));
			form.setDoseDate(java.sql.Date.valueOf(info.get(5)));

			try {
				patientdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Patient Updated");
			request.getRequestDispatcher("/jsps/dose_1/dose_1_read_output.jsp").forward(request, response);
		}
	}
}



