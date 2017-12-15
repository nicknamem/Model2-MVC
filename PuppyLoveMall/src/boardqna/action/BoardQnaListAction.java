package boardqna.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardqna.svc.BoardQnaListService;
import boardqna.vo.BoardQnaBean;
import boardqna.vo.PageInfo;
import common.Action;
import common.ActionForward;

public class BoardQnaListAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BoardQnaBean> articleList = new ArrayList<BoardQnaBean>();
		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		BoardQnaListService boardListService = new BoardQnaListService();
		int listCount = boardListService.getListCount(); 
		articleList = boardListService.getArticleList(page, limit); 

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
		forward.setPath("/boardqna/board/qna_board_list.jsp");
		return forward;
	}

}