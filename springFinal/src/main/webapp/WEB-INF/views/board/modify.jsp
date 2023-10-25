<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>
	<form action="/board/modify" method="post" enctype="multipart/form-data">
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
		<c:forEach items="${flist}" var="fvo">
				<li>
					<img src="/upload/${fn:replace(fvo.saveDir,'\\','/')}/${fvo.uuid}_th_${fvo.fileName}">
					<span class="badge bg-secondary rounded-pill">${fvo.fileSize}Byte</span>
					<button type="button" id="fileMod" data-uuid="${fvo.uuid}">X</button>
				</li>
		</c:forEach>
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
	<script type="text/javascript" src="/resources/boardModify.js"></script>
	
</body>
</html>