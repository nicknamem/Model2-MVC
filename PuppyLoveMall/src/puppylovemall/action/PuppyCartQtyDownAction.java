package puppylovemall.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import puppylovemall.svc.PuppyCartQtyDownService;


public class PuppyCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		System.out.println("kind = " + kind);
		
		PuppyCartQtyDownService puppyCartQtyDownService = new PuppyCartQtyDownService();
		puppyCartQtyDownService.downCartQty(kind,request);
		ActionForward forward = new ActionForward("puppyCartList.puppy",true);
		
		return forward;
	}

}
