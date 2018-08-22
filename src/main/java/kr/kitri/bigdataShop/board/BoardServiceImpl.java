package kr.kitri.bigdataShop.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boarddao")
	BoardDAO dao;
	
	@Override
	public int insert(BoardDTO data, ArrayList<String> filelist) {
		return dao.insert(data);
	}
	
	@Override
	public List<BoardDTO> boardList() {
		return dao.boardList();
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


}
