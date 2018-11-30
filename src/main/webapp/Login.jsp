<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">

<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.4.2/css/all.css' integrity='sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns' crossorigin='anonymous'>

  <link rel="stylesheet" href="registration.css">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <link rel="stylesheet" href="registration.css">
</head>

<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SBBI Bank</a>
    </div>
</nav>
  
<form action="login" method="post">
  <div class="container" align = "center">

    <h1 align="center">Login</h1>
   
    <hr>    
  <label for="User Id"><b>User Id * <span class="fa fa-user"></span> :</b></label><br>
    <input type="text"  autocomplete="off" placeholder="Enter your user id"  name="user_id" required><br>

    <label for="password"><b>Password * <span class="fa fa-key"></span> :</b></label><br>
    <input type="password" placeholder="Enter your password"  name="password" required><br>

    <input type="submit" class="registerbtn" value="Login">
  
  </form>
</div>
  <div class="container" align = "center">
    <p><i>First Time User?</i> <a href="Register.jsp"><b>Register</b></a></p>
<a href="#"><i>Forgot User Id?</i></a><br>
<a href="#"><i>Forgot password?</i></a><br>
  </div>
</form>


<!--   <form action="login" method="post">
            User ID<input type="text"  name="user_id"><br>
            Password<input type="text" name="password"><br>
            <input type="submit" value="Login">
        </form> -->

</body>
</html>
