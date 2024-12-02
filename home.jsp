<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback Form</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<header class="bg-dark text-white">

<div class="container d-flex justify-content-center">

<div class="row">

<div class="col-12">

<h1>Feedback form</h1> 
                    </div>

</div>

</div>

</header>




<c:if test="${data==null}">

<form action="add" method="post"> </c:if>

<c:if test="${data!=null }">
<form action ="update" method="post">

</c:if>


<div class= "container mt-4  mb-3 d-flex justify-content-center">


<div class="row">

<div class="col-12">
  <label for="exampleFormControlInput1" class="form-label">Name</label>
  
  <input type="text" class="form-control"  value="${data.getName()}"  required name="txtname"> </div>

<input type="hidden" value="${data.getId()}" name="id">

<div class="col-12">
  <label for="exampleFormControlInput1" class="form-label">Email</label>
  
  <input type="email" class="form-control" value="${data.getEmail()}"    name="txtemail" required placeholder="name@example.com"> </div>



<div class=" col-12 mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Message</label>
  <textarea class="form-control" name="txtmessage" rows="3"  required>${data.getMessage()}</textarea>
</div>


<div class=" col-12 mb-3">
  <button type="submit" class="btn btn-primary">Submit</button> </div>

</div>



</div>

</form>



<c:if test="${message!=null}">

<script type="text/javascript">


function f1(){


alert("${message}");



}

f1();
</script>




</c:if>





















</body>
</html>