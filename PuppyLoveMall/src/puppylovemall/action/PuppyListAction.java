package puppylovemall.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import common.PageInfo;
import puppylovemall.svc.PuppyListService;
import puppylovemall.vo.Puppy;


public class PuppyListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		// 쿠키를 통해서 오늘 본 상품		
		List<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();
		
		if(cookieArray != null) {
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")){
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		
		// 상품리스트 페이징 처리
//		List<Puppy> puppyList = new ArrayList<Puppy>();
		int page = 1;
		int limit = 12; // 한 페이지 당 글 개수

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		PuppyListService puppyListService = new PuppyListService();
		int listCount = puppyListService.getListCount();
		System.out.println("puppy 수 : " + listCount);

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
		
		List<Puppy> puppyList = puppyListService.getPuppyList(page, limit);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("puppyList", puppyList);
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward("puppymall/puppyList.jsp", false);
		
		return forward;
	}
	
}
