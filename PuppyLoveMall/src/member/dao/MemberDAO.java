package member.dao;

import static common.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import member.vo.MemberVO;

public class MemberDAO {
	public static MemberDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public String selectLoginId(MemberVO member) {
		String loginId = null;
		String sql = "SELECT id FROM member WHERE id=? AND pw=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				loginId = rs.getString("id");
			}
		} catch (Exception ex) {
			System.out.println("login() 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return loginId;
	}

	public int insertMember(MemberVO member) {
		String sql = "INSERT INTO member VALUES (?,?,?,?,?,?,?,?)";
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getTel());
			pstmt.setString(8, member.getAddr());
			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("joinMember() 에러 : " + ex);
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public List<MemberVO> selectMemberList() {
		String sql = "SELECT * FROM member";
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberVO member = null;
		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					member = new MemberVO();
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setName(rs.getString("name"));
					member.setAge(rs.getInt("age"));
					member.setGender(rs.getString("gender"));
					member.setEmail(rs.getString("email"));
					member.setTel(rs.getString("tel"));
					member.setAddr(rs.getString("addr"));
					memberList.add(member);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getMemberList() 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}

	public MemberVO selectMember(String id) {
		String sql = "SELECT * FROM member WHERE id=?";
		MemberVO member = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
				member.setTel(rs.getString("tel"));
				member.setAddr(rs.getString("addr"));
			}
		} catch (Exception ex) {
			System.out.println("getMember() 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return member;
	}

	public int deleteMember(String id) {
		String sql = "DELETE FROM member WHERE id=?";
		int deleteCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("deleteMember() 에러 : " + ex);
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}
}