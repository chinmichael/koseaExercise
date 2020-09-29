package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Crud;
import dto.MemberVO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("ID");
		String userpw = request.getParameter("PWD");
		String username = request.getParameter("NAME");
		String usernick = request.getParameter("NICK");
		String phone = request.getParameter("PHONE");
		
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
		vo.setUserpw(userpw);
		vo.setUsername(username);
		vo.setUsernick(usernick);
		vo.setPhone(phone);
		
		Crud crud = new Crud();
		Integer result = crud.joinAccount(vo);
		
		String joinMessage = "";
		
		if(result > 0) {
			joinMessage = "Success";
		}
		
		String url = "template.jsp?BODY=joinResult.jsp?joinMessage="+joinMessage;
		
		response.sendRedirect(url);
	}

}
