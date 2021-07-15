<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>list</title>

</head>
<body>
	<a href="/ch05/user/register">직원등록</a>
	
	<h4>직원목록</h4>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>직급</th>
			<th>부서</th>
			<th>입사일</th>
			<th>관리</th>
		</tr>
		
		<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.uid}</td>
			<td>${user.name}</td>
			<td>${user.hp}</td>
			<td>${user.pos}</td>
			<td>${user.dep}</td>
			<td>${user.rdate.substring(2,10)}</td>
			<td>
				<a href="#">수정</a>
				<a href="/ch05/user/delete?uid=${user.uid}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href="/ch05/user/list">User List</a>
	<a href="/ch05/user/register">User Register</a>
	<a href="/ch05/user/modify">User Modify</a>
	
	
</body>
</html>