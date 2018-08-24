package kr.kitri.bigdataShop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.kitri.bigdataShop.product.comment.ProductCommentDTO;
import kr.kitri.bigdataShop.product.comment.ProductCommentService;

@Controller
public class ProductController {
	// 전체상품 보기, 카테고리별 보기 ~ String으로 카테고리
	@Autowired
	ProductService service;
	
	@Autowired
	ProductCommentService cmtservice;
	
	@RequestMapping("/product/list.do")
	public ModelAndView list(String category) {
		ModelAndView mav = new ModelAndView();
		List<ProductDTO> productlist = service.productlist(category);
		mav.addObject("productlist", productlist);
		mav.setViewName("product/list");
		return mav;
	}

	// 상품 상세보기
	@RequestMapping("/product/{category_no}/{prd_no}")
	public String showProduct(@PathVariable String category_no,@PathVariable String prd_no, Model model) {
		//System.out.println("상품조회:" + prd_no);
		ProductDTO product = service.read(prd_no);
		List<ProductCommentDTO> prdcmtlist = cmtservice.CmtList(prd_no);
		model.addAttribute("prdcmtlist", prdcmtlist);
		model.addAttribute("product",product);
		
		return "product/read";
	}
}
