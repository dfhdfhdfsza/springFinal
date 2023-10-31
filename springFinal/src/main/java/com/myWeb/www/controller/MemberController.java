package com.myWeb.www.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myWeb.www.security.memberVO;
import com.myWeb.www.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/member/**")
@Controller
public class MemberController 
{
	@Inject
	private MemberService msv;
	
	@Inject
	private BCryptPasswordEncoder bcEncoder;
	
	@GetMapping("/register")
	public void register(){}
	
	@PostMapping("/register")
	public String register(memberVO mvo)
	{
		mvo.setPwd(bcEncoder.encode(mvo.getPwd())); //비밀번호를 암호화해서 다시 세팅
		int isOk=msv.register(mvo);
		return "index";
	}
	
	@GetMapping("/login")
	public void login(){}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,RedirectAttributes re)
	{
		//로그인이 실패시 다시 로그인 페이지로 돌아와 오류 메시지 전송
		//다시 로그인 유도
		re.addAttribute("email",request.getAttribute("email"));
		re.addAttribute("errMsg", request.getAttribute("errMsg"));
		
		return "redirect:/member/login";
	}
	@GetMapping("/detail")
	public void detail(String email,Model m)
	{
		memberVO mvo=msv.getDetail(email);
		
		m.addAttribute("mvo", mvo);
		 
	}
	@GetMapping("/list")
	public void list(Model m)
	{
		List<memberVO>list=msv.getList();
		m.addAttribute("list", list);
	}
	@GetMapping("/modify")
	public void modify(Model m,String email)
	{
		memberVO mvo=msv.getDetail(email);
		m.addAttribute("mvo", mvo);
	}
	@PostMapping("/modify")
	public String modify(memberVO mvo)
	{
		mvo.setPwd(bcEncoder.encode(mvo.getPwd()));
		int isOk=msv.modify(mvo);
		log.info((isOk>0)? "멤버수정 성공!":"멤버수정 실패!");
		return "index";
	}

}
