package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import static common.JDBCTemplate.*;

public class NoticeService {
	NoticeDao nd = new NoticeDao();

	public ArrayList<Notice> selectList(int curPage, int limitNotice) {
		Connection con = getConnection();
		ArrayList<Notice> list = nd.selectList(con,curPage,limitNotice);
		
		close(con);
		return list;
	}

	public int insertNotice(Notice no) {
		Connection con = getConnection();
		int result = nd.insertNotice(con,no);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public Notice selectNotice(int nno) {
		Connection con = getConnection();
		
		int result = 0; 
		
		result = nd.plusCount(con, nno);
		
		Notice n = null;
		if(result >0) {
			n = nd.selectNotice(con,nno);
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return n;
	}

	public Notice selectNoticeNoCnt(int nno) {
		Connection con = getConnection();
		Notice n = nd.selectNotice(con, nno);
		close(con);
		return n;
	}

	public int updateNotice(Notice no) {
		Connection con = getConnection();
		int result = nd.updateNotice(con,no);
		
		if(result >0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int deleteNotice(int nno) {
		Connection con = getConnection();
		
		int result = nd.deleteNotice(con,nno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = nd.getListCount(con);
		close(con);
		return listCount;
	}
	

	public ArrayList<Notice> NoticeSearch(String condition, String search, int curPage, int limitNotice) {
		Connection con = getConnection();
		
		ArrayList<Notice> list = nd.NoticeSearch(con,condition,search,curPage,limitNotice);
		close(con);
		return list;
	}

	public int getListCount(String condition, String search) {
		Connection con =getConnection();
		int listCount = nd.getListCount(con,condition, search);
		close(con);
		
		return listCount;
	}


}
