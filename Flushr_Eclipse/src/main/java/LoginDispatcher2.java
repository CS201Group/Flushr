import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Util.Constant;
import Util.Helper2;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginDispatcher
 */

@WebServlet(name="LoginDispatcher2",urlPatterns={"/LoginDispatcher2"})
public class LoginDispatcher2 extends HttpServlet {
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
        	
        	String url = "jdbc:mysql://localhost:3306/Flushr_DB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
			PreparedStatement ps = null;
	
	
			try {
            	conn = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);
				ps = conn.prepareStatement("SELECT * FROM user WHERE email= ? AND password= ?");
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					
					response.sendRedirect("mainFeed.jsp");
				
				}
				else {
					RequestDispatcher requestDispatcher = request
				            .getRequestDispatcher("login.jsp");
				    requestDispatcher.forward(request, response);	
				}
			}
			catch (Exception ex) {
					System.out.println("Exception: " + ex.getMessage());
					//request.setAttribute("errorMessage", "Invalid email or password. Or, bad login. Please try again."
					RequestDispatcher requestDispatcher = request
				            .getRequestDispatcher("login.jsp");
				    requestDispatcher.forward(request, response);	

			}
    	}
    	 catch (ClassNotFoundException e) {
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
