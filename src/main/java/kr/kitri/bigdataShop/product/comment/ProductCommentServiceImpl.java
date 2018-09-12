package kr.kitri.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {

	@Autowired
	@Qualifier("productcommentdao")
	ProductCommentDAO dao;
	
	@Override
	public int insert(ProductCommentDTO prdcmt) {
		return dao.insert(prdcmt);
	}

	@Override
	public int delete(ProductCommentDTO prdcmt) {
		return dao.delete(prdcmt);
	}

	@Override
	public List<ProductCommentDTO> CmtList(String prd_no) {
		return dao.CmtList(prd_no);
	}
	@Override
	public List<CommentResultDTO> commentResult() {
		return dao.commentResult();
	}
	
}
