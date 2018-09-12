package kr.kitri.bigdataShop.product.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductCommentController {

	@Autowired
	ProductCommentService service;

	@RequestMapping(value = "/product/comment/write.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody List<ProductCommentDTO> write(ProductCommentDTO prdcmt) {
		int result = service.insert(prdcmt);
		List<ProductCommentDTO> prdcmtlist = service.CmtList(prdcmt.getPrd_no());
		System.out.println(result + "개 행 삽입 성공");
		return prdcmtlist;
	}

	@RequestMapping(value = "/product/comment/delete.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody List<ProductCommentDTO> delete(ProductCommentDTO prdcmt) {
		int result = service.delete(prdcmt);
		List<ProductCommentDTO> prdcmtlist = service.CmtList(prdcmt.getPrd_no());
		System.out.println(result + "개 행 삭제 성공");
		return prdcmtlist;
	}

	@RequestMapping(value = "/comment/result.do", method = RequestMethod.GET)
	public ModelAndView showCommentResult() {
		ModelAndView mav = new ModelAndView();
		List<CommentResultDTO> resultList = service.commentResult();
		List<CommentResultDTO> tableList = new ArrayList<CommentResultDTO>();
		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			CommentResultDTO result = resultList.get(i);
			tableList.add(result);
			if (i == 10) {
				break;
			}
		}
		mav.addObject("resultList", resultList);
		mav.addObject("tableList", tableList);
		mav.setViewName("comment/result");
		return mav;
	}
}