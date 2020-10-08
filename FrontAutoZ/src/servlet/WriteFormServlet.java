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
 * Servlet implementation class WriteFormServlet
 */
@WebServlet("/WriteFormServlet")
public class WriteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String parentId = request.getParameter("parentid");
		String groupId = request.getParameter("groupid");
		if(parentId != null) {
			String title = "";
			UploadCrud crud = new UploadCrud();
			WritingVO vo = crud.getImage(Integer.parseInt(parentId));
			if(vo != null) {
				title = "RE]" + vo.getTitle();
			}
			request.setAttribute("writing", vo);
			request.setAttribute("title", title);
		}
		String url = "template.jsp?BODY=writeForm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
