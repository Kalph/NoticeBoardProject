package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class testLoginServlet
 */
@WebServlet("/login.me")
public class memberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logId = request.getParameter("logId");
		String logPwd = request.getParameter("logPwd");
		
		Member loginMember = new MemberService().loginMember(logId, logPwd);
		if(loginMember != null) {
			request.getSession().setMaxInactiveInterval(60*60);
			request.getSession().setAttribute("loginMember", loginMember);
			
			// 이전 화면으로 돌아가게 만들기
			String referer = request.getHeader("Referer");
			String back = "/" + referer.substring(referer.lastIndexOf("/")+1);
			if(back != "/") {
				// test - 최상위 경로나 같은 의미.
				response.sendRedirect(request.getContextPath()+back);
			} else {
				response.sendRedirect(request.getContextPath());
			}
		} else {
			request.setAttribute("msg", "로그인 실패, 관리자에게 문의해 주세요.");
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
