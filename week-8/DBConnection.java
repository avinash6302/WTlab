import java.io.*;
import java.util.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        String s1 = request.getParameter("course");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        // connecting to database
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wt_db", "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM students");
            // displaying records
            out.println("<center><h1>Students having course " + s1 + "</h1>");
            out.print("<table><tr><th>Student Name</th></tr>");
            while (rs.next()) {
                String s2 = rs.getObject(3).toString();
                if (s1.equals(s2)) {
                    out.print("<tr><td>");
                    out.print(rs.getObject(2).toString());
                    out.print("</td></tr>");
                }
                out.print("<br>");
            }
        } catch (SQLException e) {
            throw new ServletException("Servlet Could not display records.", e);
        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC Driver not found.", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
        out.close();
    }
}
