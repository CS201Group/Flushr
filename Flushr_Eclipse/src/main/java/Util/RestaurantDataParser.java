package Util;


import com.google.gson.*;
import com.google.gson.JsonSyntaxException;
import java.sql.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * A class that pretends to be the Yelp API
 */
public class RestaurantDataParser {
    private static Boolean ready = false;

    /**
     * Initializes the DB with json data
     *
     * @param responseString the Yelp json string
     */
    public static void Init(String responseString) {
        if (ready) {
            return;
        }
        Connection con = null;

        try {
           Class.forName("com.mysql.jdbc.Driver");
           String username = "root";
           String password = "lego.com";
           String url = "jdbc:mysql://localhost:3306/aadeshbajajassgt2";
           
           //TODO check if you've done the initialization
           try {
               con = DriverManager.getConnection(url, username, password);
           }
           catch(SQLException ex) {
               System.out.println("SQLException: " + ex.getMessage());
           }
       } 
       catch (Exception e) {
           e.printStackTrace();
       }
       ready = true;

       // First read the json file, restaurant_data.json
       Businesses b = readFile(responseString);

       // Get the restaurants array from business (i.e. getBusinesses()) 
       List<Restaurant> r = b.getBusinesses();
       
       
       try {
    	   //PreparedStatement p1 = con.prepareStatement("INSERT INTO category(category_id, category_name) values (?, ?)");
    	   PreparedStatement p2 = con.prepareStatement("INSERT INTO rating_details(rating_id, review_count, rating) values (?, ?, ?)");
    	   PreparedStatement p3 = con.prepareStatement("INSERT INTO restaurant(restaurant_id, restaurant_name, details_id, rating_id) values (?, ?, ?, ?)");
    	   PreparedStatement p4 = con.prepareStatement("INSERT INTO bridge_table(category_id, restaurant_id) values (?, ?)");
    	   PreparedStatement p5 = con.prepareStatement("INSERT INTO restaurant_details(details_id, image_url, "
    	   		+ "address, phone_no, estimated_price, yelp_url) values (?, ?, ?, ?, ?, ?)");
    	   
    	   for (int i = 0; i < r.size(); i++) {
    		   String displayStr = "";
    		   for (int j = 0; j < r.get(i).getCategories().size(); j++) {
    			   p4.setString(1, r.get(i).getCategories().get(j).getTitle());
            	   p4.setString(2, r.get(i).getId());
            	   
        		   int t4 = p4.executeUpdate();
    		   }
    		   
    		   for (int j = 0; j < r.get(i).getLocation().getDisplayAddress().size(); j++) {
    			   displayStr += r.get(i).getLocation().getDisplayAddress().get(j) + " ";
    		   }
    		   
    		   
    		   p2.setString(1, r.get(i).getId());
        	   p2.setInt(2,  r.get(i).getReviewCount());
        	   p2.setDouble(3, r.get(i).getRating());
        	   
        	   p3.setString(1, r.get(i).getId());
        	   p3.setString(2, r.get(i).getName());
        	   p3.setString(3, r.get(i).getId());
        	   p3.setString(4, r.get(i).getId());

        	   
        	   p5.setString(1, r.get(i).getId());
        	   p5.setString(2, r.get(i).getImageUrl());
        	   p5.setString(3, displayStr);
        	   p5.setString(4, r.get(i).getPhone());
        	   p5.setString(5, r.get(i).getPrice());
        	   p5.setString(6, r.get(i).getUrl());
        	   
        	   int t2 = p2.executeUpdate();
        	   int t3 = p3.executeUpdate();
        	   int t5 = p5.executeUpdate();
        	   
    	   }
	   } 
       catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	   }
	
    }

    public static Restaurant getBusiness(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //TODO return business based on id
        return null;
    }

    /**
     * @param keyWord    the search keyword
     * @param sort       the sort option (price, review count, rating)
     * @param searchType search in category or name
     * @return the list of business matching the criteria
     */
    
    private static Businesses readFile(String fileText) {
        Gson gson = new Gson();
        try {
            Businesses b = gson.fromJson(fileText, Businesses.class);
            return b;
        } 
        catch (JsonSyntaxException e) {
        	System.out.println("JsonSyntaxException: " + e.getMessage());       
        }
        catch (Exception e) {
        	System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
}

