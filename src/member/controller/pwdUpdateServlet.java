package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class pwdUpdateServlet
 */
@WebServlet("/updatePwd.me")
public class pwdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pwdUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userId = ((Member)session.getAttribute("loginMember")).gettId();
		request.setCharacterEncoding("utf-8");
		
		String pwd = request.getParameter("pwd");
		String nPwd = request.getParameter("nPwd");
		
		Member upT = new MemberService().updatePwd(userId, pwd, nPwd);
		
		if(upT != null) {
			request.setAttribute("msg", "true");
			request.getSession().setAttribute("loginMember", upT);
		}else {
			request.setAttribute("msg", "비밀번호 변경 실패");
		}
		
		request.getRequestDispatcher("views/Member/pwdUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
