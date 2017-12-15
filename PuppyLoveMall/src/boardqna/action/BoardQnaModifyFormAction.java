package boardqna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardqna.svc.BoardQnaDetailService;
import boardqna.vo.BoardQnaBean;
import common.Action;
import common.ActionForward;

public class BoardQnaModifyFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String nowPage = request.getParameter("page");
		BoardQnaDetailService boardDetailService = new BoardQnaDetailService();
		BoardQnaBean article = boardDetailService.getArticle(board_num);
		
		request.setAttribute("article", article);
		request.setAttribute("page", nowPage);
		forward.setPath("/boardqna/board/qna_board_modify.jsp");
		return forward;
	}

}