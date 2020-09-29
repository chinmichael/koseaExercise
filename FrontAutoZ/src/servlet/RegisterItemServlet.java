package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Crud;
import dto.ItemVO;

@WebServlet("/registerItem")
public class RegisterItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterItemServlet() {
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
		String name = request.getParameter("NAME");
		Integer price = Integer.parseInt(request.getParameter("PRICE"));
		String origin = request.getParameter("ORIGIN");
		String info = request.getParameter("INFO");
		
		ItemVO item = new ItemVO();
		item.setCode(code);
		item.setName(name);
		item.setPrice(price);
		item.setOrigin(origin);
		item.setInfo(info);
		
		Crud crud = new Crud();
		Integer result = crud.putItem(item);
		String message = "";
		
		if(result > 0) {
			message = "success";
		} 
		String url = "template.jsp?BODY=inputItemResult.jsp?message=" + message;
		
		response.sendRedirect(url);
		
	}

}
