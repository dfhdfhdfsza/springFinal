<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	<sec:authentication property="principal.mvo.email" var="authEmail"/>
	<form action="/board/register" method="post" enctype="multipart/form-data">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Title</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
				placeholder="title" name="title">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Writer</label>
			<input type="text" class="form-control"
				id="exampleFormControlInput1" value="${authEmail}" readonly="readonly"
				name="writer">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">
				Exampletextarea </label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="3" name="content"></textarea>
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">File</label>
			<input type="file" class="form-control" id="files" name="files" style="display: none;" multiple="multiple">
			<!-- input button tirgger 용도의 button -->
			<button type="button" id=trigger class="btn btn-primary">FileUpload</button>
		</div>
		<!-- 첨부파일 표시될 영역 -->
		<div class="mb-3" id="fileZone">
			
		</div>
		<button type="submit" class="btn btn-dark" id="regBtn">등록</button>
	</form>
	<script type="text/javascript" src="/resources/boardRegister.js"></script>

</body>
</html>