package boardqna.svc;

import static common.JdbcUtil.*;

import java.sql.Connection;

import boardqna.dao.BoardQnaDAO;
import boardqna.vo.BoardQnaBean;

public class BoardQnaReplyProService {

	public boolean replyArticle(BoardQnaBean article) throws Exception {
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		BoardQnaDAO boardDAO = BoardQnaDAO.getInstance();
		boardDAO.setConnection(con);
		insertCount = boardDAO.insertReplyArticle(article);

		if (insertCount > 0) {
			commit(con);
			isReplySuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		return isReplySuccess;
	}

}
