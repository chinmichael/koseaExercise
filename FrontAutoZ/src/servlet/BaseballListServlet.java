package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.BaseballCrud;
import dto.BaseballTeamVO;

/**
 * Servlet implementation class BaseballListServlet
 */
@WebServlet("/getBaseballList")
public class BaseballListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BaseballListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("PAGE");
		if(page == null) {
			page = "1";
		}
		Integer pageno = Integer.parseInt(page);
		
		BaseballCrud crud = new BaseballCrud();
		List<BaseballTeamVO> list = crud.getTeamList(pageno);
		Integer teamCount = (crud.teamCount() + 4) /5;
		
		request.setAttribute("TEAM", list);
		request.setAttribute("PAGE", teamCount);
		
		String url = "template.jsp?BODY=teamList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
