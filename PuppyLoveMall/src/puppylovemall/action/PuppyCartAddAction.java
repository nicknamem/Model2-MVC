package puppylovemall.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import puppylovemall.svc.PuppyCartAddService;
import puppylovemall.vo.Puppy;


public class PuppyCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PuppyCartAddService puppyCartAddService = new PuppyCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Puppy cartPuppy = puppyCartAddService.getCartPuppy(id);
		puppyCartAddService.addCart(request,cartPuppy);
		ActionForward forward = new ActionForward("puppyCartList.puppy", true);
		
		return forward;
	}

}
