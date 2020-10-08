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
 * Servlet implementation class WriteDoServlet
 */
@WebServlet("/write.do")
public class WriteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public WriteDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String savePath = "upload";
		int maxLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath); // 절대경로
		String filename = "";
		String result = "";
		System.out.println("저장경로 : " + realPath);
		try {
			MultipartRequest multi = new MultipartRequest(request, realPath, maxLimit, encType, new DefaultFileRenamePolicy());
			filename = multi.getFilesystemName("imagename"); // 업로드 실행
			if(filename == null) {
				result = "No_up";
			} else {
				UploadCrud crud = new UploadCrud();
				WritingVO vo = new WritingVO();
				
				String parentId = multi.getParameter("parentid");
				String groupId = multi.getParameter("groupid");
				String orderNo = multi.getParameter("orderno");
				
				if(parentId == null || parentId.equals("")) {
					vo.setParent_id(0);
					vo.setOrder_no(0);
					vo.setGroup_id(crud.getMaxId() + 1);
				} else {
					vo.setParent_id(Integer.parseInt(parentId));
					vo.setOrder_no(Integer.parseInt(orderNo));
					vo.setGroup_id(Integer.parseInt(groupId));
					crud.updateOrderNo(vo);
				}

				vo.setWriting_id(crud.getMaxId() + 1);
				vo.setTitle(multi.getParameter("title"));
				vo.setWriter_name(multi.getParameter("writer_name"));
				vo.setEmail(multi.getParameter("email"));
				vo.setPassword(multi.getParameter("password"));
				vo.setContent(multi.getParameter("content"));
				vo.setImage_name(filename);
				
				Integer sqlResult = crud.putImageWriting(vo);
				if(sqlResult > 0) {
					result = "uploaded";
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String url = "template.jsp?BODY=uploadResult.jsp?message="+result; 
		response.sendRedirect(url);
	}

}
