package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Crud;
import dto.MemberVO;

@WebServlet("/idCheck.do")
public class IDcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IDcheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("ID");
		Crud crud = new Crud();
		MemberVO vo = crud.selectMember(userid);
		
		String checkMessage = "";
		
		if(vo != null) {
			checkMessage = "This ID id is not available";
		}
		request.setAttribute("checkMessage", checkMessage);
		request.setAttribute("ID", userid);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("idCheckResult.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
