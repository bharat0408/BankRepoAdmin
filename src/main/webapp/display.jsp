<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table border="1">
      <th>Mobile Number</th>
      <th>Amount</th>
       <th>Operator</th>
 
      <c:forEach items="${transactionList}" var="current">
        <tr>
          <td><c:out value="${current.getMobileNo()}" /></td>
          <td><c:out value="${current.getAmount()}" /></td>
          <td><c:out value="${current.getOperator()}" /></td>
      
          
        </tr>
      </c:forEach>
    </table>

</body>
</html>