package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Crud;
import dto.BBSVO;

/**
 * Servlet implementation class BBSReadServlet
 */
@WebServlet("/bbsRead")
public class BBSReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BBSReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer seqno = Integer.parseInt(request.getParameter("SEQNO"));
		Crud crud = new Crud();
		BBSVO vo = crud.getBBSRead(seqno);
		request.setAttribute("BBS", vo);
		String url = "template.jsp?BODY=bbsRead.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
