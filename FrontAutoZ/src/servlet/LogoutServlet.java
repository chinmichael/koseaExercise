package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Crud;
import dto.CartItemVO;
import dto.CartVO;
import dto.MemberVO;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CartVO cart = (CartVO) session.getAttribute("CART");
		if(cart != null) {
			Crud crud = new Crud();
			MemberVO mvo = (MemberVO) session.getAttribute("LOGIN");
			String userid = mvo.getUserid();
			List<CartItemVO> items = crud.getCart(userid);
			if(items != null) {
				cart.deleteDB(userid);
			}
			cart.saveDB();
		}
		session.invalidate();
		
		String url = "template.jsp?BODY=logoutResult.jsp";
		response.sendRedirect(url);
	}

}
