//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.*;
//import javax.servlet.ServletConfig;
//import Util.Restaurant;
//import java.util.*;
//
//
//import java.io.IOException;
//import java.io.Serial;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import Util.Constant;
//import java.sql.*;
//import java.util.Scanner;
//
//import javax.servlet.http.*;
//import java.io.*;
//
///**
// * Servlet implementation class SearchDispatcher
// */
//@WebServlet("/SearchDispatcher")
//public class SearchDispatcher extends HttpServlet {
//    @Serial
//    private static final long serialVersionUID = 1L;
//    String username = "root";
//    String password = Util.Constant.DBPassword;
//    String url = "jdbc:mysql://localhost:3306/asdfasdf";
//    
//
//    /**
//     * Default constructor.
//     */
//    public SearchDispatcher() {
//    	super();
//    }
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        ServletContext servletContext = getServletContext();
//        // TODO get json file as stream, Initialize FakeYelpAPI by calling its initalize
//        // method
//        InputStream istream = servletContext.getResourceAsStream(Util.Constant.FileName);
//        Scanner sc = new Scanner(istream);
//        sc.useDelimiter("\\A");
//
//        String result = "";
//        while(sc.hasNext())
//            result += sc.next();
//        
//
//        Util.RestaurantDataParser.Init(result);
//        
//        
//        ResultSet rs; 
//        
//
////        SELECT DISTINCT restaurant.restaurant_name, restaurant_details.image_url, rating_details.review_count, rating_details.rating, restaurant_details.yelp_url, restaurant_details.estimated_price  
////        FROM restaurant, restaurant_details, bridge_table, rating_details 
////        WHERE restaurant.restaurant_id = restaurant_details.details_id 
////        AND restaurant.restaurant_id = bridge_table.restaurant_id 
////        AND restaurant.restaurant_id = rating_details.rating_id 
////        AND restaurant.restaurant_name LIKE "%stout%"
////        ORDER BY restaurant_details.estimated_price DESC; 
////        
//        
//    	sc.close();
//}
//
//    /**
//     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//     *      response)
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // TODO
//    	try {
//			Class.forName("com.mysql.jdbc.Driver");
//
//		} catch (Exception ex) {
//			// handle the error
//			System.out.println("SQLException: " + ex.getMessage());
//		}
//    	
//    	
//    	
//    	
//    	String sortCriteria = request.getParameter("sortCriteria");
//    	if (sortCriteria == null) {
//    		sortCriteria = "Price";
//    	}
//    	
//    	String nOrG = request.getParameter("searchSelect");
//    	
//    	String searchReq = request.getParameter("gsearch");
//    	if (searchReq == null || searchReq.equals("")) {
//    		searchReq = "";
//    	}
//    	
//    	ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
//    	
//    	try(Connection c = DriverManager.getConnection(url, username, password)) {
//    		if (nOrG.equals("Category")) {
//    			String sql1 = "";
//    			
//    			if (sortCriteria.equals("Price")) {
//    				sql1 = "SELECT DISTINCT restaurant.restaurant_name, restaurant_details.image_url, rating_details.review_count, "
//    	    				+ "rating_details.rating, restaurant_details.yelp_url, restaurant_details.estimated_price, restaurant.restaurant_id "
//    	    				+ "FROM restaurant, restaurant_details, bridge_table, rating_details "
//    	    				+ "WHERE restaurant.restaurant_id = restaurant_details.details_id "
//    	    				+ "AND restaurant.restaurant_id = bridge_table.restaurant_id "
//    	    				+ "AND restaurant.restaurant_id = rating_details.rating_id "
//    	    				+ "AND bridge_table.category_id LIKE '%" + searchReq + "%' "
//    	    				+ "ORDER BY restaurant_details.estimated_price ASC; ";
//    			}
//    			else if (sortCriteria.equals("Rating")) {
//    				sql1 = "SELECT DISTINCT restaurant.restaurant_name, restaurant_details.image_url, rating_details.review_count, "
//    	    				+ "rating_details.rating, restaurant_details.yelp_url, restaurant_details.estimated_price, restaurant.restaurant_id "
//    	    				+ "FROM restaurant, restaurant_details, bridge_table, rating_details "
//    	    				+ "WHERE restaurant.restaurant_id = restaurant_details.details_id "
//    	    				+ "AND restaurant.restaurant_id = bridge_table.restaurant_id "
//    	    				+ "AND restaurant.restaurant_id = rating_details.rating_id "
//    	    				+ "AND bridge_table.category_id LIKE '%" + searchReq + "%' "
//    	    				+ "ORDER BY rating_details.rating DESC; ";
//    			}
//    			else if (sortCriteria.equals("ReviewCount")) {
//    				sql1 = "SELECT DISTINCT restaurant.restaurant_name, restaurant_details.image_url, rating_details.review_count, "
//    	    				+ "rating_details.rating, restaurant_details.yelp_url, restaurant_details.estimated_price, restaurant.restaurant_id "
//    	    				+ "FROM restaurant, restaurant_details, bridge_table, rating_details "
//    	    				+ "WHERE restaurant.restaurant_id = restaurant_details.details_id "
//    	    				+ "AND restaurant.restaurant_id = bridge_table.restaurant_id "
//    	    				+ "AND restaurant.restaurant_id = rating_details.rating_id "
//    	    				+ "AND bridge_table.category_id LIKE '%" + searchReq + "%' "
//    	    				+ "ORDER BY rating_details.review_count DESC; ";
//    			}
//    			
//	    		
//	    		PreparedStatement p1 = c.prepareStatement(sql1);
//	    		ResultSet rs = p1.executeQuery();
//	    		int i = 0;
//	    		while (rs.next()) {
//	    			Restaurant r = new Restaurant();
//	    			restaurants.add(r);
//	    			restaurants.get(i).setImageUrl(rs.getString("image_url"));
//	    			restaurants.get(i).setName(rs.getString("restaurant_name"));
//	    			restaurants.get(i).setReviewCount(rs.getInt("review_count"));
//	    			restaurants.get(i).setRating(rs.getDouble("rating"));
//	    			restaurants.get(i).setPrice(rs.getString("estimated_price"));
//	    			restaurants.get(i).setUrl(rs.getString("yelp_url"));
//	    			restaurants.get(i).setId(rs.getString("restaurant_id"));
//	    			i++;
//	    		}
//	    		
//	    		request.setAttribute("allRestaurants", restaurants);
//	    		request.setAttribute("gSearch", searchReq);
//	    		request.setAttribute("searchSelect", nOrG);
//	    	}
//    		else if (nOrG.equals("Name")) {
//    			String sql1 = "";
//    			
//    			if (sortCriteria.equals("Price")) {
//    				sql1 = "SELECT DISTINCT restaurant.restaurant_name, restaurant_details.image_url, rating_details.review_count, "
//    	    				+ "rating_details.rating, restaurant_details.yelp_url, restaurant_details.estimated_price, restaurant.restaurant_id "
//    	    				+ "FROM restaurant, restaurant_details, bridge_table, rating_details "
//    	    				+ "WHERE restaurant.restaurant_id = restaurant_details.details_id "
//    	    				+ "AND restaurant.restaurant_id = bridge_table.restaurant_id "
//    	    				+ "AND restaurant.restaurant_id = rating_details.rating_id "
//    	    				+ "AND restaurant.restaurant_name LIKE '%" + searchReq + "%' "
//    	    				+ "ORDER BY restaurant_details.estimated_price ASC; ";
//    			}
//    			else if (sortCriteria.equals("Rating")) {
//    				sql1 = "SELECT DISTINCT restaurant.restaurant_name, restaurant_details.image_url, rating_details.review_count, "
//    	    				+ "rating_details.rating, restaurant_details.yelp_url, restaurant_details.estimated_price, restaurant.restaurant_id "
//    	    				+ "FROM restaurant, restaurant_details, bridge_table, rating_details "
//    	    				+ "WHERE restaurant.restaurant_id = restaurant_details.details_id "
//    	    				+ "AND restaurant.restaurant_id = bridge_table.restaurant_id "
//    	    				+ "AND restaurant.restaurant_id = rating_details.rating_id "
//    	    				+ "AND restaurant.restaurant_name LIKE '%" + searchReq + "%' "
//    	    				+ "ORDER BY rating_details.rating DESC; ";
//    			}
//    			else if (sortCriteria.equals("ReviewCount")) {
//    				sql1 = "SELECT DISTINCT restaurant.restaurant_name, restaurant_details.image_url, rating_details.review_count, "
//    	    				+ "rating_details.rating, restaurant_details.yelp_url, restaurant_details.estimated_price, restaurant.restaurant_id "
//    	    				+ "FROM restaurant, restaurant_details, bridge_table, rating_details "
//    	    				+ "WHERE restaurant.restaurant_id = restaurant_details.details_id "
//    	    				+ "AND restaurant.restaurant_id = bridge_table.restaurant_id "
//    	    				+ "AND restaurant.restaurant_id = rating_details.rating_id "
//    	    				+ "AND restaurant.restaurant_name LIKE '%" + searchReq + "%' "
//    	    				+ "ORDER BY rating_details.review_count DESC; ";
//    			}
//    			
//    			
//	    		
//	    		PreparedStatement p1 = c.prepareStatement(sql1);
//	    		ResultSet rs = p1.executeQuery();
//	    		int i = 0;
//	    		
//	    		while (rs.next()) {
//	    			Restaurant r = new Restaurant();
//	    			restaurants.add(r);
//	    			restaurants.get(i).setImageUrl(rs.getString("image_url"));
//	    			restaurants.get(i).setName(rs.getString("restaurant_name"));
//	    			restaurants.get(i).setReviewCount(rs.getInt("review_count"));
//	    			restaurants.get(i).setRating(rs.getDouble("rating"));
//	    			restaurants.get(i).setPrice(rs.getString("estimated_price"));
//	    			restaurants.get(i).setUrl(rs.getString("yelp_url"));
//	    			restaurants.get(i).setId(rs.getString("restaurant_id"));
//	    			i++;
//	    		}
//	    		request.setAttribute("allRestaurants", restaurants);
//	    		request.setAttribute("gSearch", searchReq);
//	    		request.setAttribute("searchSelect", nOrG);
//
//    		}
//    			
//    	} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    	
//    	    	
//    	
//    	RequestDispatcher requestDispatcher = request
//	            .getRequestDispatcher("search.jsp");
//	    requestDispatcher.include(request, response);
//    }
//
//    /**
//     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//     *      response)
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // TODO Auto-generated method stub
//        doGet(request, response);
//    }
//}