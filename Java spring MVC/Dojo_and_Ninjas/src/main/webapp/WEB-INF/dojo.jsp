<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Dojo</title>
</head>
<body>
<h2>New Dojo :</h2>
<form:form action="/dojo" method="POST" modelAttribute="dojo">
  <p>
    <form:label path="name">Name :</form:label>
    <form:errors path="name"/>
    <form:input path="name"/>
  </p>
  <input type="submit" value="Create"/>
</form:form>
</body>
</html>