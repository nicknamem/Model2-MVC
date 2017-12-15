package boardreview.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.commit;
import static common.JdbcUtil.getConnection;
import static common.JdbcUtil.rollback;

import java.sql.Connection;

import boardreview.dao.BoardDAO;
import boardreview.vo.BoardBean;

public class BoardReplyProService {

	public boolean replyArticle(BoardBean article) throws Exception {
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
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
