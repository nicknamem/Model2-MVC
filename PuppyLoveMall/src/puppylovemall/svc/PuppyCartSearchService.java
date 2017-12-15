package puppylovemall.svc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import puppylovemall.vo.Cart;

public class PuppyCartSearchService {

	public List<Cart> getCartSearchList(int start_money, int end_money, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Cart> oldCartList = (ArrayList<Cart>)session.getAttribute("cartList");
		List<Cart> cartList = new ArrayList<Cart>();
		
		for (int i = 0; i < oldCartList.size(); i++) {
			if(oldCartList.get(i).getPrice()>=start_money && oldCartList.get(i).getPrice()<=end_money){
				cartList.add(oldCartList.get(i));
			}
		}
		
		return cartList;
	}
	
}