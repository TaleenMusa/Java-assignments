<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Fruit Store</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<h1>Fruit List</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${fruits}" var="item">
	    <tr>
	        <td>${item.name}</td>
	        <td>${item.price}</td>
	    </tr>
	</c:forEach>
		</tbody>
	</table>
</body>
</html>