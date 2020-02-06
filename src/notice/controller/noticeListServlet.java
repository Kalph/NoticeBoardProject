package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.Page;

/**
 * Servlet implementation class noticeListViewServlet
 */
@WebServlet("/list.no")
public class noticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService nSer = new NoticeService();
		
		int listCt = nSer.getListCount(); // 모든 페이지 수를 받아옴
		
		
		int curPage; // 현재 페이지
		int limitPage; // 페이지의 한계 사이즈
		int maxPage; // 페이지의 가장 마지막 
		int startPage; // 한 페이지의 시작
		int endPage; // 한 페이지의 마지막
		int limitNotice = 10; // 보여줄 공지사항 게시글의 수
		
		curPage = 1;
		limitPage = 10;
		
		if(request.getParameter("curPage") != null) {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		
		maxPage = (int)Math.ceil((double)listCt/limitPage);
		startPage = (curPage-1) / limitPage * limitPage + 1;
		endPage = startPage + limitPage -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		Page pG = new Page(curPage,listCt,limitPage,maxPage,startPage,endPage,limitNotice);
		
		ArrayList<Notice> list = nSer.selectList(curPage,limitNotice);
		request.setAttribute("list", list);
		request.setAttribute("pG", pG);
		request.getRequestDispatcher("views/notice/noticeListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
