package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import member.svc.MemberLoginService;
import member.vo.MemberVO;


public class MemberLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		MemberVO member = new MemberVO();

		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));

		MemberLoginService memberLoginService = new MemberLoginService();
		boolean loginResult = memberLoginService.login(member);
		ActionForward forward = null;
		if (loginResult) {
			forward = new ActionForward();
			session.setAttribute("id", member.getId());
			forward.setRedirect(true);
			forward.setPath("memberListAction.me");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		}
		return forward;
	}
}