package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import member.svc.MemberJoinService;
import member.vo.MemberVO;


public class MemberJoinAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO member = new MemberVO();
		boolean joinResult = false;

		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setGender(request.getParameter("gender"));
		member.setEmail(request.getParameter("email"));
		member.setTel(request.getParameter("tel"));
		member.setAddr(request.getParameter("addr"));

		MemberJoinService memberJoinService = new MemberJoinService();
		joinResult = memberJoinService.joinMember(member);

		ActionForward forward = null;
		if (joinResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberLogin.me");
		}
		return forward;
	}
}