package puppylovemall.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import puppylovemall.svc.PuppyCartQtyUpService;


public class PuppyCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		PuppyCartQtyUpService puppyCartQtyUpService = new PuppyCartQtyUpService();
		puppyCartQtyUpService.upCartQty(kind,request);
		ActionForward forward = new ActionForward("puppyCartList.puppy", true);
		
		return forward;
	}

}
