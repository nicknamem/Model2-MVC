package member.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.getConnection;

import java.sql.Connection;

import member.dao.MemberDAO;
import member.vo.MemberVO;


public class MemberLoginService {

	public boolean login(MemberVO member) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean loginResult = false;
		String loginId = memberDAO.selectLoginId(member);
		if (loginId != null) {
			loginResult = true;
		}
		close(con);
		return loginResult;
	}

}
