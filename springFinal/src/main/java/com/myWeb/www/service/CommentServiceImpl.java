package com.myWeb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myWeb.www.domain.commentVO;
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

	@Override
	public List<commentVO> getList(int bno) {
		return cdao.getList(bno);
	}

	@Override
	public int removeComment(int cno) {
		return cdao.removeComment(cno);
	}

}
