package boardqna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardqna.action.BoardQnaDeleteProAction;
import boardqna.action.BoardQnaDetailAction;
import boardqna.action.BoardQnaListAction;
import boardqna.action.BoardQnaModifyFormAction;
import boardqna.action.BoardQnaModifyProAction;
import boardqna.action.BoardQnaReplyFormAction;
import boardqna.action.BoardQnaReplyProAction;
import boardqna.action.BoardQnaWriteProAction;
import common.Action;
import common.ActionForward;

@WebServlet("*.boq")
public class BoardQnaFrontController extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/boardWriteForm.boq")) {
			forward = new ActionForward();
			forward.setPath("boardqna/board/qna_board_write.jsp");
		} else if (command.equals("/boardWritePro.boq")) {
			action = new BoardQnaWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardList.boq")) {
			action = new BoardQnaListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDetail.boq")) {
			action = new BoardQnaDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardReplyForm.boq")) {
			action = new BoardQnaReplyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardReplyPro.boq")) {
			action = new BoardQnaReplyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyForm.boq")) {
			action = new BoardQnaModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyPro.boq")) {
			action = new BoardQnaModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDeleteForm.boq")) {
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			request.setAttribute("board_num", board_num);
			forward = new ActionForward();
			forward.setPath("/boardqna/board/qna_board_delete.jsp");
		} else if (command.equals("/boardDeletePro.boq")) {
			action = new BoardQnaDeleteProAction();
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}