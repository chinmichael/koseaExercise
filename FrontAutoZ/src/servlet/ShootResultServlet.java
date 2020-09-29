package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shootResult")
public class ShootResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShootResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String shootParam = request.getParameter("shoot");
		int shoot = Integer.parseInt(shootParam);
		int goalKeep = (int) (Math.random() * 5);
		String message = "";
		
		if(shoot != goalKeep) {
			message = "win";
		}
		
		String url = "template.jsp?BODY=gameResult.jsp?result="+message;
		response.sendRedirect(url);
	}

}
