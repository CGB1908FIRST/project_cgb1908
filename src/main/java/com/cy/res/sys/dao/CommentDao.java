package com.cy.res.sys.dao;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.cy.res.commom.vo.ServiceException;
import com.cy.res.sys.entity.CommentEntity;

/**
 * 商品评价层接口
 * @author xiezhonghuai
 *
 */


@Mapper
public interface CommentDao {
	
	/**添加商品评价
	 * @author xiezhonghuai
	 *@param 
	 *@return
	 */
	public int insert(CommentEntity comment);
	
	
	/**用户根据商品id查询商品评价,返回值为一组评论
	 * @author xiezhonghuai
	 *@param  Integer ProductId 商品id
	 *@return List<CommentEntity>  返回一个评价集合
	 */
	public List<CommentEntity> findCommentByProductId(Integer productId);
	

	/**用户根据评论id删除评论
	 * @author xiezhonghuai
	 *@param  Integer commentId 评论id
	 *@return int  返回一个改动行数
	 */
	@Delete("delete from comment where comment_id=#{commentId}")
	public int deleteById(Integer commentId);
	
	/**用户根据评论id查询商品评价,返回该评论
	 * @author xiezhonghuai
	 *@param  Integer commentId 评论id
	 *@return CommentEntity 返回一个评价
	 * @throws Exception 
	 */
	public CommentEntity findCommentByCommentIds(Integer commentId) throws ServiceException;
	
}
