package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NameController")
public class NameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NameController() {
        super(); 
    }
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 HttpSession session=request.getSession(true);
	        session.setAttribute("name",request.getParameter("newName"));
	        
	        ConnectionDB connectionDB=new ConnectionDB();
			request.setAttribute("data",  connectionDB.selectAllThread());		

	        
		 getServletConfig().getServletContext().
	      getRequestDispatcher("/index.jsp").forward(request, response);	  
	}

}
