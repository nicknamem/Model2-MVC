package member.svc;


import static common.JdbcUtil.close;
import static common.JdbcUtil.getConnection;

import java.sql.Connection;

import member.dao.MemberDAO;
import member.vo.MemberVO;


public class MemberViewService {

	public MemberVO getMember(String viewId) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		MemberVO member = memberDAO.selectMember(viewId);
		close(con);
		return member;
	}

}
