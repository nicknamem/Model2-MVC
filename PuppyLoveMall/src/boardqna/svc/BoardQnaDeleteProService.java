package boardqna.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.commit;
import static common.JdbcUtil.getConnection;
import static common.JdbcUtil.rollback;

import java.sql.Connection;

import boardqna.dao.BoardQnaDAO;

public class BoardQnaDeleteProService {

	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardQnaDAO boardDAO = BoardQnaDAO.getInstance();
		boardDAO.setConnection(con);
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		close(con); 
		return isArticleWriter;
	}

	public boolean removeArticle(int board_num) throws Exception {
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		BoardQnaDAO boardDAO = BoardQnaDAO.getInstance();
		boardDAO.setConnection(con);
		int deleteCount = boardDAO.deleteArticle(board_num);

		if (deleteCount > 0) {
			commit(con);
			isRemoveSuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		return isRemoveSuccess;
	}

}
