import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
public class getcookie extends HttpServlet{
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
res.setContentType("text/html"); 
PrintWriter out = res.getWriter(); 
Cookie[] mycookie = req.getCookies(); 
String[] name = new String[10]; 
String[] value = new String[10];
int i=0;
int n=mycookie.length;
out.println("The number of cookies:"+n); 
for(i=0;i<n;i++){ 
    name[i]=mycookie[i].getName();
    if(name[i].equals("pwd1")){
        if(name[i+1].equals("user1")){ 
            out.println("WelCome"+name[i+1]);} 
        else{
        out.println("Unauthorised User");}
    } 
else if(name[i].equals("pwd2")){
    if(name[i+1].equals("user2"))
    { out.println("WelCome"+name[i+1]);} 
    else{
    out.println("Unauthorised User");}
} 
else if(name[i].equals("pwd3")){
    if(name[i+1].equals("user3")){ out.println("WelCome"+name[i+1]);} else{
    out.println("Unauthorised User");}} else if(name[i].equals("pwd4")){
    if(name[i+1].equals("user4")){ out.println("WelCome"+name[i+1]);} else{
    out.println("Unauthorised User");}}} catch(Exception e){
    out.println("Invalid username/password");
}
}
}

