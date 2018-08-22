package kr.kitri.bigdataShop.board;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boarddao")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(BoardDTO data) {
		int result = sqlSession.insert("kr.kitri.bigdataShop.board.insert", data);
		return result;
	}
	
	@Override
	public List<BoardDTO> boardList() {
		return sqlSession.selectList("kr.kitri.bigdataShop.board.listall");
	}

	@Override
	public List<BoardDTO> searchList(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> searchList(String tag, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> pageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int fileInsert(ArrayList<String> filelist) {
		// TODO Auto-generated method stub
		return 0;
	} 



}
