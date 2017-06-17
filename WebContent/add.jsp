<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Example of Bootstrap 3 Accordion</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/on.css">
		<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/bootstrap.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
<form action="insert" method="post">
<body style="background:#DCDCDC">
<div class="container-fluid">
<div class="container-fluid" style="padding-top: 25px;padding-bottom: 25px;" >
<nav class=" navbar navbar-inverse" style="background:#00BFFF;">
  <div class="navbar-header"> 
   <a class="navbar-brand" href ="#" style="color: black"> <span class="glyphicon glyphicon-user"></span> Add Student Details</a>
   </div>
   </nav>
   </div ><table class="table"><c:forEach var="mass" items="${list}">
    <thead>
      <tr>
        <th style="padding: 10px;">Studet_id</th> <td><input class="form-control" name="stu_id" type="text"  style="width: 350px;"></td>
      </tr>
      <tr>
        <th style="padding: 10px;">Student_name</th> <td><input class="form-control" name="stu_name" type="text" style="width: 350px;"></td>
      </tr>
      <tr>
       <th style="padding: 10px;">Student_Sal</th> <td><input class="form-control" name="sal" type="text"  style="width: 350px;"></td>
       </tr>
       </thead>
       </c:forEach>
      </table>
       <button type="submit" class="btn btn-info">Sumbit</button>
      
  </div> 
</form>
</body>
</html>