<html>
<head>
<title>Books list</title>
</head>
<body>
<%@ page import = "java.sql.*,java.time.LocalDate, java.time.temporal.ChronoUnit" %>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wt_db","root","root");
String author = request.getParameter("author");
String query = "SELECT book_id, booktitle, author, price FROM book WHERE author = ?"; PreparedStatement ps = conn.prepareStatement(query);
ps.setString(1, author);
ResultSet rs = ps.executeQuery(); if(rs.next()) {
%>
<center><h1>Book Details of Author <%=author%> are: </h1>
<table border=1 cellpadding=5>
<tr>
</tr>
<%
<th>Book ID</th>
<th>Name of the Book</th>
<th>Price</th>
do {
%>
<tr>
</tr>
<%
String bookName = rs.getString("booktitle"); int bookId = rs.getInt("book_id");
int price = rs.getInt("price");
<td><%= bookId %></td>
<td><%= bookName %></td>
<td><%= price %></td>
} while(rs.next());
%>
</table>
<%
} else {
out.println("No author is found");
}
s.close();
ps.close();
conn.close();
%><h3>Copyright @ Kavya-20071A0533</h3></center>
</body>
</html>