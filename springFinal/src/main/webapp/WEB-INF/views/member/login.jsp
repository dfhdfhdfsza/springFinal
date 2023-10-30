<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	<h1>로그인</h1>
	<form action="/member/login" method="post">
		<div class="container">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">email</label>
				<input type="text" class="form-control" name="email" id="email">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">pwd</label>
				<input type="text" class="form-control" name="pwd" id="pwd">
			</div>
		</div>
		<c:if test="${not empty param.errMsg}">
			<div class="text-danger mb-3">
				<c:choose>
					<c:when test="${param.errMsg eq 'Bad credentials'}">
						<c:set var="errText" value="이메일 &비밀번호가 일치하지 않습니다."/>
					</c:when>
					<c:otherwise>
						<c:set var="errText" value="관리자에게 문의해주세요"/>
					</c:otherwise>
				</c:choose>
				${errText}
			</div>
		</c:if>
		<button type="submit">로그인</button>
	</form>
</body>
</html>