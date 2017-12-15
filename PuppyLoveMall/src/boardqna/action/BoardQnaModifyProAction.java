package boardqna.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardqna.svc.BoardQnaModifyProService;
import boardqna.vo.BoardQnaBean;
import common.Action;
import common.ActionForward;

public class BoardQnaModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean isModifySuccess = false;
		int board_num = Integer.parseInt(request.getParameter("BOARD_NUM"));
		String nowPage = request.getParameter("page"); // 추가
		BoardQnaBean article = new BoardQnaBean();
		BoardQnaModifyProService boardModifyProService = new BoardQnaModifyProService();
		boolean isRightUser = boardModifyProService.isArticleWriter(board_num, request.getParameter("BOARD_PASS"));

		if (!isRightUser) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			article.setBOARD_NUM(board_num);
			article.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			article.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
			isModifySuccess = boardModifyProService.modifyArticle(article);

			if (!isModifySuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정 실패');");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				// 수정
				forward.setPath("boardDetail.boq?board_num=" + article.getBOARD_NUM() + "&page=" + nowPage);
			}

		}

		return forward;
	}

}