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
	String name="aaa";
	private static final long serialVersionUID = 1L;      
    public IndexController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 getServletConfig().getServletContext().
	      getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ConnectionDB connectionDB=new ConnectionDB();
		String address="/default";//遷移先のアドレス
		request.setCharacterEncoding("UTF-8");
		String buttonName=request.getParameter("buttonName");
		
		switch(buttonName) {
		case "newThread":
			System.out.println("パラメータ（title）"+request.getParameter("title"));
			connectionDB.newThread(request.getParameter("title"),name, request.getParameter("message"));
			request.setAttribute("data",  connectionDB.selectAllThread());		
			address="/index.jsp";
			break;
		case "search":
			address="/index.jsp";
			break;
		case"commentView":
			request.setAttribute("data",  connectionDB.selectAllComment());		
			address="/commentView.jsp";
		}	
		 getServletConfig().getServletContext().
	      getRequestDispatcher(address).forward(request, response);	  
	}

}
