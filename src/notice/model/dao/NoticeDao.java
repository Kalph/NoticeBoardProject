package notice.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import notice.model.vo.Notice;
import static common.JDBCTemplate.*;

public class NoticeDao {
	private Properties prop = new Properties();
	
	public NoticeDao() {
		String fileName = Notice.class.getResource("/sql/notice/notice-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Notice> selectList(Connection con, int curPage, int limitNotice) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			int st  = (curPage -1) * limitNotice +1;
			int ed =  st + limitNotice -1;
			pstmt.setInt(1,st);
			pstmt.setInt(2, ed);
	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Notice(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDate(8),rs.getString(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	
	public int insertNotice(Connection con, Notice no) {
		PreparedStatement pstmt = null;
		
		int result = 0 ;
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(no.getnCid()));
			pstmt.setString(2, no.getnTitle());
			pstmt.setString(3, no.getnContent());
			pstmt.setString(4, no.getnWriter());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return result;
	}

	public int plusCount(Connection con, int nno) {
		Statement stmt = null;
		int result = 0;
		
		String sql = prop.getProperty("plusCount");
		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql+nno);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}

	public Notice selectNotice(Connection con, int nno) {
		Notice n = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectNotice");
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql + nno);
			
			while(rs.next()) {
				n = new Notice(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5)+"," +rs.getString(6),rs.getInt(7),rs.getDate(8),rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return n;
	}

	public int updateNotice(Connection con, Notice no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(no.getnCid()));
			pstmt.setString(2, no.getnTitle());
			pstmt.setString(3, no.getnContent());
			pstmt.setInt(4, no.getnNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteNotice(Connection con, int nno) {
		int result = 0;
		Statement stmt = null;

		String sql = prop.getProperty("deleteNotice");

		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql + nno);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}

		return result;
	}

	public int getListCount(Connection con) {
		int lC=0;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("getListCount");
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				lC = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return lC;
	}

	public ArrayList<Notice> NoticeSearch(Connection con, String condition,String search, int curPage, int limitNotice) {
		PreparedStatement pstmt = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		ResultSet rs = null;
		String sql = "";
		
		if(condition.equals("title")) {
			sql = prop.getProperty("searchTitle");
		}else if(condition.equals("content")){
			sql = prop.getProperty("searchContent");
		}
		
		try {
			int sR = (curPage -1 ) * limitNotice +1;
			int eR = sR + limitNotice -1;
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, sR);
			pstmt.setInt(3, eR);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Notice no = new Notice(rs.getInt(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDate(8),
						rs.getString(9));
				list.add(no);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return list;
	}

	public int getListCount(Connection con, String condition, String search) {
		PreparedStatement pstmt = null;
		int lC=0;
		ResultSet rs = null;
		
		String sql = "";
		
		if(condition.equals("title")) {
			sql = prop.getProperty("getTitleCount");
		}else if(condition.equals("content")){
			sql = prop.getProperty("getContentCount");
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				lC = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return lC;
	}


}
