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


@WebServlet("/getBaseballTeam")
public class getBaseballTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public getBaseballTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BaseballCrud crud = new BaseballCrud();
		List<BaseballTeamVO> list = crud.getTeam();
		
		request.setAttribute("teamList", list);
		String url = "template.jsp?BODY=joinPlayer.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
