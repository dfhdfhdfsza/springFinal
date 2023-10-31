package com.myWeb.www.repository;

import java.util.List;

import com.myWeb.www.security.authVO;
import com.myWeb.www.security.memberVO;

public interface MemberDAO {

	int register(memberVO mvo);

	int insertAuthInit(String email);

	memberVO selectEmail(String username);

	List<authVO> selectAuths(String username);

	int updateLastLogin(String authEmail);

	memberVO getDetail(String email);

	List<memberVO> getList();

	int memberModify(memberVO mvo);

}
