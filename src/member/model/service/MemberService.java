package member.model.service;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import static common.SQLJDBCTemplate.*;

import java.sql.Connection;

public class MemberService {
	MemberDao md = new MemberDao();

	public Member loginMember(String logId, String logPwd) {
		Connection con = getConnection();
		
		Member loginMember = md.loginMember(con,logId,logPwd);
		close(con);
		return loginMember;
	}

	public int idCheck(String id) {
		Connection con = getConnection();
		
		int result = md.idCheck(con, id);
		
		close(con);
		return result;
	}

	public int insertMember(Member t) {
		Connection con = getConnection();
		int result = md.insertMember(con, t);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public Member updateMember(Member t) {
		Connection con = getConnection();
		Member upM = null;
		
		int result = md.updateMember(con, t);
		
		if(result>0) {
			upM = md.selectMember(con, t.gettId());
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return upM;
	}

	public Member updatePwd(String userId, String pwd, String nPwd) {
		Connection con = getConnection();
		Member upT = null;
		
		int result = md.updatePwd(con, userId, pwd, nPwd);
		
		if(result > 0) {
			upT = md.selectMember(con, userId);
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return upT;
	}

	public int deleteMember(String gettId) {
		Connection con = getConnection();
		
		int result = md.deleteMember(con, gettId);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

}
