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
	<form action="/member/login">
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
		<button type="submit">로그인</button>
	</form>
</body>
</html>