package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class noticeUpdateServlet
 */
@WebServlet("/update.no")
public class noticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		String title = request.getParameter("title");
		String tag = request.getParameter("tag");
		String content = request.getParameter("content");
		
		Notice no = new Notice(nno,tag,title,content);
		
		int result = new NoticeService().updateNotice(no);
		
		if(result > 0 ) {
			request.getSession().setAttribute("msg", "업데이트 성공");
			response.sendRedirect("detail.no?nno="+nno);
		}else {
			request.setAttribute("msg", "공지사항 수정 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);;
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
