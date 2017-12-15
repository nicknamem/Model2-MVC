package puppylovemall.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import puppylovemall.svc.PuppyCartRemoveService;


public class PuppyCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] kindArray = request.getParameterValues("remove");
		PuppyCartRemoveService puppyCartRemoveService = new PuppyCartRemoveService();
		puppyCartRemoveService.cartRemove(request,kindArray);
		ActionForward forward = new ActionForward("puppyCartList.puppy",true);
		
		return forward;
	}
	
}