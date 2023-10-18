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
	<form action="/board/modify" method="post">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">bno</label>
			<input type="text" class="form-control" id="exampleFormControlInput1"
				value="${bvo.bno}" name="bno" readonly="readonly">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Writer</label>
			<input type="text" class="form-control" id="exampleFormControlInput1"
				value="${bvo.writer}" name="writer" readonly="readonly">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">title</label>
			<input type="text" class="form-control" id="exampleFormControlInput1"
				value="${bvo.title}" name="title">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">
				Exampletextarea </label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="3" name="content"></textarea>
		</div>
		<button type="submit" class="btn btn-dark">등록</button>
	</form>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>