package com.myWeb.www.controller;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
