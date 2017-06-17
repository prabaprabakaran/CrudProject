<%@page import="com.util.DAO.BussinessLogic"%>
<%@page import="com.util.conn.DbConnection"%>
<%@page import="com.util.bean.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Example of Bootstrap 3 Accordion</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/on.css">
		<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/bootstrap.js" type="text/javascript"></script>
<title>View title here</title>
</head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%List<StudentOne> list=BussinessLogic.getList();
request.setAttribute("list",list);
%>
	
<body style="background:white">

<div class="container-fluid" style="padding-top: 25px;padding-bottom: 25px;" >
<nav class=" navbar navbar-inverse" style="background:#00BFFF;">
  <div class="navbar-header"> 
   <a class="navbar-brand" href ="#" style="color: black"> <span class="glyphicon glyphicon-user"></span> All Student Details</a>
<div class="container">
</div>
</div>
</nav>
<table class="table">
      <thead>
    <tr>
      <th class="info">STU_ID</th>
      <th class="danger">STU_NAME</th>
      <th class="success">SAL</th>
      <th class="info"><b>Add</b></th>
      <th class="info"><b>Update</b></th>
      <th class="danger"><b>Delete</b></th>
      </tr>
      </thead>
      <tbody>
            <c:forEach var="mass" items="${list}">
      <tr >
      <td class="info" > <c:out value="${mass.stu_id}"></c:out></td>
      <td class="danger"><c:out value="${mass.stu_name}"></c:out></td>
      <td class="success"><c:out value="${mass.sal}"></c:out></td>
       <td  class="btn-info" ><a href='add.jsp' ><p style= "color:black">Add</p></a></td>  
       <td class="btn-success"><a href='UpdateServletToo?stu_id=${mass.stu_id}'><p style= "color:black">Update</p></a></td>
      <td class="btn-danger"><a href='delete?stu_id=${mass.stu_id}'><p style= "color:black">Delete</p></a></td>
    </tr>
    </c:forEach>
</tbody>
</table>
</div>
</body>
</form>
</html>