<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h2 class="text-center mt-5">Here's Your Omikuji !</h2>
<div class="w-25 border bg-success m-auto mt-5 p-3">In <c:out value="${number}"/> years,
you will live in <c:out value="${city}"/>with <c:out value="${name}"/>as your roommate, 
<c:out value="${hobby}"/>for a living.The next time you see a 
 <c:out value="${living}"/>,
 you will have good luck.Also, <c:out value="${message}"/>. 

</div>
<div class="w-25 m-auto mt-5">
<a href="/omikuji" class="m-auto btn btn-primary">Go Back</a>
</div>

</body>
</html>