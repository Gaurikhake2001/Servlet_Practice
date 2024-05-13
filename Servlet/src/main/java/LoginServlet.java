import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String s1 = request.getParameter("t1");
		String s2 = request.getParameter("t2");
		
		if(s1.equals("Admin") && s2.equals("Admin"))
		{
			pw.println("<h2> Welcome"+" "+s2+"<h2>");
			
		}
		else
		{
			pw.println("<h2> Login Failed...</h2>");
		}
		
	}

}
