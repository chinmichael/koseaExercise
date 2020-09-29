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
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/addCart")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("CODE");
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("LOGIN");
		String id = member.getUserid();
		CartVO cart = (CartVO) session.getAttribute("CART");
		if(cart == null) {
			cart = new CartVO(id);
		}
		cart.addCart(code, 1);
		session.setAttribute("CART", cart);
		
		String url = "addCartResult.jsp";
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
