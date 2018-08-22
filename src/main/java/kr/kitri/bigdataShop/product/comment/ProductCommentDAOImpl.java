package kr.kitri.bigdataShop.product.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("productcommentdao")
public class ProductCommentDAOImpl implements ProductCommentDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(ProductCommentDTO prdcmt) {
		int result = sqlSession.insert("kr.kitri.bigdataShop.product.comment.insert", prdcmt);
		return result;
	}
	
	@Override
	public List<ProductCommentDTO> CmtList(String prd_no) {
		return sqlSession.selectList("kr.kitri.bigdataShop.product.comment.list", prd_no);
	}

	@Override
	public int delete(ProductCommentDTO prdcmt) {
		int result = sqlSession.delete("kr.kitri.bigdataShop.product.comment.delete", prdcmt);
		return result;
	}



}
