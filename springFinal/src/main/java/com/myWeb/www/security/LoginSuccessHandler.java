package com.myWeb.www.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.myWeb.www.service.MemberService;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler 
{
	@Getter
	@Setter
	private String authEmail;
	@Getter
	@Setter
	private String authUrl;
	
	private RedirectStrategy rdstg=new DefaultRedirectStrategy(); // redirect로 데이터를 가져가는 역할
	private RequestCache reqCache = new HttpSessionRequestCache(); //실제 로그인 정보,경로 등을 저장
	
	@Inject
	private MemberService msv;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		setAuthEmail(authentication.getName());
		setAuthUrl("/board/list");
		
		boolean isOk=msv.updateLastLogin(getAuthEmail());
		
		//내부에서 로그인 세션 저장됨.
		HttpSession ses = request.getSession();
		log.info(">>loginSuccess ses>>"+ses.toString());
		
		//시큐리티에서 로그인 값이 없다면 null로 저장될 수 있음.
		if(!isOk||ses==null){
			return;			
		}
		else{
			//시큐리티에서 로그인을 시도하면 시도한 로그인 기록 남게됨.
			//이전 시도한 시큐리티의 로그인 인증 실패 기록 삭제
			ses.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);//인증 실패에대한 exception기록 삭제
		}
		SavedRequest saveReq = reqCache.getRequest(request, response);
		rdstg.sendRedirect(request, response, (saveReq!=null? saveReq.getRedirectUrl():getAuthUrl()));

	}

}
