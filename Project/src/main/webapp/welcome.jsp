<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="logout.do" method="post">
	
	 <input type="hidden" name="formid" value="logout">
	<input type="hidden" name="uname" value="<%=request.getAttribute("uname") %>">
		<input type="hidden" name="upass" value="<%=request.getAttribute("upass") %>">	
	 
			<input type="submit" value="Logout">
			</form>
	<h1>Welcome <%=request.getParameter("uname") %></h1>
</body>
</html>