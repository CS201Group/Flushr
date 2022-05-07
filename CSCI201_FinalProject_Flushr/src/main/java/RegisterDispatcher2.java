import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    
    	String name = request.getParameter("registerName");
    	
    	String email = request.getParameter("registerEmail");
    	
    	String password = request.getParameter("registerPassword");
    	
        try {
            String url = "jdbc:mysql://localhost:3306/Flushr_DB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //TODO check if you've done the initialization
            if (!email.contains(".com") && !email.contains(".net") && !email.contains(".gov")
				&& !email.contains(".edu") && !email.contains(".org") && !email.contains(".co.uk")
				&& !email.contains(".biz") && !email.contains(".info")) {
	        	request.setAttribute("error","Invalid user");
	        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("signup.jsp");
	        	requestDispatcher.forward(request, response);
	        }
            if(!email.contains("@")) {
	        	request.setAttribute("error","Invalid user");
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("signup.jsp");
        		requestDispatcher.forward(request, response);
	        }
            
        	
        	if (email.contentEquals("") || password.contentEquals("")) {
        		request.setAttribute("error","Invalid input");
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("signup.jsp");
        		requestDispatcher.forward(request, response);
        	}
	
			// check if email already exists in the database, if so, redirect back to login
			// page
			String sql = "INSERT INTO user (email, name, password) VALUES (?, ?, ?)";
	
			Connection conn = null;
			PreparedStatement ps = null;
	
	
			try {
            	conn = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);
				ps = conn.prepareStatement("SELECT * FROM user WHERE email= ?");
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					throw new Exception("User Already Exists");
				}	
				else {
					try {
						conn = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);
						ps = conn.prepareStatement(sql);
						ps.setString(1, email);
						ps.setString(2, name);
						ps.setString(3, password);
						int temp = ps.executeUpdate();
						HttpSession session = request.getSession();
						session.setAttribute("name", name);
						
						response.sendRedirect("mainFeed.jsp");
						// System.out.println("connection successful!");
					} catch (SQLException ex) {
						System.out.println("SQLException: " + ex.getMessage());
					}
				}
	
			} catch (Exception ex) {
				System.out.println("Exception: " + ex.getMessage());
				//request.setAttribute("errorMessage", "Invalid email or password. Or, bad login. Please try again.");
				name = "";
				RequestDispatcher requestDispatcher = request
			            .getRequestDispatcher("signup.jsp");
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
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
