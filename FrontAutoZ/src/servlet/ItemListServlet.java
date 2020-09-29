package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Crud;
import dto.ItemVO;

/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet("/itemList")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ItemListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("PAGE");
		if (page == null) {
			page = "1";
		}
		Integer pageno = Integer.parseInt(page);
		Crud crud = new Crud();
		List<ItemVO> list = crud.getItem(pageno);
		Integer pageCount = (crud.getItemCount() + 4) / 5;
		
		request.setAttribute("ITEM", list);
		request.setAttribute("PAGE", pageCount);
		
		String url = "template.jsp?BODY=itemList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
