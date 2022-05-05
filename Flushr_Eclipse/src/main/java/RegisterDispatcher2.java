import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;

import Util.Bathroom;
import Util.Constant;
import Util.Helper2;

/**
 * Servlet implementation class RegisterDispatcher
 */
@WebServlet("/RegisterDispatcher2")

public class RegisterDispatcher2 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public RegisterDispatcher2() {
    	super();
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
    	String errorMessage = "";
    	
    	
    	String email = request.getParameter("email");
    	
    	String password = request.getParameter("password");
    	
        try {
            String url = "jdbc:mysql://localhost:3306/Flushr_DB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //TODO check if you've done the initialization
            try {
            	Connection conn = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);
          	  
           	 	String sql_user = "INSERT INTO User (email, password) VALUES (?,?)";
           	 	//String sql_bridge = "INSERT INTO bathroom_bookmarks (category_id, restaurant_id) VALUES (?,?)";
           	 
                
           	 	//User
           	 	PreparedStatement ps3 = conn.prepareStatement(sql_user, Statement.RETURN_GENERATED_KEYS);
           	 	ps3.setString(1, email);
           	 	ps3.setString(1, password);
           	 	ps3.executeUpdate(); 
            
            }
            catch(SQLException ex) {
            	System.out.println("SQLException: " + ex.getMessage());
            }
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    	
    	if (email.contentEquals("") || password.contentEquals("")) {
    		errorMessage = "Please enter a username and password.";
    	}
    	
    	// check sql stuff to see if user is already registered
    	
    	if (errorMessage.contentEquals("")) {
    		// register the user
    		try {
				if (Helper2.emailAlreadyRegistered(email, request, response)) {
					response.setContentType("text/html");
		    		PrintWriter out = response.getWriter();
		    		out.println("<span style='background-color:#ffcccb; width=100%;'>" + errorMessage + "</span>");
		    		request.getRequestDispatcher("signup.html").include(request, response);
				}
				else {
					// register the user
					Helper2.registerUser(email, password);
					response.sendRedirect("main.html");
					//request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    	}
    	else {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("<span style='background-color:#ffcccb; width=100%;'>" + errorMessage + "</span>");
    		request.getRequestDispatcher("signup.html").include(request, response);
    	}
    	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
