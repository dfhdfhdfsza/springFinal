package com.myWeb.www.service;

import java.util.List;

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

	@Override
	public boolean updateLastLogin(String authEmail) {
		return mdao.updateLastLogin(authEmail)>0 ? true:false;
	}

	@Override
	public memberVO getDetail(String email) {
		return mdao.getDetail(email);
	}

	@Override
	public List<memberVO> getList() {
		return mdao.getList();
	}

	@Override
	public int modify(memberVO mvo) {
		return mdao.memberModify(mvo);
		
	}

}
