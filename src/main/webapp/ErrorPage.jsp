<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage = "true" %>
<%@include file="Dashboard.jsp"%>


<html>
   <head>
   
   <style>
   .clear {
    clear: both;
}
   </style>
   
      <title>Show Error Page</title>
   </head>
   
   <body>
   
  <%--     <h1>Oops...</h1>
      <table width = "100%" border = "1">
         <tr valign = "top">
            <td width = "40%"><b>Error:</b></td>
            <td>${pageContext.exception}</td>
         </tr>
            
         <tr valign = "top">
            <td><b>URI:</b></td>
            <td>${pageContext.errorData.requestURI}</td>
         </tr>
            
         <tr valign = "top">
            <td><b>Status code:</b></td>
            <td>${pageContext.errorData.statusCode}</td>
         </tr>
            
       
      </table> --%>
     
      <div class="clear"  id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1><span></span></h1>
			</div>
                           <center>   <h1>${pageContext.errorData.statusCode}</h1> </center>
			<center><h2>Oops! ${pageContext.exception}</h2>
			<p>${pageContext.errorData.requestURI}</p>
			<a  href="Login.jsp">Back to login page</a>
		</div>
	</div>

   </body>
</html>