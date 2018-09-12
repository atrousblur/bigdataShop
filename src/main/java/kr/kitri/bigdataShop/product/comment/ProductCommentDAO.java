package kr.kitri.bigdataShop.product.comment;

import java.util.List;

public interface ProductCommentDAO {
	int insert(ProductCommentDTO prdcmt) ;
	int delete(ProductCommentDTO prdcmt);
	List<ProductCommentDTO> CmtList(String prd_no);

	//관리자화면에 추가되는 하둡처리결과(테이블로 저장)도 메소드로 추가
	List<CommentResultDTO> commentResult();
}