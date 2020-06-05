<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "bloodbank";
String userid = "root";
String password = "srini397";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
 table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        
        td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        
        tr:nth-child(even) {
            background-color: #dddddd;
        }

</style>
</head>
<body>
<script type="text/javascript">
        function noBack()
         {
             window.history.forward()
         }
        noBack();
        window.onload = noBack;
        window.onpageshow = function(evt) { if (evt.persisted) noBack() }
        window.onunload = function() { void (0) }
    </script>

<div>
<div>
<h1><u>Request List</u></h1>
</div>
<div><a href="adminsheet.html"><u>Back</u></a></div>
</div>
<br>
<table border="1">
<tr>
<td>Name</td>
<td>Date</td>
<td>Within Date</td>
<td>Age</td>
<td>Blood Type</td>
<td>Phone</td>
</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from request";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("date") %></td>
<td><%=resultSet.getString("withindate") %></td>
<td><%=resultSet.getString("age") %></td>
<td><%=resultSet.getString("blood") %></td>
<td><%=resultSet.getString("phone") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<script type="text/javascript">
        function noBack()
         {
             window.history.forward()
         }
        noBack();
        window.onload = noBack;
        window.onpageshow = function(evt) { if (evt.persisted) noBack() }
        window.onunload = function() { void (0) }
    </script>

</body>
</html>