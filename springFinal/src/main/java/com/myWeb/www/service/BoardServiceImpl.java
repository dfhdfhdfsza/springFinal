package com.myWeb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myWeb.www.domain.boardVO;
import com.myWeb.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService
{
	@Inject
	private BoardDAO bdao;

	@Override
	public int register(boardVO bvo) {
		
		return bdao.register(bvo);
	}

	@Override
	public List<boardVO> getList() {
		
		return bdao.getList();
	}

	@Override
	public boardVO getDetail(int bno) {
		
		return bdao.getDetail(bno);
	}

	@Override
	public int postModify(boardVO bvo) {
		
		return bdao.postModify(bvo);
	}

	@Override
	public int getRemove(int bno) {
		
		return bdao.getRemove(bno);
	}

	@Override
	public void readCountUp(int bno) {
		bdao.readCountUp(bno);
		
	}


}