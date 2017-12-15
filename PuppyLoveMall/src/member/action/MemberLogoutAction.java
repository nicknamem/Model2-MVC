package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;

public class MemberLogoutAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ActionForward forward = null;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		session.invalidate();
		out.println("<script>");
		out.println("alert('로그아웃되었습니다.')");
		out.println("location.href='puppyList.pu'");
		out.println("</script>");
		
		/*forward = new ActionForward();
		session.invalidate();
		forward.setRedirect(true);
		forward.setPath("puppyList.pu");*/
		
		return forward;
	}
}
