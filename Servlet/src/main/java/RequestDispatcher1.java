import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/RequestDispatcher1")
public class RequestDispatcher1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String s1 = request.getParameter("t1");
		String s2 = request.getParameter("t2");
		
		if(s1.equals("Gauri") && s2.equals("Gauri@123"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request, response);
		}
		else
		{
			pw.print("<h2>Login Failed...</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("Login3.html");
			rd.include(request, response);
		}
		pw.close();
		
		
	}

}
