package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.BaseballCrud;
import dto.BaseballTeamVO;

/**
 * Servlet implementation class PutBaseballTeamServlet
 */
@WebServlet("/putBaseballTeam")
public class PutBaseballTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PutBaseballTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("NAME");
		String hometown = request.getParameter("TOWN");
		String owner = request.getParameter("OWNER");
		String intro = request.getParameter("INTRO");
		String birth = request.getParameter("BIRTH");
		
		BaseballCrud crud = new BaseballCrud();
		Integer id = crud.getId() + 1;
		
		BaseballTeamVO team = new BaseballTeamVO();
		team.setId(id);
		team.setName(name);
		team.setHometown(hometown);
		team.setOwner(owner);
		team.setIntro(intro);
		team.setBirth(birth);
		
		Integer result = crud.putTeam(team);
		
		String message = "";
		if(result > 0) {
			message = "success";
		}
		
		String url = "template.jsp?BODY=putTeamResult.jsp?MSG="+message;
		response.sendRedirect(url);
	}

}
