package com.myWeb.www.repository;

import com.myWeb.www.security.memberVO;

public interface MemberDAO {

	int register(memberVO mvo);

	int insertAuthInit(String email);

}
