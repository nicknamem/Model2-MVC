package puppylovemall.dao;

import static common.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import puppylovemall.vo.Puppy;

public class PuppyDAO {
	
	Connection con;
	private static PuppyDAO puppyDAO;
	
	private PuppyDAO() {
		
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public static PuppyDAO getInstance(){
		
		if(puppyDAO ==null){
			puppyDAO = new PuppyDAO();
		}
		
		return puppyDAO;
	}
	
	// 글의 개수 구하기
	public int selectListCount() {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println("getConnection");
			pstmt = con.prepareStatement("select count(*) from puppy");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;
	}

	// 글 목록 보기
	public List<Puppy> selectPuppyList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// MySQL 몇번부터 몇개
//			String board_list_sql = "select * from board "
//					+ "order by BOARD_RE_REF desc, BOARD_RE_SEQ asc limit ?, 10";
		
		// Oracle 몇번부터 몇번까지
		String puppy_list_sql = 
				"select * from "
				+ "(select rownum as rnum, pu.* "
				+ "from (select * from puppy order by id desc) pu) "
				+ "where rnum between ? and ?";
				
		
		List<Puppy> puppyList = new ArrayList<Puppy>();
		Puppy puppy = null;
		
		int startrow = (page - 1) * limit + 1; // 읽기 시작할 번호 limit = 10
		int endrow = page * limit; // limit = 10
		

		try {
			pstmt = con.prepareStatement(puppy_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				puppy = new Puppy(
					rs.getInt("id"),
					rs.getString("kind"),
					rs.getInt("price"),
					rs.getString("image"),
					rs.getString("country"),
					rs.getInt("height"),
					rs.getInt("weight"),
					rs.getString("content"),
					rs.getInt("readcount")	
				);
				puppyList.add(puppy);
			}

		} catch (Exception ex) {
			System.out.println("getPuppyList 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return puppyList;
	}
	
	public Puppy selectPuppy(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Puppy puppy = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM puppy WHERE id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				puppy = new Puppy(
						rs.getInt("id")
						,rs.getString("kind")
						,rs.getInt("price")
						,rs.getString("image")
						,rs.getString("country")
						,rs.getInt("height")
						,rs.getInt("weight")
						,rs.getString("content")
						,rs.getInt("readcount"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return puppy;
	}
	
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		
		try {
			sql = "UPDATE puppy SET readcount = readcount + 1 WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	public int insertPuppy(Puppy puppy) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "INSERT INTO puppy VALUES(puppy_seq.nextval,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, puppy.getKind());
			pstmt.setInt(2, puppy.getPrice());
			pstmt.setString(3, puppy.getImage());
			pstmt.setString(4, puppy.getCountry());
			pstmt.setInt(5, puppy.getHeight());
			pstmt.setInt(6, puppy.getWeight());
			pstmt.setString(7, puppy.getContent());
			pstmt.setInt(8, puppy.getReadcount());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
}
