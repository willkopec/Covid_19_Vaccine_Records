package primary_physician.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contact.service.ContactService;
import primary_physician.service.Primary_physicianService;

/**
 * logic functions such as register, login
 * @author Priyanka Patel
 *
 */


public class ILPhys extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Primary_physicianService primary_physicianService = new Primary_physicianService();
		try {
			request.setAttribute("PrimaryPhysicianList", primary_physicianService.findILPhys());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*try {
			List<Object> li = contactService.findall();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
		
		request.getRequestDispatcher("/jsps/primary_physician/q_il_phys.jsp").forward(request, response);
	}

}




