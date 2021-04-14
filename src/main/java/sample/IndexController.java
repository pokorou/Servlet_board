package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    public IndexController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		
		
		
		 getServletConfig().getServletContext().
	      getRequestDispatcher("/new.jsp").forward(request, response);
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address="/default";//遷移先のアドレス
		request.setCharacterEncoding("UTF-8");
		String buttonName=request.getParameter("buttonName");
		
		switch(buttonName) {
		case "newThread":
			address="/index.jsp";
			break;
		case "search":
			address="/index.jsp";
			break;
		}
		
		 getServletConfig().getServletContext().
	      getRequestDispatcher(address).forward(request, response);
	  
	}

}
