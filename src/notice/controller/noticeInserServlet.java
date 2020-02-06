package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import member.model.vo.Member;

/**
 * Servlet implementation class noticeInserServlet
 */
@WebServlet("/insert.no")
public class noticeInserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeInserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Member loginMember = (Member)request.getSession().getAttribute("loginTest");
		
		String writer = String.valueOf(loginMember.gettNo());
//		String today = (String) request.getSession().getAttribute("today");
		String title = request.getParameter("title");
		String tag = request.getParameter("tag");
		String content = request.getParameter("content");
		
		Notice no = new Notice(tag,title,content,writer);
		int result = new NoticeService().insertNotice(no);
		
		if(result>0) {
			response.sendRedirect("list.no");
		}else {
			request.setAttribute("msg", "공지사항 작성 실패");
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
