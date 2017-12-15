package boardreview.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.commit;
import static common.JdbcUtil.getConnection;
import static common.JdbcUtil.rollback;

import java.sql.Connection;

import boardreview.dao.BoardDAO;
import boardreview.vo.BoardBean;

public class BoardDetailService {

	public BoardBean getArticle(int board_num) throws Exception {
		BoardBean article = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
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
