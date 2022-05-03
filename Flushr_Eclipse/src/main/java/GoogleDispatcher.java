import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.*;
import java.lang.Object;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Util.Constant;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


/**
 * Servlet implementation class GoogleDispatcher
 */
@WebServlet("/GoogleDispatcher")
public class GoogleDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
	private static final String url = "jdbc:mysql://localhost:3306/aadeshbajajassgt2";
    	
    public GoogleDispatcher() {
		super();
	}
    
    
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String user = "root";
		String pwd = Util.Constant.DBPassword;
		
        //TODO 
        response.setContentType("text/html");

        String email = request.getParameter("email-register");
        String name = request.getParameter("name-register");
        String sql = "SELECT email FROM user WHERE email=?";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        	System.out.println("SQLException: " + ex.getMessage());
        }
        
		ResultSet rs = null;

		try {
			Connection c = DriverManager.getConnection(url, user, pwd);
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, email);
		    rs = p.executeQuery();
		    if (rs.next() == false) {
		    	//System.out.println("Google user Not already in system");
		    	String sql1 = "INSERT INTO user(email, name, password) VALUES (?, ?, ?)";
				PreparedStatement p1 = c.prepareStatement(sql1);
				String fakePW = "root";
				p1.setString(1, email);
				p1.setString(2, name);
				p1.setString(3, fakePW);
				int temp = p1.executeUpdate();
		    }
		    
		} 
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		
		
        HttpSession session = request.getSession(true);
        
        session.setAttribute("userName", name);
        response.sendRedirect("index.jsp");

     
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
