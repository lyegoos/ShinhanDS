<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="regist.do" method="post" enctype="multipart/form-data">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="password"><br>
이름 : <input type="text" name="name"><br>
취미 : <input type="checkbox" name="hobbyname" value="게임">게임
<input type="checkbox" name="hobbyname" value="영화">영화
<input type="checkbox" name="hobbyname" value="독서">독서
<input type="checkbox" name="hobbyname" value="낚시">낚시<br>
첨부파일 : <input type="file" name="filename"><br>
<input type="submit" value="등록">
</form>
</body>
</html>