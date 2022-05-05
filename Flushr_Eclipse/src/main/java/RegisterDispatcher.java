//import javax.servlet.annotation.WebServlet;
//import Util.Constant;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import Util.Helper;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//import java.io.*;
//import java.sql.*;
//
///**
// * Servlet implementation class RegisterDispatcher
// */
//@WebServlet("/RegisterDispatcher")
//public class RegisterDispatcher extends HttpServlet {
//	@Serial
//	private static final long serialVersionUID = 1L;
//	//private static final String url = "jdbc:mysql://localhost:3306/asdfasdf";
//	
//
//
//	/**
//	 * Default constructor.
//	 */
//	public RegisterDispatcher() {
//		super();
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO
//		// CHECK IF ALREADY EXISTS
//		
//		request.setAttribute("errorMessage", "");
//
//
//		String registerEmail = request.getParameter("registerEmail");
//		String registerName = request.getParameter("registerName");
//		String registerPW = request.getParameter("registerPW");
//		String registerPWC = request.getParameter("registerPWC");
//		
//
//		if (!(registerPW.equals(registerPWC))) {
//			System.out.println(
//					"Invalid password or confirmed password. Please make sure both fields match and are not empty");// return
//			// error
//			// message
//			return;
//		}
//		
//		
//		if (!registerEmail.contains(".com") && !registerEmail.contains(".net") && !registerEmail.contains(".gov")
//				&& !registerEmail.contains(".edu") && !registerEmail.contains(".org") && !registerEmail.contains(".co.uk")
//				&& !registerEmail.contains(".biz") && !registerEmail.contains(".info")) {
//			request.setAttribute("error","Invalid user");
//			RequestDispatcher requestDispatcher = request
//		            .getRequestDispatcher("auth.jsp");
//		    requestDispatcher.forward(request, response);
//		}
//
//		// check if email already exists in the database, if so, redirect back to login
//		// page
//
//		String sql = "INSERT INTO user (email, name, password) VALUES (?, ?, ?)";
//
//		String user = "root";
//		String pwd = Util.Constant.DBPassword;
//		Connection c = null;
//		PreparedStatement p = null;
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//
//		} catch (Exception ex) {
//			// handle the error
//			System.out.println("SQLException: " + ex.getMessage());
//		}
//
//
//		try {
//			c = DriverManager.getConnection(url, user, pwd);
//			p = c.prepareStatement("SELECT * FROM user WHERE email= ?");
//			p.setString(1, registerEmail);
//			ResultSet rs = p.executeQuery();
//			if (rs.next()) {
//				System.out.println("Invalid user");
//				throw new Exception("User Already Exists");
//			}	
//
//		} catch (SQLException ex) {
//			request.setAttribute("errorMessage", "Invalid email or password. Or, bad Google login. Please try again.");
//			registerName = "";
//			RequestDispatcher requestDispatcher = request
//		            .getRequestDispatcher("auth.jsp");
//		    requestDispatcher.forward(request, response);		
//		}
//		catch (Exception e) {
//			System.out.println("SQLException: " + e.getMessage());			
//			request.setAttribute("errorMessage", "Invalid email or password. Or, bad Google login. Please try again.");
//			registerName = "";
//			RequestDispatcher requestDispatcher = request
//		            .getRequestDispatcher("auth.jsp");
//		    requestDispatcher.forward(request, response);
//			
//		}
//
//		try {
//			c = DriverManager.getConnection(url, user, pwd);
//			p = c.prepareStatement(sql);
//			p.setString(1, registerEmail);
//			p.setString(2, registerName);
//			p.setString(3, registerPW);
//			int temp = p.executeUpdate();
//			// System.out.println("connection successful!");
//		} catch (SQLException ex) {
//			System.out.println("SQLException: " + ex.getMessage());
//		}
//
//		HttpSession session = request.getSession();
//		session.setAttribute("userName", registerName);
//		
//
//		response.sendRedirect("index.jsp");
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// Send to doPost
//
//		doGet(request, response);
//	}
//
//}
