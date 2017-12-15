package boardqna.svc;

import static common.JdbcUtil.*;

import java.sql.Connection;

import boardqna.dao.BoardQnaDAO;
import boardqna.vo.BoardQnaBean;

public class BoardQnaWriteProService {

	public boolean registArticle(BoardQnaBean boardBean) throws Exception {
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		BoardQnaDAO boardDAO = BoardQnaDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount = boardDAO.insertArticle(boardBean);

		if (insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		return isWriteSuccess;
	}

}
