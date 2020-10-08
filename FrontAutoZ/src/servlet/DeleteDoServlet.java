package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.UploadCrud;

/**
 * Servlet implementation class DeleteDoServlet
 */
@WebServlet("/delete.do")
public class DeleteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		UploadCrud crud = new UploadCrud();
		Integer result = crud.deleteImage(Integer.parseInt(id));
		String url = "template.jsp?BODY=imageDeleteResult.jsp?message=";
		String msg = "";
		if(result > 0) {
			msg = "success";
		}
		url = url + msg;
		response.sendRedirect(url);
	}

}
