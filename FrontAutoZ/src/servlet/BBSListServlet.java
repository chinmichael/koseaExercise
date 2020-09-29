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
import dto.BBSVO;


@WebServlet("/bbsList.do")
public class BBSListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BBSListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result = request.getParameter("RE");
		Crud crud = new Crud();
		String no = request.getParameter("PAGENO");
		if(no == null) no = "1";
		Integer pageno = Integer.parseInt(no);
		List<BBSVO> bbsList = crud.getBBS(pageno);
		Integer pageCount = (crud.getBBSCount() + 4) / 5;
		
		request.setAttribute("RESULT", result);
		request.setAttribute("LIST", bbsList);
		request.setAttribute("PAGES", pageCount);
		
		String url = "template.jsp?BODY=bbsListView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
