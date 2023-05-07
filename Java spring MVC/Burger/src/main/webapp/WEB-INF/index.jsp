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
<title>Insert title here</title>
</head>
<body>
<h2>Burger Tracker</h2>
<table>
  <thead>
    <tr>
      <th>Burger Name</th>
      <th>Restaurant Name</th>
      <th>Rating (Out of 5)</th>
      <th>Action</th>
    </tr>
  </thead>
<tbody>
    <c:forEach items="${allBurgers}" var="burger">
        <tr>
            <td>${burger.burger_name}</td>
            <td>${burger.restaurant_name}</td>
            <td>${burger.rating}</td>
            <td><a href="/burger/${burger.id}/edit">edit</a></td>
            
        </tr>
    </c:forEach>
</tbody>
</table>

<h2>Add a Burger :</h2>
<form:form action="/burger" method="post" modelAttribute="burger">
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

</body>
</html>