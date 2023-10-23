package com.myWeb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myWeb.www.domain.commentVO;
import com.myWeb.www.domain.pagingVO;
import com.myWeb.www.handler.PagingHandler;
import com.myWeb.www.repository.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService
{
	@Inject
	private CommentDAO cdao;

	@Override
	public int postComment(commentVO cvo) {
		return cdao.postComment(cvo);
	}

//	@Override
//	public List<commentVO> getList(int bno) {
//		return cdao.getList(bno);
//	}

	@Override
	public int removeComment(int cno) {
		return cdao.removeComment(cno);
	}

	@Override
	public int modifyComment(commentVO cvo) {
		return cdao.modifyComment(cvo);
	}

	@Override
	public PagingHandler getList(int bno, pagingVO pgvo) {
		//totalCount
		int totalCount = cdao.selectOneBnoTotalCount(bno);
		//Comment List 찾아오기
		List<commentVO> list=cdao.selectListPaging(bno,pgvo);
		PagingHandler ph= new PagingHandler(pgvo, totalCount,list);
		//PagingHandler값 완성 후 리턴
		return ph;
	}

	

}
