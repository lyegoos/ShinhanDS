<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>
총 학생 수 ${total }
<form method="get">
<select name="sgrade"> <!-- 검색에 관련된 부분 grade로 이름을 주면 VO에 grade를 추가하면 헷갈린다. -->
	<option value="">전체</option>	<!-- 전체는 검색을 안하면 됨 그래서 sgrade에 값이 없음 -->
	<option value="1">1학년</option>
	<option value="2">2학년</option>
	<option value="3">3학년</option>
	<option value="4">4학년</option>
</select>

<select name="searchType">	<!-- select에 이름을 줘야 내가 전송할 값을 searchType이라는 이름으로 보내줄 수 있다. -->
	<option value="all">전체(id와 name으로 검색)</option>
	<option value="name"<c:if test="${param.searchType=='name' }">selected</c:if>>이름으로 검색</option>
	<option value="id" <c:if test="${param.searchType=='id' }">selected</c:if>>아이디로 검색</option>
</select>
<input type="text" name="searchWord" value="${param.searchWord }">
<input type="submit" value="검색">

</form>

<c:forEach var="vo" items="${list}">
${vo.studno } ${vo.id } ${vo.name } ${vo.telephone }<br>
</c:forEach>
</body>
</html>