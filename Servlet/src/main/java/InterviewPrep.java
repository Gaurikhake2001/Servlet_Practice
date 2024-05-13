import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



@WebServlet("/InterviewPrep")
public class InterviewPrep extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
	    response.setContentType("text/html");	
	    pw.println("<html><body>");
	    pw.println("<h2>This is my interview prep program!!</h2>");
	    pw.println("</body></html>");
	    
	    
	    pw.println("<form>"
	    		+ "UserId: <input type='username' name='t1'<br><br>"
	    		+ "Password: <input type='password' name='t2'<br><br>"
	    		+ "<input type='submit' value='Login'"
	    		+ "</form>");
	    
	    String s1 = request.getParameter("t1");
	    String s2 = request.getParameter("t2");
	    
	    try
	    {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost3306/Prep","root" ,"root");
	    	
	    	PreparedStatement ps = con.prepareStatement("select * from Servlet where uid=? and pwd=?");
	    	ps.setString(1, s1);
	    	ps.setString(2, s2);
	    	ResultSet rs = ps.executeQuery();
	    	
	    	if(rs.next())
	    	{
	    		pw.println("<h1> Welcome </h1>");
	    	}
	    	else
	    	{
	    		pw.println("<h1> Login Failed </h1>");
	    	}
	    	rs.close();
	    	con.close();
	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    
	    pw.close();
	    
	
	
	
	}

}
