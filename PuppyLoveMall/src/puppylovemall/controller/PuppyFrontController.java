package puppylovemall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import puppylovemall.action.PuppyCartAddAction;
import puppylovemall.action.PuppyCartListAction;
import puppylovemall.action.PuppyCartQtyDownAction;
import puppylovemall.action.PuppyCartQtyUpAction;
import puppylovemall.action.PuppyCartRemoveAction;
import puppylovemall.action.PuppyCartSearchAction;
import puppylovemall.action.PuppyListAction;
import puppylovemall.action.PuppyRegistAction;
import puppylovemall.action.PuppyRegistFormAction;
import puppylovemall.action.PuppyViewAction;

@WebServlet("*.pu")
public class PuppyFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		Action action = null;
		ActionForward forward = null;

		if (command.equals("/puppyList.pu")) {
			action = new PuppyListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/puppyView.pu")) {
			action = new PuppyViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/puppyCartAdd.pu")) {
			action = new PuppyCartAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/puppyCartList.pu")) {
			action = new PuppyCartListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/puppyCartSearch.pu")) {
			action = new PuppyCartSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/puppyCartRemove.pu")) {
			action = new PuppyCartRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/puppyCartQtyUp.pu")) {
			action = new PuppyCartQtyUpAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/puppyCartQtyDown.pu")) {
			action = new PuppyCartQtyDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/puppyRegist.pu")) {
			action = new PuppyRegistAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/puppyRegistForm.pu")) {
			action = new PuppyRegistFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

}
