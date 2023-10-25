<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#tb {
	background-color: #000; /* 까만색(0,0,0) */
	opacity: 0.7; /* 80% 불투명도 */
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	<table class="table table-hover">
		<tr>
			<th>bno</th>
			<td>${bvo.bno}</td>
		</tr>
		<tr>
			<th>title</th>
			<td>${bvo.title}</td>
		</tr>
		<tr>
			<th>content</th>
			<td>${bvo.content}</td>
		</tr>
		<tr>
			<th>writer</th>
			<td>${bvo.writer}</td>
		</tr>
		<tr>
			<th>registerDate</th>
			<td>${bvo.regAt}</td>
		</tr>
		<tr>
			<th>ModifyDate</th>
			<td>${bvo.modAt}</td>
		</tr>
		<tr>
			<th>read_count</th>
			<td>${bvo.readCount }</td>
		</tr>
		<tr>
			<th>cmtQty</th>
			<td>${bvo.cmtQty }</td>
		</tr>
		<tr>
			<th>hasFile</th>
			<td>${bvo.hasFile }</td>
		</tr>
	</table>
	
	<ul>
		<c:forEach items="${bdto.flist}" var="fvo">
				<li>
					<img src="/upload/${fn:replace(fvo.saveDir,'\\','/')}/${fvo.uuid}_th_${fvo.fileName}">
					<span class="badge bg-secondary rounded-pill">${fvo.fileSize}Byte</span>
				</li>
		</c:forEach>
	</ul>


	<a href="/board/modify?bno=${bdto.bvo.bno}">
		<button type="button">수정</button>
	</a>
	<a href="/board/remove?bno=${bdto.bvo.bno}">
		<button type="button">삭제</button>
	</a>
	<br>
	<br>
	<!-- comment 라인 -->
	<div>
		<!-- 댓글 등록 라인 -->
		<div class="input-group mb-3">
			<span class="input-group-text" id="cmtWriter">Writer</span> <input
				type="text" class="form-control" placeholder="Comment Content"
				id="cmtText">
			<button class="btn btn-primary" type="button" id="cmtPostBtn">POST</button>
		</div>
		<!-- 댓글 표시 라인 -->
		<table class="table table-bordered" id="tb" style="text-align: center">
			<thead>
				<tr>
					<th scope="col" style="width: 5%">CNO</th>
					<th scope="col" style="width: 10%">Writer</th>
					<th scope="col">content</th>
					<th scope="col" style="width: 10%">ModAt</th>
					<th scope="col" style="width: 5%">Mod</th>
					<th scope="col" style="width: 5%">Del</th>
				</tr>
			</thead>
			<tbody class="table-group-divider" id="cmtArea">
			</tbody>
		</table>
	</div>
	<!-- 댓글 페이징 라인 -->
	<div>
		<div>
			<button type="button" id="moreBtn" data-page="1"
				class="btn btn-primary" style="visibility: hidden">MORE+</button>
		</div>
	</div>

	<!-- 모달 창 -->
	<div class="modal" id="myModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Writer</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="input-group mb-3">
						<input type="text" class="form-control"
							placeholder="Comment Content" id="cmtTextMod">
						<button class="btn btn-primary" type="button" id="cmtModBtn">POST</button>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		let bnoVal = `<c:out value="${bvo.bno}"/>`;
		console.log(bnoVal);
	</script>
	<script type="text/javascript" src="/resources/boardComment.js"></script>

	<script type="text/javascript">
		getCommentList(bnoVal);
	</script>
</body>
</html>