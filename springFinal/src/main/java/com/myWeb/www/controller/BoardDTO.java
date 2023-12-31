package com.myWeb.www.controller;

import java.util.List;

import com.myWeb.www.domain.boardVO;
import com.myWeb.www.domain.fileVO;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO 
{
	private boardVO bvo;
	private List<fileVO> flist;
	
}
