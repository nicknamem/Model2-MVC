package puppylovemall.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import puppylovemall.svc.PuppyViewService;
import puppylovemall.vo.Puppy;


public class PuppyViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PuppyViewService puppyViewService = new PuppyViewService();
		int id = Integer.parseInt(request.getParameter("id"));
		Puppy puppy = puppyViewService.getPuppyView(id);
		request.setAttribute("puppy", puppy);
		
		Cookie todayImageCookie = new Cookie("today"+id, puppy.getImage());
		todayImageCookie.setMaxAge(60*60*24);
		response.addCookie(todayImageCookie);
		ActionForward forward = new ActionForward("puppyView.jsp", false);
		
		return forward;
	}
	
}