import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
public class initparam extends HttpServlet{
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
res.setContentType("text/html"); 
PrintWriter out = res.getWriter();
String username1=getServletConfig().getInitParameter("username1"); 
String password1=getServletConfig().getInitParameter("password1"); 
String username2=getServletConfig().getInitParameter("username2"); 
String password2=getServletConfig().getInitParameter("password2"); 
String username3=getServletConfig().getInitParameter("username3");
String password3=getServletConfig().getInitParameter("password3"); 
String username4=getServletConfig().getInitParameter("username4"); 
String password4=getServletConfig().getInitParameter("password4"); 
String un= req.getParameter("username"); 
String p= req.getParameter("password"); 
if(((username1.equals(un))&&(password1.equals(p)))|| ((username2.equals(un))&&(password2.equals(p))|| ((username3.equals(un))&&(password3.equals(p)))|| ((username4.equals(un))&&(password4.equals(p))))) 
{ 
    out.println("<b>WelCome to "+un+"kavya(20071A0533)</b>");
}
else{
out.println("<b>Unathorised User @ user(20071A05XX)
</b>");
}}}