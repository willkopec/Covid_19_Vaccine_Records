package primary_physician.web.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import primary_physician.domain.Primary_physician;
import primary_physician.service.Primary_physicianException;
import primary_physician.service.Primary_physicianService;


/**
 * Servlet implementation class UserServlet
 */

public class Primary_physicianServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Primary_physicianServletCreate() {
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
		Primary_physicianService entity1service = new Primary_physicianService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Primary_physician form = new Primary_physician();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setPatient_id(Integer.parseInt(info.get(0)));
		form.setp_first_name(info.get(1));
		form.setp_last_name(info.get(2));		
		form.setp_street_address(info.get(3));
		form.setp_city(info.get(4));
		form.setp_state(info.get(5));
		form.setp_zip(Integer.parseInt(info.get(6)));
		form.setp_phone_num(new BigInteger (info.get(7)));
		
		
		
		
		
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Primary_physicianException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
