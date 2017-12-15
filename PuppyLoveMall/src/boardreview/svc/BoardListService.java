package boardreview.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import boardreview.dao.BoardDAO;
import boardreview.vo.BoardBean;

public class BoardListService {

	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount();
		close(con);
		return listCount;
	}

	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception {
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page, limit);
		close(con);
		return articleList;
	}

}
