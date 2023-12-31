package com.myWeb.www.repository;

import java.util.List;

import com.myWeb.www.controller.BoardDTO;
import com.myWeb.www.domain.boardVO;
import com.myWeb.www.domain.pagingVO;

public interface BoardDAO 
{

	int register(boardVO bvo);

	List<boardVO> getList();

	boardVO getDetail(int bno);

	int postModify(boardVO bvo);

	int getRemove(int bno);

	void readCountUp(int bno);

	List<boardVO> getPageList(pagingVO pgvo);

	int getTotalCount(pagingVO pgvo);

	int insert(BoardDTO boardDTO);

	long selectOneBno();


}
