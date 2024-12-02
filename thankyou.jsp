<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<div class="container d-flex justify-content-center">


<h1 class="text-success">Thank you for ur Feedback</h1>

</div>


<div class="container d-flex justify-content-center mt-3">

<div class="row">
<a href="home.jsp" class="btn btn-primary">New Feedback</a>


</div>

</div>
<div class="container d-flex justify-content-center mt-3">

<div class="row">

<c:forEach items="${mydata}" var="b">
<div class="col"> if you want to change ur feedback  <a href="/Feedback_Hibernate/edit?id=${b.getId()}">Edit</a>/ <a href="/Feedback_Hibernate/delete?id=${b.getId()}"> Delete</a>  </div>
</c:forEach>

</div>

</div>


<div class="container  d-flex justify-content-center mt-3">

<div class="row">

<div class="col">
<table  class="table table-bordered">

<theader>
<tr>

<th class="pe-5">Name </th> <th class="pe-5">Email </th>  <th class="pe-5">Message</th>  </tr>
</theader>



<tbody>

<c:if test="${mydata!=null}">

<c:forEach items="${mydata}" var="b">


<tr>

<td>${b.getName()}</td>

<td>${b.getEmail()}</td>

<td>${b.getMessage()}</td>
</tr>


</c:forEach>

</c:if>

</tbody>

</table>

</div>
</div>



</div>
</body>
</html>