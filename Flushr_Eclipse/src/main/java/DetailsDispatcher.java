import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import javax.servlet.ServletConfig;
import Util.Restaurant;
import java.util.*;
import Util.Location;
import Util.*;
import java.util.List;


import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Util.Constant;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.http.*;
import java.io.*;


/**
 * Servlet implementation class LogoutDispatcher
 */
@WebServlet("/DetailsDispatcher")
public class DetailsDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
	private static final String url = "jdbc:mysql://localhost:3306/aadeshbajajassgt2";
	String user = "root";
	String pwd = Util.Constant.DBPassword;

    
    public DetailsDispatcher() {
    	super();
    }
   
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	
    	
    	String ID=request.getParameter("detailsID");
    	//System.out.println(ID);
    	
    	

    	Connection con = null;
    	PreparedStatement p = null;

    	try {
    		Class.forName("com.mysql.jdbc.Driver");

    	} catch (Exception ex) {
    		// handle the error
    		System.out.println("SQLException: " + ex.getMessage());
    	}


    	String sql = "SELECT DISTINCT restaurant.restaurant_name, restaurant_details.address, restaurant_details.phone_no, restaurant_details.estimated_price, rating_details.rating, bridge_table.category_id, restaurant_details.image_url " 
    			+ "FROM restaurant, restaurant_details, rating_details, bridge_table "
    			+ "WHERE restaurant.restaurant_id = restaurant_details.details_id "
    			+ "AND bridge_table.restaurant_id = restaurant.restaurant_id "
    			+ "AND rating_details.rating_id = restaurant.restaurant_id "
    			+ "AND restaurant.restaurant_id LIKE '%" + ID + "%'; ";

    			
    	try {
    		con = DriverManager.getConnection(url, user, pwd);
    		p = con.prepareStatement(sql);
    		ResultSet rs = p.executeQuery();
    		rs.next();
    		Restaurant r = new Restaurant();
    		Location l = new Location();
    		r.setPhone(rs.getString("phone_no"));
    		r.setName(rs.getString("restaurant_name"));
    		l.setAddress1(rs.getString("address"));
    		r.setLocation(l);
    		r.setImageUrl(rs.getString("image_url"));
    		r.setPrice(rs.getString("estimated_price"));
    		r.setRating(rs.getDouble("rating"));
    		ArrayList<Category> categories = new ArrayList<Category>();
    		Category c = new Category();
    		c.setTitle(rs.getString("category_id"));
    		categories.add(c);
    		while (rs.next()) {
    			Category cat = new Category();
        		cat.setTitle(rs.getString("category_id"));
        		categories.add(cat);
    		}
    		r.setCategories(categories);
//    		System.out.println(r.getName() + "HIIIII");
//    		
//    		for (Category cat : categories) {
//    			System.out.println(cat.getTitle());
//    		}
    		
        	request.setAttribute("detailsRest", r);

    	} catch (SQLException ex) {
    		request.setAttribute("errorMessage", "Invalid email or password. Or, bad Google login. Please try again.");
    			
    	}

    	try {
			request.getRequestDispatcher("details.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
            throws IOException {
    	//Send to doPost
    	
        doGet(request, response);
    }

}
