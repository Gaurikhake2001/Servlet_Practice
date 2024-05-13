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




@WebServlet("/LoginServlet1")
public class LoginServlet1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	PrintWriter pw = response.getWriter();
	response.setContentType("text/html");
	String s1 = request.getParameter("t1");
	String s2 = request.getParameter("t2");
	
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
		
		PreparedStatement ps = con.prepareStatement("select * from User where UserId=? and Pwd=?");
		ps.setString(1,s1);
		ps.setString(2, s2);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			pw.println("<h2> Welcome"+" "+s1+"</h2>");
			
		}
		else
		{
			pw.println("<h2> Login Failed</h2>");
		}
		rs.close();
		con.close();
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	}

}
