package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import action.Crud;
import dto.CartItemVO;
import dto.CartVO;
import dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		Crud crud = new Crud();
		MemberVO member = crud.selectMember(userid);
		String result = "";
		
		if(member != null) {
			if(userpw.equals(member.getUserpw())) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN", member);
				
				List<CartItemVO> items = crud.getCart(userid);
				if(items != null) {
					CartVO cart = new CartVO(userid);
					Iterator itr = items.iterator();
					while(itr.hasNext()) {
						CartItemVO item = (CartItemVO) itr.next();
						cart.getCodeList().add(item.getCode());
						cart.getNumList().add(item.getNum());
					}
					session.setAttribute("CART", cart);
				}
			} else {
				result = "Check your password";
			}
		} else {
			result = "Check your ID";
		}
		
		String param = request.getParameter("CARTCHECK");
		
		String url = "";
		if(param == null) {
			url = "template.jsp?BODY=loginResult.jsp?loginMessage=" + result;
		} else {
			url = "cartLoginResult.jsp?loginMessage=" + result;
		}
		response.sendRedirect(url);
	}

}
