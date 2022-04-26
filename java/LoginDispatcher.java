import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginDispatcher
 */
@WebServlet("/LoginDispatcher")


public class LoginDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
    	
    	try {
    		String email = request.getParameter("email");
        	String password = request.getParameter("password");
        	
        	
			boolean isValidUser = Helper.checkPassword(email, password);
			if (isValidUser) {
				String name = Helper.getUserName(email);
				Cookie cookie = new Cookie("name", name);
				response.setContentType("text/html");
				response.addCookie(cookie);
				request.getSession().setAttribute("loggedInUser", name);
				response.sendRedirect("index.jsp");
				//request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				
				String errorMessage = "Invalid email or password. Or bad google login. Please try again.";
				response.setContentType("text/html");
				
	    		PrintWriter out = response.getWriter();
	    		out.println("<span style='background-color:#ffcccb; width=100%;'>" + errorMessage + "</span>");
	    		out.flush();
	    		request.getRequestDispatcher("auth.jsp").include(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
