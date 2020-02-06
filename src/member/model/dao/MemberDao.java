package member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import member.model.vo.Member;
import static common.SQLJDBCTemplate.*;

public class MemberDao {
	private Properties prop = new Properties();

	public MemberDao() {
		try {
			prop.load(new FileReader(MemberDao.class.getResource("/sql/member/member-query.properties").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member loginMember(Connection con, String logId, String logPwd) {
		Member memberLogin = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("loginMember");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, logId);
			pstmt.setString(2, logPwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberLogin = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getString(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberLogin;
	}

	public int idCheck(Connection con, String id) {
		int result = 0;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("idCheck");

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql + "'" + id + "'");

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}

	public int insertMember(Connection con, Member t) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertMember");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.gettId());
			pstmt.setString(2, t.gettPwd());
			pstmt.setString(3, t.gettName());
			pstmt.setString(4, t.getPhone());
			pstmt.setString(5, t.getEmail());
			pstmt.setString(6, t.getInterest());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateMember(Connection con, Member t) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, t.gettName());
			pstmt.setString(2, t.getPhone());
			pstmt.setString(3, t.getEmail());
			pstmt.setString(4, t.getInterest());
			pstmt.setString(5, t.gettId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Member selectMember(Connection con, String gettId) {
		Member t = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectMember");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gettId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				t = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return t;
	}

	public int updatePwd(Connection con, String userId, String pwd, String nPwd) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("updatePwd");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nPwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, pwd);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection con, String gettId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gettId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
