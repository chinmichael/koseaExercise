package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CartVO;
import dto.MemberVO;

/**
 * Servlet implementation class ModfiyCartServlet
 */
@WebServlet("/modifyCart")
public class ModfiyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModfiyCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("CODE");
		String num = request.getParameter("NUM");
		String btn = request.getParameter("BTN");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("LOGIN");
		String id = member.getUserid();
		CartVO cart = (CartVO) session.getAttribute("CART");
		if(btn.equals("수정")) {
			cart.modifyItem(code, Integer.parseInt(num));
		} else {
			cart.deleteItem(code);
		}
		
		response.sendRedirect("cartList.do");
	}

}
