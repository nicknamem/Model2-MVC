package boardqna.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.commit;
import static common.JdbcUtil.getConnection;
import static common.JdbcUtil.rollback;

import java.sql.Connection;

import boardqna.dao.BoardQnaDAO;
import boardqna.vo.BoardQnaBean;

public class BoardQnaDetailService {

	public BoardQnaBean getArticle(int board_num) throws Exception {
		BoardQnaBean article = null;
		Connection con = getConnection();
		BoardQnaDAO boardDAO = BoardQnaDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateReadCount(board_num);

		if (updateCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		article = boardDAO.selectArticle(board_num);
		close(con);
		return article;
	}

}
