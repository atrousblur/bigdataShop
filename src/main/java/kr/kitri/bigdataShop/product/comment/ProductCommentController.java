package kr.kitri.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProductCommentController {

	@Autowired
	ProductCommentService service;
	
	
	// json ajax 처리 해줘야됨
	@RequestMapping("/product/{category_no}/{prd_no}")
	public String showProductCmt(@PathVariable String category_no,@PathVariable String prd_no, Model model) {
		List<ProductCommentDTO> prdcmtList = service.CmtList(prd_no);
		model.addAttribute("prdcmtList",prdcmtList);
		return "product/read";
	}
	
	@RequestMapping(value = "/product/comment/write.do", method = RequestMethod.POST)
	public String write(ProductCommentDTO prdcmt) {
		int result = service.insert(prdcmt);
		System.out.println(result + "개 행 삽입 성공");
		return "redirect:/board/list.do";
	}
	
	
}
