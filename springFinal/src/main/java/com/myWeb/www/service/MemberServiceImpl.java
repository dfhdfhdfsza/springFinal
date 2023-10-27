package com.myWeb.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myWeb.www.repository.MemberDAO;
import com.myWeb.www.security.memberVO;

@Service
public class MemberServiceImpl implements MemberService
{
	@Inject
	private MemberDAO mdao;

	@Transactional
	@Override
	public int register(memberVO mvo) {
		mdao.register(mvo);
		
		return mdao.insertAuthInit(mvo.getEmail());
	}

}
