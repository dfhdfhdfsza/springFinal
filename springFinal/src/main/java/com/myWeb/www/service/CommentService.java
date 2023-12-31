package com.myWeb.www.service;

import java.util.List;

import com.myWeb.www.domain.commentVO;
import com.myWeb.www.domain.pagingVO;
import com.myWeb.www.handler.PagingHandler;

public interface CommentService {

	int postComment(commentVO cvo);

//	List<commentVO> getList(int bno);

	int removeComment(int cno);

	int modifyComment(commentVO cvo);

	PagingHandler getList(int bno, pagingVO pgvo);

	

}
