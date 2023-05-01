<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Game</title>
</head>
<body>
<h1>Your Gold: <c:out value="${gold}"/></h1>
<table>
	<tr>
		<td>
			<h3>Farm</h3>
			<p>(earns 10-20 gold)</p>
			<form action="" method="post"><input type="submit" name="farm" value="Find Gold"/></form>
		</td>
				<td>
			<h3>Cave</h3>
			<p>(earns 5-10 gold)</p>
			<form action="" method="post"><input type="submit" name="cave" value="Find Gold"/></form>
		</td>
				<td>
			<h3>House</h3>
			<p>(earns 2-5 gold)</p>
			<form action="" method="post"><input type="submit" name="house" value="Find Gold"/></form>
		</td>
				<td>
			<h3>Quest</h3>
			<p>(earns/takes 0-50 gold)</p>
			<form action="" method="post"><input type="submit" name="quest" value="Find Gold"/></form>
		</td>
	</tr>
</table>
<h3>Activities</h3>
<iframe src="/activities" >hello</iframe>
</body>
</html>