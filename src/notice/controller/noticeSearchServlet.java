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
 * Servlet implementation class noticeSearchServlet
 */
@WebServlet("/search.no")
public class noticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		String search = request.getParameter("search");
		
		NoticeService nS = new NoticeService();
		
		int listCt = nS.getListCount(condition, search); // 모든 페이지 수를 받아옴
		
		
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
		
		ArrayList<Notice> list = new NoticeService().NoticeSearch(condition,search,curPage,limitNotice);
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.setAttribute("pG", pG);
			request.setAttribute("condition", condition);
			request.setAttribute("search", search);
			request.getRequestDispatcher("views/notice/noticeListView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "검색 실패.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
