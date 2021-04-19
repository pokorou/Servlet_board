package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	String name="名無し";
	 static HttpSession session;
	private static final long serialVersionUID = 1L;      
    public IndexController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 session=request.getSession(true);
	        session.setAttribute("name",name);
	        session.setMaxInactiveInterval(60*60*24);
		ConnectionDB connectionDB=new ConnectionDB();
		request.setAttribute("data",  connectionDB.selectAllThread());		
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
			 int threadNumber=connectionDB.newThread(request.getParameter("title"),(String)session.getAttribute("name"), request.getParameter("message"));
			 System.out.println("threadNumber"+threadNumber);
			connectionDB.newComment(threadNumber, (String)session.getAttribute("name"), request.getParameter("message"));
			request.setAttribute("data",  connectionDB.selectAllThread());		
			address="/index.jsp";
			break;
		case "search":
			System.out.println("aa");
			System.out.println(request.getParameter("searchWord"));
			request.setAttribute("data", connectionDB.searchThread(request.getParameter("searchWord")));
			address="/index.jsp";
			break;
		case"changeName":
			address="/changeName.jsp";
			break;
		case"commentView":
			request.setAttribute("data",  connectionDB.selectCommentOfThis(Integer.parseInt(request.getParameter("threadNumber"))));		
			address="/commentView.jsp";
			break;
		}	
		 getServletConfig().getServletContext().
	      getRequestDispatcher(address).forward(request, response);	  
	}

}
