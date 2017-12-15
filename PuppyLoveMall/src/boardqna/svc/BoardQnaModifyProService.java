package boardqna.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.commit;
import static common.JdbcUtil.getConnection;
import static common.JdbcUtil.rollback;

import java.sql.Connection;

import boardqna.dao.BoardQnaDAO;
import boardqna.vo.BoardQnaBean;

public class BoardQnaModifyProService {

	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardQnaDAO boardDAO = BoardQnaDAO.getInstance();
		boardDAO.setConnection(con);
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		close(con);
		return isArticleWriter;
	}

	public boolean modifyArticle(BoardQnaBean article) throws Exception {
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardQnaDAO boardDAO = BoardQnaDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateArticle(article);

		if (updateCount > 0) {
			commit(con);
			isModifySuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		return isModifySuccess;
	}

}
