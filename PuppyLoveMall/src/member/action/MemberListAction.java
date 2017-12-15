package member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import member.svc.MemberListService;
import member.vo.MemberVO;


public class MemberListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ActionForward forward = null;
		if (id == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("memberLogin.me");
		} else if (id.equals("admin")){
			forward = new ActionForward();
			MemberListService list = new MemberListService();
			List<MemberVO> memberList = list.getMemberList();
			forward.setPath("member/member_list.jsp");
		} else if (!id.equals("admin")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("puppyList.pu");
		}
		return forward;
	}
}