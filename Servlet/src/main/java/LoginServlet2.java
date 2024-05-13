import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;



@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		PreparedStatement ps;
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root", "root");
		
		ps = con.prepareStatement("select * from Regi_User where User_Id = ?");
		
		ps.setString(1, request.getParameter("t1"));
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			pw.println("User with this Id is already present...");
		}
		else
		{
			ps = con.prepareStatement("insert into Regi_User values(?,?,?,?,?)");
			ps.setString(1, request.getParameter("t1"));
			ps.setString(2, request.getParameter("t2"));
			ps.setString(3, request.getParameter("t3"));
			ps.setString(4, request.getParameter("t4"));
			ps.setString(5, request.getParameter("t5"));
			
			ps.executeUpdate();
			pw.println("Record Inserted Successfully...");
			
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
