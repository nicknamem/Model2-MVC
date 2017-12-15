package puppylovemall.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import puppylovemall.svc.PuppyCartListService;
import puppylovemall.vo.Cart;


public class PuppyCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PuppyCartListService puppyCartListService = new PuppyCartListService();
		ArrayList<Cart> cartList = puppyCartListService.getCartList(request);
		
		int totalMoney = 0;
		int money = 0 ;
		
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += money;
		}

		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("puppyCartList.jsp", false);
		
		return forward;
	}

}
