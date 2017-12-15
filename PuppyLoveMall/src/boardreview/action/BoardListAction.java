package boardreview.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardreview.svc.BoardListService;
import boardreview.vo.BoardBean;
import boardreview.vo.PageInfo;
import common.Action;
import common.ActionForward;

public class BoardListAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		BoardListService boardService = new BoardListService();
		int listCount = boardService.getListCount(); 
		articleList = boardService.getArticleList(page, limit); 

		int maxPage = (int) ((double) listCount / limit + 0.95);
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * limit + 1;
		int endPage = startPage + limit - 1;

		if (endPage > maxPage)
			endPage = maxPage;

		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward = new ActionForward();
		forward.setPath("/boardreview/board/qna_board_list.jsp");
		return forward;
	}

}