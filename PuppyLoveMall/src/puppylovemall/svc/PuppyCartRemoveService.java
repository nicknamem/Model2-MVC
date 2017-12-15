package puppylovemall.svc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import puppylovemall.vo.Cart;

public class PuppyCartRemoveService {
	
	public void cartRemove(HttpServletRequest request, String[] kindArray) {
		HttpSession session = request.getSession();
		List<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for (int i = 0; i < kindArray.length; i++) {
			for (int j = 0; j < cartList.size(); j++) {
				if(cartList.get(j).getKind().equals(kindArray[i])) {
						cartList.remove(cartList.get(j));
				}
			}
		}
		
	}
}