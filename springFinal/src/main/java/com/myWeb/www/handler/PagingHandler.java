package com.myWeb.www.handler;

import java.util.List;

import com.myWeb.www.domain.commentVO;
import com.myWeb.www.domain.pagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class PagingHandler 
{
	
	private int startPage;	//화면에 보여지는 시작 페이지네이션 번호
	private int endPage;	//화면에 보여지는 끝 페이지네이션 번호
	private int realEndPage;
	private boolean prev,next; //이전,다음의 존재여부
	
	private int totalCount;
	private pagingVO pgvo;
	
	private List<commentVO> cmtList;
	
	//현재 페이지 값 가져오는 용도/ totalcount DB에서 조회 매개변수로 입력받기
	public PagingHandler(pagingVO pgvo,int totalcount)
	{
		//pgvo.qty : 한 페이지에 보이는 게시글의 수 10개
		this.pgvo=pgvo;
		this.totalCount=totalcount;
		
		// 1~10 / 11~20 /21~30 ...
		//1페이지부터 10페이지까지 어떤페이지가 선택되도 EndPage는 10
		//1 2 3 4 ... 10 /10 나머지를 올려서(ceil) 1로 만든 후 *10
		//화면에 표현되어야하는 페이지 갯수(1 2 3 4 5 6 7 8 9 10)
		this.endPage=(int)Math.ceil(pgvo.getPageNo()/(double)pgvo.getQty())*pgvo.getQty() ;
		this.startPage=endPage-9;
		
		//전체 글수에서 / 한페이지에 표시되는 게시글 수 => 올림
		this.realEndPage=(int)Math.ceil(totalcount/(double)pgvo.getQty());
		if(realEndPage<endPage)
			this.endPage=realEndPage;
		
		this.prev=this.startPage>1;
		this.next=this.endPage<realEndPage;
		
	}
	public PagingHandler(pagingVO pgvo,int totalCount,List<commentVO>cmtList)
	{
		this(pgvo,totalCount);
		this.cmtList=cmtList;
	}

}
