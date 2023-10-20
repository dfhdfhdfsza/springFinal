package com.myWeb.www.repository;

import java.util.List;

import com.myWeb.www.domain.commentVO;

public interface CommentDAO {

	int postComment(commentVO cvo);

	List<commentVO> getList(int bno);

	int removeComment(int cno);

}
