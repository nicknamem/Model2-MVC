package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import member.svc.MemberViewService;
import member.vo.MemberVO;


public class MemberViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		ActionForward forward = null;
		if (id == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("memberLogin.me");
		} else if (!id.equals("admin")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아닙니다.');");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		} else { // admin(관리자) 일때
			forward = new ActionForward();
			String viewId = request.getParameter("id");
			MemberViewService memberViewService = new MemberViewService();
			MemberVO member = memberViewService.getMember(viewId);
			request.setAttribute("member", member);
			forward.setPath("member/member_info.jsp");
		}
		return forward;
	}
}