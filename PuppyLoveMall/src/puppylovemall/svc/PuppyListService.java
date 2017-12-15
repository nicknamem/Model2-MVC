package puppylovemall.svc;

import static common.JdbcUtil.close;
import static common.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import puppylovemall.dao.PuppyDAO;
import puppylovemall.vo.Puppy;


public class PuppyListService {
	
	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		PuppyDAO puppyDAO = PuppyDAO.getInstance();
		puppyDAO.setConnection(con);
		listCount = puppyDAO.selectListCount();
		close(con);
		return listCount;
	}

	public List<Puppy> getPuppyList(int page, int limit) throws Exception {
		List<Puppy> puppyList = null;
		Connection con = getConnection();
		PuppyDAO puppyDAO = PuppyDAO.getInstance();
		puppyDAO.setConnection(con);
		puppyList = puppyDAO.selectPuppyList(page, limit);
		close(con);
		return puppyList;
	}

//	public List<Puppy> getPuppyList() {
//		PuppyDAO puppyDAO = PuppyDAO.getInstance();
//		Connection con = getConnection();
//		puppyDAO.setConnection(con);		
//		List<Puppy> puppyList = puppyDAO.selectPuppyList();
//		close(con);
//		
//		return puppyList;
//	}
	
}