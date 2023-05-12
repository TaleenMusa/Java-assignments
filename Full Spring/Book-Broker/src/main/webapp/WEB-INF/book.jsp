<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Read Share</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
    <div class="container-fluid">
        <div class="row py-3 justify-content-between">
            <div class="col-md-8">
                <h3>Hello ${thisUser.userName}, Welcome to..  </h3>
                <h3>The Book Broker!</h3>
            </div>
            <div class="col-md-4 d-flex flex-column justify-content-center align-items-end">
                <p><a href="/logout" class="btn btn-outline-secondary">Logout</a></p>
                <p><a href="/books/new" class="btn btn-outline-primary">Add a book to my shelf!</a></p>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
            <h5 class="lead">Available Books to Borrow</h5>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author Name</th>
                    <th scope="col">Owner</th>
                     <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allbooks}" var="book">
                    <tr>
                        <td>${book.id}</td>
                        <td><a href="/books/${book.id}">${book.title}</a></td>
                        <td>${book.author}</td>
                        <td>${book.user.userName}</td>
                        <c:if test="${book.user.id == user_id}">
                        	<td><a href="/edit/{id}">edit</a> | <a href="/delete/{id}">delete</a></td>
                    </c:if>
                            <c:if test="${book.user.id != user_id}">
                        	<td><a href="/borrow/{id}">borrow</a></td>
                    </c:if>
                    </tr>
                </c:forEach> 
            </tbody>
        </table>
        
        <table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Owner</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${user1.borrowedBooks}" var="book">
    <tr>
      <th scope="row">${book.id}</th>
      <td><a href="/books/${book.id}">${book.title}</a></td>
      <td>${book.author}</td>
      <td>${book.user.userName}</td>
	  <td><a href="/return/${book.id}">return</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</body>
</html>
