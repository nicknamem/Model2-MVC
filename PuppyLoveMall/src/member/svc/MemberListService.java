package member.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import member.dao.MemberDAO;
import member.vo.MemberVO;

public class MemberListService {

	public List<MemberVO> getMemberList() {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		List<MemberVO> memberList = memberDAO.selectMemberList();
		close(con);
		return memberList;
	}

}
