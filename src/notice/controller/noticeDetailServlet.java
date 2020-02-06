package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class noticeDetailServlet
 */
@WebServlet("/detail.no")
public class noticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		Notice no = null;
		
		boolean isN = false;
		Cookie[] coo = request.getCookies();
		if(coo != null) {
			for(Cookie c : coo) {
				if(c.getName().equals("nno"+nno)) {
					isN = true;
				}
			}
			
			if(!isN) {
				no = new NoticeService().selectNotice(nno);
				Cookie c1 = new Cookie("nno"+nno,String.valueOf(nno));
				c1.setMaxAge(1*24*60*60);
				response.addCookie(c1);
			}else {
				no = new NoticeService().selectNoticeNoCnt(nno);
			}
		}
		
		if(no!= null) {
			request.setAttribute("notice", no);
			request.getRequestDispatcher("views/notice/noticeDetailView.jsp").forward(request, response);;
		}else {
			request.setAttribute("msg", "게시판 조회 실패");
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
