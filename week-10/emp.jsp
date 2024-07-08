<html>
<head>
<title>Users list</title>
</head>
<body>
<%@ page import = "java.sql.*" %>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wt_db","root","root"); String joiningDate = request.getParameter("joining_date");
String query = "SELECT emp_name, emp_id, salary, department FROM employees WHERE joining_date
= ?";
PreparedStatement ps = conn.prepareStatement(query); ps.setString(1, joiningDate);
ResultSet rs = ps.executeQuery(); if(rs.next()) {
%>
<center><table border=1 cellpadding=5>
<tr>
</tr>
<%
<th>Name</th>
<th>Employee ID</th>
<th>Salary</th>
<th>Department</th>
do {
%>
<tr>
</tr>
<%
String empName = rs.getString("emp_name"); int empId = rs.getInt("emp_id");
int salary = rs.getInt("salary");
String department = rs.getString("department");
<td><%= empName %></td>
<td><%= empId %></td>
<td><%= salary %></td>
<td><%= department %></td>
} while(rs.next());
%>
</table>
<%
} else {
out.println("No results found");} rs.close();
ps.close();
conn.close();
%><h3>Copyright @ Kavya-20071A0533</h3></center>
</body>
</html>