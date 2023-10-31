<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	<h1>Member Detail</h1>
	<table class="table table-hover">
		<tr>
			<th>email</th>
			<td>${mvo.email }</td>
		</tr>
		<tr>
			<th>pwd</th>
			<td>${mvo.pwd }</td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td>${mvo.nickName }</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${mvo.regAt }</td>
		</tr>
		<tr>
			<th>마지막 로그인한 날</th>
			<td>${mvo.lastLogin}</td>
		</tr>
	</table>
	<a href="/member/modify?email=${mvo.email}"><button>md</button></a>
</body>
</html>