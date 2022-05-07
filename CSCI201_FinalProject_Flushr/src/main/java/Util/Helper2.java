package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Helper2 {
    /**
     * check if name is valid
     *
     * @param name the name user provides
     * @return valid or not valid
     */
    public static boolean validName(String name) {
        return true;
    }

    /**
     * check if email is valid
     *
     * @param email the email user provides
     * @return valid or not valid
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        if (email.contains("@")) {
        	return true;
        }
		return false;
    }

    /**
     * Get username with the email
     *
     * @param email
     * @return userName
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static String getUserName(String email) throws SQLException, ClassNotFoundException {
        //TODO
    	Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flushr_DB", "root", "root")) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = '" + email + "'");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				return name;
			}
			else {
				return "Name not found";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
    }

    /**
     * Get userID with email
     *
     * @param email
     * @return userID
     * @throws SQLException
     */
    public static int getUserID(String email) throws SQLException {
        //TODO
        return 0;
    }

    public static void registerUser(String email, String password) throws SQLException {
	    	try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flushr_DB", "root", "root")) {
	    		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/saleatsdb", "root", "root");
	    		//conn.createStatement();
	    		//String sql = "INSERT INTO users VALUES (?,?,?)";
	    		String sql = "INSERT INTO users VALUES " + "(" + "'" + email + "'"  + password + "')";
	    		PreparedStatement stmt = conn.prepareStatement(sql);
	    		/*
	    		stmt.setString(1, email);
	            stmt.setString(2, name);
	            stmt.setString(3, password);
	            */
	    		stmt.executeUpdate(sql);
	    	}
	    	catch(SQLException e) {
	    		e.printStackTrace();
	    	}
    }
    
    /**
     * check if the email and password matches
     *
     * @param email
     * @param password
     * @throws ClassNotFoundException 
     */
    public static boolean checkPassword(String email, String password) throws SQLException, ClassNotFoundException {
        //TODO
    	Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flushr_DB", "root", "root")) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = '" + email + "'");
			//ps.setString(1, email); // set first variable in prepared statement
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String storedPassword = rs.getString("password");
				if (storedPassword.contentEquals(password)) {
					return true;
				}
				else {
					return false;
				}
			}
	        return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }

    /**
     * Check if email is already registered
     *
     * @param email
     * @param request
     * @param response
     * @return email registered or not
     * @throws ServletException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static boolean emailAlreadyRegistered(String email, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        //TODO
    	
    	Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flushr_DB", "root", "root");
			ps = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
			ps.setString(1, email); // set first variable in prepared statement
			rs = ps.executeQuery();
			if (rs.next()) {
					return true;
			}
	        return false;
		}
		catch(SQLException e) {
			throw e;
		}
		
    }
}
