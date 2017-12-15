package boardqna.svc;

import static common.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import boardqna.dao.BoardQnaDAO;
import boardqna.vo.BoardQnaBean;

public class BoardQnaListService {

	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		BoardQnaDAO boardDAO = BoardQnaDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount();
		close(con);
		return listCount;
	}

	public ArrayList<BoardQnaBean> getArticleList(int page, int limit) throws Exception {
		ArrayList<BoardQnaBean> articleList = null;
		Connection con = getConnection();
		BoardQnaDAO boardDAO = BoardQnaDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page, limit);
		close(con);
		return articleList;
	}

}
