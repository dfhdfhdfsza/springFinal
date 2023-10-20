package com.myWeb.www.service;

import java.util.List;

import com.myWeb.www.domain.commentVO;

public interface CommentService {

	int postComment(commentVO cvo);

	List<commentVO> getList(int bno);

	int removeComment(int cno);

}
