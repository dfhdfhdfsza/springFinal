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
	<h1>Member List</h1>
	<table border="1" style="text-align: center" class="table">
		<thead>
			<tr>
				<th>이메일</th>
				<th>비밀번호</th>
				<th>닉네임</th>
				<th>가입일</th>
				<th>마지막으로 로그인한 날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="mvo">
				<tr>
					<td>${mvo.email}</td>
					<td>${mvo.pwd}</td>
					<td>${mvo.nickName}</td>
					<td>${mvo.regAt}</td>
					<td>${mvo.lastLogin}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>