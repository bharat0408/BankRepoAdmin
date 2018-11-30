<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <form action="open" method="post">
            <div class="container">
                <h1>Open a savings account</h1>
                <p>Personal details</p>
                <hr>
                    <label for="Title"><b>Title</b></label>
                    <input type="text" placeholder="Enter title" name="Title" required>
                <label for="First Name"><b>First Name</b></label>
                <input type="text" placeholder="Enter First Name" name="first_name" required><br>
                <label for="Middle Name"><b>Middle Name</b></label>
                <input type="text" placeholder="Enter Middle Name" name="middle_name" required><br>
                <label for="Last Name"><b>Last Name</b></label>
                <input type="text" placeholder="Enter Last Name" name="last_name" required><br>
                <label for="Father's Name"><b>Father's Name</b></label>
                <input type="text" placeholder="Enter Father's Name" name="father_name" required><br>
                <label for="Email Id"><b>Email Id</b></label>
                <input type="text" placeholder="Enter email Id" name="email_id" required> <br>
                <label for="Mobile No"><b>Mobile Number</b></label>
                <input type="number" placeholder="Enter Mobile Number" name="mobile_number" required><br><br>
                <label for="Aadhar Card No"><b>Aadhar Card No</b></label>
                <input type="number" placeholder="Enter Aadhar No" name="aadhar_card" required><br><br>
                <label for="Date Of Birth"><b>Date Of Birth</b></label>
                <input type="date"  name="date_of_birth" ><br>
                <label for="Annual_Income"><b>Annual Income</b></label>
                <input type="number"  name="annual_income" required><br><br>
                <p>Address</p>
                <label for="Address Line 1"><b>Address Line 1</b></label>
                <input type="text"  name="address_line_1" required><br><br>
                <label for="Address Line 2"><b>Address Line 1</b></label>
                <input type="text"  name="address_line_2" required><br><br>
                <label for="City"><b>City</b></label>
                <input type="text"  name="city" required><br><br>
                <label for="State"><b>State</b></label>
                <select name="state">
                    <option value="select">select</option>
                    <option value="Andhra Pradesh">Andhra Pradesh</option>
                    <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                    <option value="Assam">Assam</option>
                    <option value="Bihar">Bihar</option>
                    <option value="Chattisgarh">Chattisgarh</option>
                    <option value="Goa">Goa</option>
                    <option value="Gujrat">Gujrat</option>
                    <option value="Haryana">Haryana</option>
                    <option value="Himachal Pradesh">Himachal Pradesh</option>
                    <option value="Jammu & Kashmir">Jammu & Kashmir</option>
                    <option value="Jharkhand">Jharkhand</option>
                    <option value="Karnatka">Karnatka</option>
                    <option value="Kerala">Kerala</option>
                    <option value="Madhya Pradesh">Madhya Pradesh</option>
                    <option value="Maharashtra">Maharashtra</option>
                    <option value="Manipur">Manipur</option>
                    <option value="Meghalaya">Meghalaya</option>
                    <option value="Mizoram">Mizoram</option>
                    <option value="Nagaland">Nagaland</option>
                    <option value="Orissa">Orissa</option>
                    <option value="Punjab">Punjab</option>
                    <option value="Rajasthan">Rajasthan</option>
                    <option value="Sikkim">Sikkim</option>
                    <option value="Tamil Nadu">Tamil Nadu</option>
                    <option value="Telangana">Telangana</option>
                    <option value="Tripura">Tripura</option>
                    <option value="Uttarakhand">Uttarakhand</option>
                    <option value="Uttar Pradesh">Uttar Pradesh</option>
                    <option value="West Bengal">West Bengal</option>
                    <br> <br>
                </select>
                <br><br>
                <label for="Pincode"><b>Pincode</b></label>
                <input type="number"  name="pin_code" required><br><br>
                
                <input type="checkbox" name="Net Banking" value="Net banking">Opt for Net Banking<br>
                <input type="radio" name="Agree" value="Agree">I agree<br>
                <hr>
                <p>By creating an account you agree to our terms and conditions.</p>
                <input type="submit" class="registerbtn" value="Register" >
            </div>
        </form>
    </body>
</html>
 -->



<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">

<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.4.2/css/all.css' integrity='sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns' crossorigin='anonymous'>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="registration.css">

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SBBI Bank</a>
    </div>
</nav>
  

<form action="open" method="post">
  <div class="container" align="center" >

    <h1 align="center">Open a savings account</h1>
    <h2>Personal details</h2>
    <hr>

    <label for="Title"><b>Title* <span class="fas fa-hand-point-down"> :</span></b></label><br>
    <select name="Title">
        <option value="select">Select</option>
        <option value="Mr.">Mr.</option>
	<option value="Ms.">Ms.</option>
	 <option value="Mrs.">Mrs.</option>
	</select><br>

  <label for="First Name"><b>First Name* <span class="fa fa-user"></span> :</b></label><br>
    <input type="text" placeholder="Enter First Name" name="first_name" required><br>

    <label for="Middle Name"><b>Middle Name <span class="fa fa-user"></span> :</b></label><br>
    <input type="text" placeholder="Enter Middle Name" name="middle_name"><br>

<label for="Last Name"><b>Last Name* <span class="fa fa-user"></span> :</b></label><br>
    <input type="text" placeholder="Enter Last Name" name="last_name" required><br>

<label for="Father's Name"><b>Father's Name* <span class="fa fa-user"></span> :</span></b></label><br>
    <input type="text" placeholder="Enter Father's Name" name="father_name" required><br>

<label for="Email Id"><b>Email Id <span class = "fa fa-envelope"></span></b></label><br>
<input type="email" id="Enter Email Id" title="e.g. @gmail.com,@yahoo.com etc." name="email_id" pattern="[a-zA-Z]{1}[a-zA-Z0-9._%+-]+@[a-z.-]+\.[a-z]{2,3}$"></br>

 <label for="Mobile No"><b>Mobile Number* <span class="fa fa-mobile"></span>:</b></label><br>
<input type="tel" name="mobile_number" pattern="[6-9]{1}[0-9]{9}" title="Please enter a valid mobile number" required>
</br>

<label for="Aadhar Card No"><b>Aadhar Card No* <span class="fa fa-address-card"></span>:</b></label><br>
    <input type="text" placeholder="Enter Aadhar No" name="aadhar_card" pattern = "[2-9]{1}[0-9]{11}" title="Please enter a 12 digit aadhar number" required><br> 

<label for="Date Of Birth"><b>Date Of Birth* <span class="fa fa-calendar"></span>:</b></label><br>
    <input type="date"  name="date_of_birth" value="1990-01-01" required><br>
    
    <label for="Annual_Income"><b>Annual Income* :</b></label><br>
    <input type="text"  name="annual_income" pattern="[1-9]{4-9}" ><br>

 <p><b>Address <span class="fa fa-address-card"></span>:</b></p><br>

 <label for="Address Line 1"><b>Address Line 1* :</b></label><br>
    <input type="text"  name="address_line_1" required><br>
    
<label for="Address Line 2"><b>Address Line 2* :</b></label><br>
    <input type="text"  name="address_line_2" required><br>
    
<label for="State"><b>State* :</b></label><br>
   <select name="state">
        <option value="State">Select</option>
        <option value="Andhra Pradesh">Andhra Pradesh</option>
        <option value="Arunachal Pradesh">Arunachal Pradesh</option>
        <option value="Assam">Assam</option>
        <option value="Bihar">Bihar</option>
        <option value="Chattisgarh">Chattisgarh</option>
        <option value="Goa">Goa</option>
        <option value="Gujrat">Gujrat</option>
        <option value="Haryana">Haryana</option>
 <option value="Himachal Pradesh">Himachal Pradesh</option>
        <option value="Jammu & Kashmir">Jammu & Kashmir</option>
        <option value="Jharkhand">Jharkhand</option>
        <option value="Karnatka">Karnatka</option>
<option value="Kerala">Kerala</option>
        <option value="Madhya Pradesh">Madhya Pradesh</option>
        <option value="Maharashtra">Maharashtra</option>
        <option value="Manipur">Manipur</option>
<option value="Meghalaya">Meghalaya</option>
        <option value="Mizoram">Mizoram</option>
        <option value="Nagaland">Nagaland</option>
        <option value="Orissa">Orissa</option>
<option value="Punjab">Punjab</option>
        <option value="Rajasthan">Rajasthan</option>
        <option value="Sikkim">Sikkim</option>
        <option value="Tamil Nadu">Tamil Nadu</option>
<option value="Telangana">Telangana</option>
        <option value="Tripura">Tripura</option>
        <option value="Uttarakhand">Uttarakhand</option>
        <option value="Uttar Pradesh">Uttar Pradesh</option>
<option value="West Bengal">West Bengal</option> <br> <br>
      </select><br><br>

<label for="City"><b>City* :</b></label><br>
    <input type="text"  name="city" required><br><br>

<label for="Pincode"><b>Pincode* :</b></label><br>
    <input type="text"  name="pin_code" pattern="[0-9]{6}" required><br><br>

<input type="checkbox" name="Agree" value="Agree" required>By creating an account you agree to our terms and conditions.<br>
   
    <input type="submit" class="registerbtn" value="Open Account">
  
  </form>


</body>
</html>
