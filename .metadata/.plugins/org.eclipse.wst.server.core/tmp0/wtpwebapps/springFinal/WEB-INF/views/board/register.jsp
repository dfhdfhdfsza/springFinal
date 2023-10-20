<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	
	<form action="/board/register" method="post">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Title</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
				placeholder="title" name="title">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Writer</label>
			<input type="text" class="form-control"
				id="exampleFormControlInput1" placeholder="writer"
				name="writer">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">
				Exampletextarea </label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="3" name="content"></textarea>
		</div>
		<button type="submit" class="btn btn-dark">등록</button>
	</form>


</body>
</html>