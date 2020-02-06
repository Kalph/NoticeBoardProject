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
 * Servlet implementation class insertMemberServlet
 */
@WebServlet("/insert.me")
public class insertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("memberId");
		String pwd = request.getParameter("pwd1");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String its[] = request.getParameterValues("interest");
		
		String it = "";
		
		if(its != null) {
			it = String.join(",", its);
		}else {
			it = "없음";
		}
		
		Member t = new Member(id,pwd,name,phone,email,it);
		
		int result = new MemberService().insertMember(t);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "회원 가입 성공");
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("msg", "회원 가입 실패.");
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
