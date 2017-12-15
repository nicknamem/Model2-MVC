package boardreview.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardqna.svc.BoardQnaDetailService;
import boardqna.vo.BoardQnaBean;
import common.Action;
import common.ActionForward;

public class BoardDetailAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		BoardQnaDetailService boardDetailService = new BoardQnaDetailService();
		BoardQnaBean article = boardDetailService.getArticle(board_num);
		ActionForward forward = new ActionForward();
		
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		forward.setPath("/boardreview/board/qna_board_view.jsp");
		return forward;
	}

}