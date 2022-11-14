package booster_dose.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booster_dose.dao.Booster_DoseDao;
import booster_dose.domain.Booster_Dose;

/**
 * Servlet implementation class UserServlet
 */

public class Booster_DoseServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Booster_DoseServletUpdate() {
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
		Booster_DoseDao booster_dosedao = new Booster_DoseDao();
		Booster_Dose booster_dose = null;

		if(method.equals("booster_dose_search"))
		{
			try {
				booster_dose = booster_dosedao.findByID(Integer.parseInt(request.getParameter("patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(booster_dose.getPatient_id()!=null){
				request.setAttribute("booster", booster_dose);
				request.getRequestDispatcher("/jsps/booster/booster_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/booster/booster_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("booster_dose_update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Booster_Dose form = new Booster_Dose();
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
				booster_dosedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/booster/booster_read_output.jsp").forward(request, response);
		}
	}
}



