package kr.kitri.bigdataShop.product.comment;

import java.util.List;

public interface ProductCommentDAO {
	int insert(ProductCommentDTO prdcmt) ;
	int delete(ProductCommentDTO prdcmt);
	List<ProductCommentDTO> CmtList(String prd_no);
}
