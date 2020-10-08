package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.UploadCrud;
import dto.WritingVO;

/**
 * Servlet implementation class ImageReadServlet
 */
@WebServlet("/imageRead")
public class ImageReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ImageReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		UploadCrud crud = new UploadCrud();
		WritingVO vo = crud.getImage(Integer.parseInt(id));
		request.setAttribute("result", vo);
		String url = "template.jsp?BODY=imageRead.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
