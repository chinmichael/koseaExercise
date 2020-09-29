package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Crud;
import dto.BBSVO;
import dto.MemberVO;

/**
 * Servlet implementation class BBSServlet
 */
@WebServlet("/bbsPost")
public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BBSServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		
		Crud crud = new Crud();
		Integer seqno = crud.getMaxSeqno() + 1;
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("LOGIN");
		String userid = vo.getUserid();
		
//		Calendar today = Calendar.getInstance();
//		int year = today.get(Calendar.YEAR);
//		int month = today.get(Calendar.MONTH) + 1;
//		int day = today.get(Calendar.DATE);
		
		BBSVO bbs = new BBSVO();
		bbs.setSeqno(seqno);
		bbs.setTitle(title);
		bbs.setContent(content);
		bbs.setUserid(userid);
		
		Integer r = crud.putBBS(bbs);
		String result = "Insert";
		if(r<=0) result = "Error";
		
		String url = "template.jsp?BODY=bbsList.do?RE="+result;
		response.sendRedirect(url);
	}

}
