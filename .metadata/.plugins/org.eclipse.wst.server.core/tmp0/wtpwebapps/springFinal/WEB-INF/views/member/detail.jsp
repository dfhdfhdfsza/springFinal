<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="text-align: center" class="table">
		<thead>
			<tr>
				<th>email</th>
				<th>pwd</th>
				<th>닉네임</th>
				<th>가입일</th>
				<th>마지막 로그인한 날</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${principal.mvo.email }</td>
				<td>${principal.mvo.pwd }</td>
				<td>${principal.mvo.nickName }</td>
				<td>${principal.mvo.regAt }</td>
				<td>${principal.mvo.lastLogin }</td>
			</tr>
		</tbody>
	</table>
</body>
</html>