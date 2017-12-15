package puppylovemall.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import puppylovemall.dao.PuppyDAO;
import puppylovemall.vo.Cart;
import puppylovemall.vo.Puppy;


public class PuppyCartAddService {

	public Puppy getCartPuppy(int id) {
		Connection con = getConnection();
		PuppyDAO puppyDAO = PuppyDAO.getInstance();
		puppyDAO.setConnection(con);	
		Puppy puppy = puppyDAO.selectPuppy(id);
		close(con);
		return puppy;
	}

	public void addCart(HttpServletRequest request, Puppy cartPuppy) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null){
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		
		for (int i = 0; i < cartList.size(); i++) {
			if(cartPuppy.getKind().equals(cartList.get(i).getKind())){
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
		}
		
		if(isNewCart){
			Cart cart = new Cart();
			cart.setImage(cartPuppy.getImage());
			cart.setKind(cartPuppy.getKind());
			cart.setPrice(cartPuppy.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
		
	}
	
}