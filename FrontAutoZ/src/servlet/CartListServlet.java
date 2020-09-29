package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Crud;
import dto.CartItemVO;
import dto.CartVO;

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/cartList.do")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CartVO cart = (CartVO) session.getAttribute("CART");
		if(cart == null) {
			request.setAttribute("CARTLIST", null);
		} else {
			List<CartItemVO> list = new LinkedList<CartItemVO>();
			Iterator itr = cart.getCodeList().iterator();
			List<Integer> num = cart.getNumList();

			int total = 0;
			int index = 0;
			Crud crud = new Crud();
			while(itr.hasNext()) {
				String code = (String)itr.next();
				CartItemVO item = crud.getItemNamePrice(code);
				item.setCode(code); item.setNum(num.get(index));
				list.add(item);
				total = total + (item.getNum() * item.getPrice());
				index++;
			}
			request.setAttribute("CARTLIST", list);
			request.setAttribute("TOTAL", total);
		}
		String url = "template.jsp?BODY=cartListView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
