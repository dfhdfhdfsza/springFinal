package com.myWeb.www.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//@configuration 없어도됨 
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return new Class[] {RootConfig.class,SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return new Class[] {ServletConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] {"/"};
	}
	@Override
	protected Filter[] getServletFilters() {
		//encoding filter 설정
		CharacterEncodingFilter encodingfilter =new CharacterEncodingFilter();
		encodingfilter.setEncoding("UTF-8");	//"UTF-8"타입만 받는다는 설정
		encodingfilter.setForceEncoding(true); // 기본적으로는 들어오는값만 필터링해주는데 ForceEncoding은 나갈때도 필터링해준다
		return new Filter[] {encodingfilter};
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		//그 외 기타 사용자 설정
		//사용자 지정 exception 설정을 할 것인지 처리
		registration.setInitParameter("throwExceptionIfNoHandlerFound","true");
		
		//파일 업로드 설정
		//경로,maxFileSize,maxReqSize,fileSizeThreshold
		String uploadLocation="D:\\_myweb\\_java\\fileUpload";
		int maxFileSize=1024*1024*20; //20mb
		int maxReqSize=maxFileSize*2;
		int fileSizeThreshold=maxFileSize;
		
		MultipartConfigElement multipartConfig = new MultipartConfigElement(uploadLocation, maxFileSize, maxReqSize, fileSizeThreshold);
		
		registration.setMultipartConfig(multipartConfig);
	}
	

}
