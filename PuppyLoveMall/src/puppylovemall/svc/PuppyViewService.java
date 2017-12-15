package puppylovemall.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.commit;
import static common.JdbcUtil.getConnection;
import static common.JdbcUtil.rollback;

import java.sql.Connection;

import puppylovemall.dao.PuppyDAO;
import puppylovemall.vo.Puppy;


public class PuppyViewService {

	public Puppy getPuppyView(int id) {
		Connection con = getConnection();
		PuppyDAO puppyDAO = PuppyDAO.getInstance();
		puppyDAO.setConnection(con);	
		int updateCount = puppyDAO.updateReadCount(id);
		
		if(updateCount>0){
			commit(con);
		}else{
			rollback(con);
		}
		
		Puppy puppy = puppyDAO.selectPuppy(id);
		close(con);
		
		return puppy;
	}

}
