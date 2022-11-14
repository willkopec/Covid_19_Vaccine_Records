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

import booster_dose.domain.Booster_Dose;
import booster_dose.service.Booster_DoseException;
import booster_dose.service.Booster_DoseService;


/**
 * Servlet implementation class UserServlet
 */

public class Booster_DoseServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booster_DoseServletCreate() {
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
		Booster_DoseService booster_doseservice = new Booster_DoseService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Booster_Dose form = new Booster_Dose();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setPatient_id(Integer.parseInt(info.get(0)));
		form.setType(info.get(1));
		form.setLot_number(info.get(2));
		form.setDate_of_dose(java.sql.Date.valueOf(info.get(3)));
		form.setLocation(info.get(4));
		
		try {
			booster_doseservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Booster_DoseException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
