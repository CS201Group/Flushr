import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.sql.SQLException;
import java.util.regex.Matcher;
import Util.Helper;

/**
 * Servlet implementation class RegisterDispatcher
 */
@WebServlet("/RegisterDispatcher")

public class RegisterDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public RegisterDispatcher() {
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
    	
    	if (email.contentEquals("") || password.contentEquals("")) {
    		errorMessage = "Please enter a username and password.";
    	}
    	
    	// check sql stuff to see if user is already registered
    	
    	if (errorMessage.contentEquals("")) {
    		// register the user
    		try {
				if (Helper.emailAlreadyRegistered(email, request, response)) {
					response.setContentType("text/html");
		    		PrintWriter out = response.getWriter();
		    		out.println("<span style='background-color:#ffcccb; width=100%;'>" + errorMessage + "</span>");
		    		request.getRequestDispatcher("signup.html").include(request, response);
				}
				else {
					// register the user
					Helper.registerUser(email, password);
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
