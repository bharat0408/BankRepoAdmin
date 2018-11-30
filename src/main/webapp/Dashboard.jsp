<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            $(document).ready(function(){
              $("#searchPayee").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#payeeListTable tr").filter(function() {
                  $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
              });
            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <h1>Hello User</h1>
        <a href="AddPayee.jsp">Add Payee</a><br>
        <a href="DeletePayee.jsp">Delete Payee</a><br> 
        <p>${msg}</p>
        <a id="display_button" href="DisplayPayee">Display</a>
        </form>
        <br><br>
        Search   <input class="form-control" id="searchPayee" type="text" placeholder="Search..">
        <div >
            <c:if test="${not empty PayeeList}">
                <table border="1" id="">
                    <thead>
                        <tr>
                            <th>Account Number</th>
                            <th>Payee Name</th>
                            <th>Payee Nick Name</th>
                        </tr>
                    </thead>
                    <tbody id="payeeListTable">
                        <c:forEach items="${PayeeList}" var="payee">
                            <tr>
                                <td>${payee.getPayee_account_number()}</td>
                                <td>${payee.getName()}</td>
                                <td>${payee.getNick_name()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <select>
            <c:forEach items="${PayeeList}" var="payee">
            
            <option value="${payee.getName()}">${payee.getName()}</option>
            </c:forEach>
            
            </select>
        <a href="FundTransfer">Initiate a Fund Transfer</a>
        <br><br>
        <a href="">User Profile</a><br>
        <a href="">Account Summary</a><br>
        <a href="AccountStatement.jsp">Account Statement</a><br>
        
        <br>
        <a href="demo">Get Balance</a>
    </body>
</html>
 --%>


<html lang="en">

  <head>
  
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            $(document).ready(function(){
              $("#searchPayee").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#payeeListTable tr").filter(function() {
                  $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
              });
              
             
           
            });
        </script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="custombutton.css">
    
    <style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color:#f2f2f2;}

#customers tr:hover {background-color: #ccffe6;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #0099ff;
    color: white;
}
</style>

  </head>

  <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="index.html"> SBBI Bank</a> <img src="images.png" width=3% height=3%>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

      
      <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-bell fa-fw"></i>
            <span class="badge badge-danger">9+</span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-envelope fa-fw"></i>
            <span class="badge badge-danger">7</span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="#">Settings</a>
            <a class="dropdown-item" href="#">Activity Log</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
          </div>
        </li>
      </ul>

    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="summary">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Account Summary</span>
          </a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="AccountStatement.jsp"  role="button"  aria-haspopup="true" aria-expanded="false">
 
            <span>Account Statement</span>
          </a>
       <!--    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Login Screens:</h6>
            <a class="dropdown-item" href="login.html">Login</a>
            <a class="dropdown-item" href="register.html">Register</a>
            <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Other Pages:</h6>
            <a class="dropdown-item" href="404.html">404 Page</a>
            <a class="dropdown-item" href="blank.html">Blank Page</a>
          </div> -->
        </li>
        <li class="nav-item">
          <a class="nav-link" href="FundTransfer">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Fund Transfer</span></a>
        </li>
              </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="#">Dashboard</a>
            </li>
            
          </ol>

          <!-- Icon Cards-->
          <div class="row">
            <div class="col-xl-4 col-lg-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-10">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-comments"></i>
                  </div>
                  <div class="mr-5">User Profile</div>
                </div>
                
              </div>

<!-- .dropright -->
<div class="btn-group dropdown">
   <button class="btn btn-primary dropdown-toggle dropdown-toggle-split"
      type="button"
      id="dropdownMenuButton" data-toggle="dropdown"
      aria-haspopup="true" aria-expanded="false">
   View Details
   </button>
   <div class="dropdown-menu">
      <a class="dropdown-item" href="details">Account Details</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="AccountStatement.jsp">Account Statement</a>
 <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="summary">Account Summary</a>
   </div>
</div>



            </div>
            <div class="col-xl-4 col-sm-6 mb-3">
              <div class="card text-white bg-warning o-hidden h-10">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-list"></i>
                  </div>
                  <div class="mr-5">Fund Transfer</div>
                </div>
                
              </div>

<!-- .dropright -->
<div class="btn-group dropdown">
   <button class="btn btn-primary dropdown-toggle dropdown-toggle-split"
      type="button"
      id="dropdownMenuButton" data-toggle="dropdown"
      aria-haspopup="true" aria-expanded="false">
   View Details
   </button>
   <div class="dropdown-menu">
      <a class="dropdown-item" href="AddPayee.jsp">Add Payee</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="DeletePayee.jsp">Delete Payee</a>
          <a class="dropdown-item" href="DisplayPayee">Display Payee</a>
   
   </div>
</div>





            </div>
            <div class="col-xl-4 col-sm-6 mb-3">
              <div class="card text-white bg-success o-hidden h-10">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-shopping-cart"></i>
                  </div>
                  <div class="mr-5">Manage Account</div>
                </div>
          
              </div>
<!-- .dropright -->
<div class="btn-group dropdown">
   <button class="btn btn-primary dropdown-toggle dropdown-toggle-split "
      type="button"
      id="dropdownMenuButton" data-toggle="dropdown"
      aria-haspopup="true" aria-expanded="true">
   View Details
   </button>
   <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Change User ID</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="#">Change Login Password</a>
<div class="dropdown-divider"></div>
      <a class="dropdown-item" href="#">Change Transaction Password</a>
   </div>
</div>

            </div>
            
            
            
           
            <c:if test="${not empty PayeeList}">
                <br><br>
        <h3>Search</h3>   <input class="form-control" id="searchPayee" type="text" placeholder="Search..">
       <br><br> <div >
                <table id="customers" border="1" id="">
                    <thead>
                        <tr>
                            <th>Account Number</th>
                            <th>Payee Name</th>
                            <th>Payee Nick Name</th>
                        </tr>
                    </thead>
                    <tbody id="payeeListTable">
                        <c:forEach items="${PayeeList}" var="payee">
                            <tr>
                                <td>${payee.getPayee_account_number()}</td>
                                <td>${payee.getName()}</td>
                                <td>${payee.getNick_name()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
            
            
            ${transaction}
            ${payee_status}
            
            
            
            
           


        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright ©  SBBI Bank</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="js/demo/datatables-demo.js"></script>
    <script src="js/demo/chart-area-demo.js"></script>

  </body>

</html>
