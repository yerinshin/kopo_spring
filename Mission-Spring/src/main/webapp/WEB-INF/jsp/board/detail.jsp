<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" />
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('#goListBtn').click(function(){
			location.href = "${ pageContext.request.contextPath }/board"
		})
		
		$('#updateBtn').click(function(){
			boardNo = ${ board.no }
			location.href = "updateForm.jsp?no="+boardNo
		//  location.href = "updateForm.jsp?no=${ param.no }"
		})
		
		$('#deleteBtn').click(function(){
			boardNo = ${ board.no }
			location.href = "${ pageContext.request.contextPath }/board/delete/${board.no}"
		})
	})
</script>
<script>
$(document).ready(function(){
	
	listReply()
	
 	$('#insertReply').click(function(){
		let content=$('#content').val()
		let writer=$('#writer').val()
		let boardNo = ${ board.no } 
		
		
			
		let data = {boardNo : boardNo, content:content, writer:writer}
		
		console.log(content)
		console.log(writer)
		console.log(boardNo)
		
		$.ajax({
			type : 'post',
			url : '${ pageContext.request.contextPath }/reply',
			data : data,
			success : function() {
				alert('댓글이 등록되었습니다')	
				$('#content').val('')
				$('#writer').val('')
				listReply()
			}
		})
			
	}) 
	
	function listReply() {
		let boardNo = ${ board.no }
		let	url = '${ pageContext.request.contextPath }/reply/'+boardNo
		$.ajax({
			type : 'get',
			url  : url,
		
			success : function(replyList) {
				console.log(replyList)
				
				let json = JSON.parse(replyList)
				
				if(replyList.length > 0) {
					let html = ''					
					json.forEach(function(reply){
						let temp = $('#replyTemplate').text()
						temp = temp.replace(/\{writer\}/gi, reply.writer)
									.replace(/\{content\}/gi, reply.content)
									.replace(/\{regDate\}/gi, reply.regDate)
						html += temp;
					})
					
					$('#listReply').html(html)
				}
			}
			
		})
	}
})
</script>
<script id="replyTemplate" type="text/template">
	<div align="center">
		<table border="1" width="80%">

			<tr>
				<td width="15%">{writer}</td>
				<td>{content}</td>
				<td width="15%">{regDate}</td>
			</tr>
		
		</table>
	</div>
</script>
</head>
<body>
	<header>
	<%-- 	<jsp:include page="/jsp/WEB-INF/jsp/include/topMenu.jsp" /> --%>
	</header>
	<section>
		<div align="center">
		<hr>
		<h2>게시판 상세</h2>
		<hr>
		<br>
		<table border="1" width="80%">
		<tr>
			<th width="25%">번호</th>
			<td><c:out value="${ board.no }" /></td>
		</tr>
		<tr>
			<th width="25%">제목</th>
			<td><c:out value="${ board.title }" /></td>
		</tr>
		<tr>
			<th width="25%">작성자</th>
			<td>${ board.writer }</td>
		</tr>
		<tr>
			<th width="25%">내용</th>
			<td>${ board.content }</td>
		</tr>
		<tr>
			<th width="25%">조회수</th>
			<td>${ board.viewCnt }</td>
		</tr>
		<tr>
			<th width="25%">등록일</th>
			<td>${ board.regDate }</td>
		</tr>
		</table>
		<button id="updateBtn">수정</button>
		<button id="deleteBtn">삭제</button>
		<button id="goListBtn">목록</button>
	</div>
	
	
	<!-- 댓글 작성 -->
	<hr>
		댓글 : <textarea rows="5" cols="80" id="content"></textarea>
		작성자 : <input type="text" id="writer" />	<%-- 누구나 등록 가능한 댓글 --%>
		<button id="insertReply">댓글등록</button>
	<hr>
	
	<!-- 댓글 목록 -->
	<table border="1" width="80%">
			<tr>
				<th width="15%">작성자</th>
				<th ">내용</th>				
				<th width="15%">등록일</th>	
			</tr>
	</table>

	<div id="listReply"></div>
	
	</section>
	<footer>
		<%-- <%@ include file="/jsp/WEB-INF/jsp/include/bottom.jsp" %>	 --%>
	</footer>
</body>
</html>