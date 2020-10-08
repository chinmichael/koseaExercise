package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.UploadCrud;
import dto.Condition;
import dto.WritingVO;

/**
 * Servlet implementation class ImageListServlet
 */
@WebServlet("/imageList")
public class ImageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UploadCrud crud = new UploadCrud();
		int count = crud.getTotalCnt();
		int totalPageCount = 0;
		String pageNum = request.getParameter("page");
		if(pageNum == null) pageNum = "1";
		String seqno = request.getParameter("seqno");
		if(seqno != null) {
			int rownum = crud.selectRownum(Integer.parseInt(seqno));
			int page = rownum / 5;
			if(rownum % 5 != 0) page++;
			pageNum = String.valueOf(page);
		}
		
		int startRow = 0;
		int endRow = 0;
		int currentPage = Integer.parseInt(pageNum);
		if(count > 0) {
			totalPageCount = count / 5;
			if(count % 5 > 0) totalPageCount++;
			startRow = (currentPage - 1) * 5 + 1;
			endRow = (currentPage * 5);
			if(endRow > count) endRow = count;
		}
		Condition con = new Condition();
		con.setStartRow(startRow);
		con.setEndRow(endRow);
		List<WritingVO> list = crud.getImageList(con);
		
		request.setAttribute("LIST", list);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("pageCount", totalPageCount);
		request.setAttribute("currentPage", currentPage);
		
		String url = "template.jsp?BODY=imageListView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
