package com.myWeb.www.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myWeb.www.domain.boardVO;
import com.myWeb.www.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board/*")
@Slf4j
public class BoardController 
{
	//폴더명 : board / mapping : board
	//mapping => /board/register
	//목적지 => /board/register
	//목적지랑 mapping이랑 같으면 return값 생략가능 public void getRegister(){}
	@Inject
	private BoardService bsv;
	
	private int isOk;
	
	@GetMapping("/register")
	public void getRegister()
	{
		log.info("start!");
	}
	
	@PostMapping("/register")
	public String postRegister(boardVO bvo)
	{
		log.info("bvo:"+bvo);
		isOk=bsv.register(bvo);
		
		return "index";
	}
	
	@GetMapping("/list")
	public String getList(Model model)
	{
		log.info("getList check");
		List<boardVO> list = bsv.getList();
		model.addAttribute("list", list);
		return "/board/list";
		
	}
	@GetMapping("/detail")
	public String getDetail(Model model,@RequestParam("bno")int bno)
	{
		log.info("getDetail check");
		bsv.readCountUp(bno);
		boardVO bvo=bsv.getDetail(bno);
		model.addAttribute("bvo", bvo);
		return "/board/detail";
	}
	
	@GetMapping("/modify")
	public String getModify(Model model,@RequestParam("bno")int bno)
	{
		log.info("getModify check");
		boardVO bvo=bsv.getDetail(bno);
		log.info("bvo:"+bvo);
		model.addAttribute("bvo", bvo);
		return "/board/modify";
	}
	
	@PostMapping("/modify")
	public String postModify(boardVO bvo)
	{
		log.info("postModify check");
		isOk=bsv.postModify(bvo);
		return "redirect:/board/list";
	}
	@GetMapping("/remove")
	public String getRemove(@RequestParam("bno")int bno)
	{
		log.info("remove check");
		isOk=bsv.getRemove(bno);
		//board/list로 그냥 이동하면은 데이터가 없어서 아무것도 안뜨니까 redirect로 list를 거쳐서 이동한다.
		//가져되야할 값이있으면 매개변수에서 RedirectAttributes reAttr 을선언해주고 return에서 값을 달고 간다
		return "redirect:/board/list";
	}
	
	
	
	

}
