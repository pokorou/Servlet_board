package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  public CommentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ConnectionDB connectionDB=new ConnectionDB();
			connectionDB.newComment(Integer.parseInt(request.getParameter("threadNumber")), (String)IndexController.session.getAttribute("name"), request.getParameter("message"));
		request.setAttribute("data",  connectionDB.selectCommentOfThis(Integer.parseInt(request.getParameter("threadNumber"))));		
		getServletConfig().getServletContext().
	      getRequestDispatcher("/commentView.jsp").forward(request, response);
	}

}
