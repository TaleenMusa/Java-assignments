<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->

</head>
<body>

<h1 class="text-center">From</h1>
<form action="/omikuji/send" method="POST" class="w-50 d-flex flex-column m-auto border p-5">
 
	<label>Pick any number from 5 to 25</label>
    	<input type="number" name='number'>
	<label>Enter the name of any city:</label>
    	<input type='text' name='city'>
    <label>Enter the name of any real person:</label>
    	<input type='text' name='name'>
    <label>Enter professional endeavor or hobby:</label>
    	<input type='text' name='hobby'>
    <label>Enter any type of living thing</label>
    	<input type='text' name='living'>
    <label>Say something nice to someone</label>
    	<textarea name='message'></textarea>
    	
    	<p>Send and show a friend</p>
    	<input type='submit' value='send' class="btn btn-primary">



</form>
</body>
</html>