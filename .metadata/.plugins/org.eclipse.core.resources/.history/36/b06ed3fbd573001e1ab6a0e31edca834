package com.myWeb.www.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myWeb.www.domain.commentVO;
import com.myWeb.www.domain.pagingVO;
import com.myWeb.www.handler.PagingHandler;

public interface CommentDAO {

	int postComment(commentVO cvo);

	List<commentVO> getList(int bno);

	int removeComment(int cno);

	int modifyComment(commentVO cvo);

	PagingHandler getList(int bno, pagingVO pgvo);

	int selectOneBnoTotalCount(int bno);

	//매개변수를 두개이상 보낼때는 반드시 @param을 써줘야된다
	List<commentVO> selectListPaging(@Param("bno")long bno,@Param("pgvo") pagingVO pgvo);

	

}
