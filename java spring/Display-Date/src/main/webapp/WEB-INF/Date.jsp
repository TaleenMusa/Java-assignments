<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=UTF-8">
<title>Date</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<h1><c:out value="${date}"></c:out></h1>
	<script type="text/javascript" src="/js/app.js"></script>
</body>
</html>