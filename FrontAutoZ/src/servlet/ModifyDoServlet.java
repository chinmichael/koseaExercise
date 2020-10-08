package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.UploadCrud;
import dto.WritingVO;

/**
 * Servlet implementation class ModifyDoServlet
 */
@WebServlet("/modify.do")
public class ModifyDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String savePath = "/upload";
		int maxLimit = 5 * 1024 * 1024;
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
		String filename = "";
		String encType = "UTF-8";
		String url = "template.jsp?BODY=imageModifyResult.jsp?";
		String msg = "";
		try {
			MultipartRequest multi = new MultipartRequest(request, realPath, maxLimit, encType, new DefaultFileRenamePolicy());
			UploadCrud crud = new UploadCrud();
			String id = multi.getParameter("id");
			msg = id;
			
			WritingVO vo = new WritingVO();
			vo.setWriting_id(Integer.parseInt(id));
			vo.setTitle(multi.getParameter("title"));
			vo.setWriter_name(multi.getParameter("name"));
			vo.setEmail(multi.getParameter("email"));
			vo.setContent(multi.getParameter("content"));
			
			filename = multi.getFilesystemName("image_name");
			if(filename != null) {
				vo.setImage_name(filename);
			} else {
				vo.setImage_name(multi.getParameter("originImage"));
			}
			
			Integer result = crud.modifyImage(vo);
			if(result > 0) {
				url = url + "seqno=" + msg;
			} else {
				url = url + "id=" + msg;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		url = url + msg;
		response.sendRedirect(url);
	}

}
