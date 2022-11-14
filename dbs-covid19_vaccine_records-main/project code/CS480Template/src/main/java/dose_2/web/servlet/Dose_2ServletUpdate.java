package dose_2.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dose_2.dao.Dose_2Dao;
import dose_2.domain.Dose_2;

/**
 * Servlet implementation class UserServlet
 */

public class Dose_2ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dose_2ServletUpdate() {
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
		Dose_2Dao dose_2dao = new Dose_2Dao();
		Dose_2 dose_2 = null;

		if(method.equals("dose_2_search"))
		{
			try {
				dose_2 = dose_2dao.findByID(Integer.parseInt(request.getParameter("patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(dose_2.getPatient_id()!=null){
				request.setAttribute("dose_2", dose_2);
				request.getRequestDispatcher("/jsps/dose_2/dose_2_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/dose_2/dose_2_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("dose_2_update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Dose_2 form = new Dose_2();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setPatient_id(Integer.parseInt(info.get(1)));
			form.setType(info.get(2));
			form.setLot_number(info.get(3));
			form.setDate_of_dose(java.sql.Date.valueOf(info.get(4)));
			form.setLocation(info.get(5));

			try {
				dose_2dao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/dose_2/dose_2_read_output.jsp").forward(request, response);
		}
	}
}



