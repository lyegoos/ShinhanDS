<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 목록</h1>
<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>첨부파일</th>
	</tr>
<c:forEach items="${selectallList }" var="vo">
	<tr>
		<td>${vo.no }</td>
		<td>${vo.id }</td>
		<td>${vo.name }</td>
		<td>
			<c:if test="${!empty vo.filename_org}">
				<a href="<c:url value='/download.do?filename_real=${vo.filename_real}&filename_org=${URLEncoder.encode(vo.filename_org) }'/>">${vo.filename_org }</a>
			</c:if>
		</td>
	</tr>
	
</c:forEach>
</table>
<c:if test="${!empty loginSess }">  <!-- 로그인이 안 되어있으면 안 보이게 함 -->
<input type="button" value="등록" onclick="location.href='regist.do';">
</c:if>
</body>
</html>