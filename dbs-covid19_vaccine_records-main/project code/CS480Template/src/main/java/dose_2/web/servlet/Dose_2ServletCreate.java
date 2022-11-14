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

import dose_2.domain.Dose_2;
import dose_2.service.Dose_2Exception;
import dose_2.service.Dose_2Service;


/**
 * Servlet implementation class UserServlet
 */

public class Dose_2ServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dose_2ServletCreate() {
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
		Dose_2Service dose_2service = new Dose_2Service();
		Map<String,String[]> paramMap = request.getParameterMap();
		Dose_2 form = new Dose_2();
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
			dose_2service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Dose_2Exception e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
