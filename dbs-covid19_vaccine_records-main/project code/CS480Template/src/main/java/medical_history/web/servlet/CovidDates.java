package medical_history.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical_history.service.Medical_HistoryService;

/**
 * Servlet implementation class findAll
 */

public class CovidDates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Medical_HistoryService medical_historyservice = new Medical_HistoryService();
		try {
			request.setAttribute("CovidDateList", medical_historyservice.findCovidDate());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*try {
			List<Object> li = medical_historyservice.findall();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
		
		request.getRequestDispatcher("/jsps/medical_history/q_covid_dates.jsp").forward(request, response);
	}

}
