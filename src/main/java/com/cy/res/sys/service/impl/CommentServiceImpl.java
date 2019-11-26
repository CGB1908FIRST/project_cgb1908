package com.cy.res.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.res.sys.dao.CommentDao;
import com.cy.res.sys.entity.CommentEntity;
import com.cy.res.sys.service.CommentService;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
   private CommentDao commentDao;
	
	
	@Override
	public int insert(String commentContent,Double  commentCore,
			Integer productId,Integer userId) throws ServiceException{
		//1,参数有效性验证
		
		//1.1验证commentContent
		if(StringUtils.isEmpty(commentContent)) {
			throw new ServiceException("评价内容不能为空，请输入您的评语");
		}
		//1.2验证commentCore
		if(commentCore<=0 || commentCore>=5) {
			throw new ServiceException("评分超出0~5的范围，请输入正确评分数");
		}
		//1.3验证productId      |||||||有待调用队友findProductById
		//通过商品id查询商品信息，验证参数有效性
		
		//1.4验证userId
		//通过用户id查询用户信息，验证参数有效性
	
		//2初始化评价信息
		CommentEntity comment=new CommentEntity();
		comment.setCommentContent(commentContent);
		comment.setCommentCore(commentCore);
		comment.setProductId(productId);
		comment.setUserId(userId);
		int row = commentDao.insert(comment);
		
		//3验证结果
		if(row!=1) {
			throw new ServiceException("添加评论失败！");
		}
		return row;
	}

	
	@Override
	public List<CommentEntity> findCommentByProductId(Integer productId) throws ServiceException {
		//1,对参数进行校验
		//1.1对参数productId校验
				if(productId==null||productId<1)
					throw new IllegalArgumentException("productId值无效");
				
		//1.2.根据productId查询商品以及对应信息
		//如果查询为null则，返回提示该商品以及不存在。
				
		//2.查询商品评论，校验结果
				List<CommentEntity> listCommentEntity = commentDao.findCommentByProductId(productId);
		if(listCommentEntity==null || listCommentEntity.size()==0) {
		// ???? 此处 listCommentEntity.isEmpty() 与 listCommentEntity.size()==0 的区别   ==========> ????
			System.out.println("listCommentEntity:"+listCommentEntity);
			 //throw new ServiceException("该商品没有评价，快来添加您的评价吧！！！");
		}
			
		//2.1,返回结果
		return listCommentEntity;
	}


	@Override
	public int deleteComment(Integer userId,CommentEntity comment) {
		//1.1对userId参数进行校验
		if(userId==null ||userId<=0)
			throw new IllegalArgumentException("用户id不正确");
		
		//通过userId查询用户信息
		//findUserById        |||||||有待调用队友findUserById 
		
		//1.2对comment参数进行校验
		if(comment==null)
			throw new IllegalArgumentException("提交参数不正确，提交的评论对象数据为空!");
		
		//1.3对commentId参数进行校验
		if(null==comment.getCommentId() || comment.getCommentId()<=0)
			throw new IllegalArgumentException("商品评论对象数据ID异常!");
		//1.4
		CommentEntity findCommment = commentDao.findCommentByCommentIds(comment.getCommentId());
		if(null==findCommment)
			throw new ServiceException("该评价已经不存在!");
		
		//2userId和comment对应关系进行校验
		if(userId!=comment.getUserId())
			throw new ServiceException("您无权删除相关评论！");
		
		//3执行删除操作
		int row = commentDao.deleteById(comment.getCommentId());
		
		if(row!=1)
			throw new ServiceException("删除失败！");
		return row;
	}

}
