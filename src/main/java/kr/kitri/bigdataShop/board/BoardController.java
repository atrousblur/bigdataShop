package kr.kitri.bigdataShop.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BoardController {
	@Autowired
	BoardService service;

	@RequestMapping(value = "/board/write.do", method = RequestMethod.POST)
	public String write(BoardDTO data, ArrayList<String> filelist,
			FileUploadDTO fileInfo, HttpSession session) {
		int result = service.insert(data, filelist);
		System.out.println(result + "개 행 삽입 성공");
		return "redirect:/board/list.do";
	}

	@RequestMapping(value = "/board/list.do")
	public ModelAndView showlist() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> boardlist = service.boardList();
		mav.addObject("boardlist", boardlist);
		mav.setViewName("board/list"); 
		return mav;
	}

}
