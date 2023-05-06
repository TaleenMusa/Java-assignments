<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Edit Burger </title>
</head>
<body>


<h2>Edit Burger :</h2>
<form:form action="/handle/${burger.id}" method="post" modelAttribute="burger">
  <input type="hidden" name="_method" value="put">
  <p>
    <form:label path="burger_name">Burger name:</form:label>
    <form:errors path="burger_name"/>
    <form:input path="burger_name"/>
  </p>
  <p>
    <form:label path="restaurant_name">Restaurant name:</form:label>
    <form:errors path="restaurant_name"/>
    <form:input path="restaurant_name"/>
  </p>
  <p>
    <form:label path="rating">Rating:</form:label>
    <form:errors path="rating"/>
    <form:input path="rating" type="number" min="1" max="5"/>
  </p>
  <p>
    <form:label path="notes">Notes:</form:label>
    <form:errors path="notes"/>
    <form:textarea path="notes"/>
  </p>
  <input type="submit" value="Submit"/>
</form:form>
<a href="/burger"><button>Go Back</button></a>

</body>
</html>