package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Crud;

/**
 * Servlet implementation class CodeCheckServlet
 */
@WebServlet("/codeCheck.do")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("CODE");
		Crud crud = new Crud();
		Integer result = crud.checkItemID(code);
		
		String message = "";
		
		if(result == 0) {
			message = "available";
		} 
		request.setAttribute("CODE", code);
		request.setAttribute("itemMessage", message);
		String url = "itemCheckResult.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
