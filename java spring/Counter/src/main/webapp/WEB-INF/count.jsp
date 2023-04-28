<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Counter</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h1>Welcome !</h1>
<h3>You have visited <a href="">http://localhost:8080/</a></h3>
<h2><c:out value="${count}"/> times.</h2> 

</body>
</html>