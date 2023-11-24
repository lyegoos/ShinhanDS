<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
test ${msg } <br>
커맨드 객체 : ${memberVO.id } / ${memberVO.name } <br>
request : ${mvo.id } / ${mvo.name }<br>
session : ${svo.id } / ${svo.name }<br>
Model : ${requestScope.modelvo.id } / ${modelvo.name }<br>
</body>
</html>