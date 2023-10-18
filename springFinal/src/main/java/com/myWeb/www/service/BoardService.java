package com.myWeb.www.service;

import java.util.List;

import com.myWeb.www.domain.boardVO;

public interface BoardService 
{

	int register(boardVO bvo);

	List<boardVO> getList();

	boardVO getDetail(int bno);

	int postModify(boardVO bvo);

	int getRemove(int bno);

	void readCountUp(int bno);


}