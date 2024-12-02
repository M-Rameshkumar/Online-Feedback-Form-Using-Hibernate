<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Google Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<header class="bg-dark text-white">
  <div class="container">
    <div class="row">
      <h1 class="text-center">Login Page</h1>
    </div>
  </div>
</header>

<div class="container d-flex justify-content-center align-items-center" style="height: 80vh;">
  <div class="col-4">
    <form action="login" method="post" >
      <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control" id="username" name="txtname">
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="txtpassword">
      </div>
      <button type="submit" class="btn btn-primary w-100">Login</button> <br>
      <a  href="register.jsp" class="text-decoration-none">Don't have an account? Sign Up</a>
    </form>
  </div>
</div>

        



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
