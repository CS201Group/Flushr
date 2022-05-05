//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.io.Serial;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.*;
//import Util.Constant;
//
///**
// * Servlet implementation class LoginDispatcher
// */
//@WebServlet("/LoginDispatcher")
//public class LoginDispatcher extends HttpServlet {
//    @Serial
//    private static final long serialVersionUID = 1L;
//	private static final String url = "jdbc:mysql://localhost:3306/asdfasdf";
//
//	
//	public LoginDispatcher() {
//		super();
//	}
//	
//	
//    /**
//     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//     * response)
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //TODO
//    	
//		request.setAttribute("errorMessage", "");
//
//	
//		String loginEmail = request.getParameter("loginEmail");
//		String loginPW = request.getParameter("loginPassword");
//		
//		//ensure both fields are not empty otherwise redirect back to auth.jsp
//		if (loginPW == null || loginPW == "" || loginEmail == null || loginEmail == "") {
//			RequestDispatcher requestDispatcher = request
//		            .getRequestDispatcher("auth.jsp");
//		    requestDispatcher.forward(request, response);
//		} //figure out how to display the proper error banner as shown in preview
//
//		//Check to see if loginEmail contains proper ending, otherwise redirect back to auth.jsp with error message
//		if (!loginEmail.contains(".com") && !loginEmail.contains(".net") && !loginEmail.contains(".gov")
//				&& !loginEmail.contains(".edu") && !loginEmail.contains(".org") && !loginEmail.contains(".co.uk")
//				&& !loginEmail.contains(".biz") && !loginEmail.contains(".info")) {
//			RequestDispatcher requestDispatcher = request
//		            .getRequestDispatcher("auth.jsp");
//		    requestDispatcher.forward(request, response);
//		}
//		
//		
//		String sql = "SELECT name FROM user WHERE email=? AND password=?";
//		String user = "root";
//		String pwd = Util.Constant.DBPassword;
//		
//		try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (Exception ex) {
//            // handle the error
//        	System.out.println("SQLException: " + ex.getMessage());
//        }
//		
//		ResultSet rs = null;
//		
//		try {
//			Connection c = DriverManager.getConnection(url, user, pwd);
//			PreparedStatement p = c.prepareStatement(sql);
//			p.setString(1, loginEmail);
//			p.setString(2, loginPW);
//		    rs = p.executeQuery();
//		    if (rs.next() == false) {
//		    	throw new Exception("User Already Exists");
//		    }
//		} 
//		catch (SQLException ex) {
//			System.out.println("SQLException: " + ex.getMessage());
//		}
//		catch (Exception e) {
//			//handle somehow by printing right error message on screen with jsp
//			request.setAttribute("errorMessage", "Invalid email or password. Or, bad Google login. Please try again.");
//			RequestDispatcher requestDispatcher = request
//		            .getRequestDispatcher("auth.jsp");
//		    requestDispatcher.forward(request, response);
//		}
//		
//		//get the username from sql table using the email and password given (assuming both exist)
//		
//		String loginName = "";
//		try {
//			loginName = rs.getString("name");
//		}
//		catch (SQLException ex) {
//			System.out.println("SQLException: " + ex.getMessage());
//		}
//		
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("userName", loginName);
//		
//		response.sendRedirect("index.jsp");
//	
//    	
//    }
//    	
//    
//    /**
//     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//     * response)
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    	//Send to doPost
//        doGet(request, response);
//    }
//}
