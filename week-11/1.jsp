<%@ page import = "java.sql.*" %>
<%
String bid = request.getParameter("bookId");
String bname = request.getParameter("bookname"); String author =request.getParameter("author"); String price = request.getParameter("price"); Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wt_db","root","root");
String sql = "insert into book values (?,?,?,?)"; PreparedStatement pst = conn.prepareStatement(sql); pst.setString(1, bid);
pst.setString(2, bname); pst.setString(3, author); pst.setString(4, price);
int numRows= pst.executeUpdate(); if(numRows==0){out.print("Unable to Insert");} else{out.print("Book details Inserted");}
%>
<%
pst.close();
conn.close();
%>