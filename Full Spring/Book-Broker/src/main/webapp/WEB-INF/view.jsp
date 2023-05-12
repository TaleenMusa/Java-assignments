<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Read</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-content-between align-items-center">
			<div class="col-8">
				<h1>${book1.title}</h1>
			</div>
			<div class="col-md-4 d-flex flex-column justify-content-center align-items-end">
			                <p><a href="/books" class="btn btn-outline-secondary">Go Back</a></p>
                <p><a href="/books/new" class="btn btn-outline-primary">Add a book to my shelf!</a></p>
            </div>
		</div>
		<div class="row mt-4">
			<div class="col-8">
				<h2>${book1.user.userName} read ${book1.title} by ${book1.author}</h2>
				<h3>Here are ${book1.user.userName}'s thoughts:</h3>
				<hr>
				<p>${book1.myThoughts} ${thisUser.userName}</p>
			</div>
			<div class="col-4 text-end">
				<p class="mb-0">${thisUser.userName}</p>
			</div>
		</div>
	</div>
</body>
</html>
