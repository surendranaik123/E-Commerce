
<%@page import="servlet.UserData"%>
<%
UserData udata=new UserData();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Data</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
body{

text-align: center;
}
</style>
</head>
<body>
<h2>User Data</h2>
<table>
<thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Email</th>
     <th>Password</th>
    <th>Phone</th>
    <th>Gender</th>
     <th>Address</th>
    <th>Language</th>
    <th>ZipCode</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td><%= %></td>
    <td>Suri</td>
    <td>suri@gmail.com</td>
     <td>suri123</td>
    <td>9652497327</td>
    <td>Male</td>
     <td>A.p</td>
    <td>English</td>
    <td>518380</td>
  </tr>
</tbody>
</table>

</body>
</html>