package Util;


import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.reflect.TypeToken;

/**
 * A class that pretends to be the Yelp API
 */
public class BathroomDataParser {
    private static Boolean ready = false;
    private static Bathroom[] mBathrooms;

    /**
     * Initializes the DB with json data
     *
     * @param responseString the json string
     * @throws ClassNotFoundException 
     */
    public static void Init(String responseString) throws ClassNotFoundException {
        if (ready) {
            return;
        }
        try {
            String url = "jdbc:mysql://localhost:3306/Flushr_DB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //TODO check if you've done the initialization
            try {
            	Connection conn = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);
                // First read the json file, restaurant_data.json
                Gson gson = new Gson();
                ready = true;
                try {
        			// read in the JSON file, but catch appropriate exception if
        			// the file can't be read or it has bad inputs
                	 mBathrooms = gson.fromJson(responseString, Bathroom[].class);
                	 
                	  
                	 String sql_bathroom = "INSERT INTO Bathroom (bathroom_name, bathroom_location, image_url) VALUES (?,?,?)";
                	 String sql_rating = "INSERT INTO Rating (overall_rating, cleanliness, accessibility, wait_time, bathroom_id) VALUES (?,?,?,?,?)";
                	 String sql_user = "INSERT INTO User (email, name, password) VALUES (?,?,?)";
                	//String sql_bridge = "INSERT INTO bathroom_bookmarks (category_id, restaurant_id) VALUES (?,?)";
                	 
                     //TODO iterate the businessHelper array and insert every business into the DB
                	 
                     for(Bathroom bathroom : mBathrooms) {
                    	 
                    	 //Bathroom
                    	 PreparedStatement ps = conn.prepareStatement(sql_bathroom, Statement.RETURN_GENERATED_KEYS);
                    	 ps.setString(1, bathroom.getBathroomName());
                    	 ps.setString(2, bathroom.getBathroomLocation());
                    	 ps.setString(3, bathroom.getImage());
                    	 ps.executeUpdate(); 
                    	 

                  	   	//Rating
                  		PreparedStatement ps2 = conn.prepareStatement(sql_rating, Statement.RETURN_GENERATED_KEYS);
                  	   	ps2.setDouble(1, bathroom.getRating());
                  	   	ps2.setDouble(2, bathroom.getCleanliness());
                  	   	ps2.setDouble(3, bathroom.getAccessibility());
                  	   	ps2.setDouble(4, bathroom.getWaitTime());
                  	   	
	                   	ResultSet bathKey = ps.getGeneratedKeys();
	                   	while(bathKey.next()){
	                   		ps2.setString(5, bathKey.getString(1));
	                   	}
	                   	ps2.executeUpdate(); 
                  	   	

                     } 
                }
        		catch (JsonSyntaxException e) {
        			System.out.println(e.getMessage());
        			System.out.println("The file " + Constant.FileName + " is not correctly formatted.\n");
        		}
            }
            catch(SQLException ex) {
            	System.out.println("SQLException: " + ex.getMessage());
            }
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    
    }

    /**
     * @param keyWord    the search keyword
     * @param sort       the sort option (price, review count, rating)
     * @param searchType search in category or name
     * @return the list of business matching the criteria
     */
    public static ArrayList<Bathroom> getBathrooms(String keyWord, String sort, String filter) {
        ArrayList<Bathroom> bathrooms = new ArrayList<Bathroom>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Flushr_DB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);

            ResultSet rs = null;
            String sql = "";
            
            if(filter.contentEquals("Name")) {
            	sql = "SELECT Bathroom.bathroom_name, Bathroom.bathroom_id, Rating.rating_id, Rating.bathroom_id, Rating.overall_rating "
            			+ "FROM Bathroom, Rating "
            			+ "WHERE Rating.bathroom_id = Bathroom.bathroom_id "
            			+ "AND LOWER(Bathroom.bathroom_name) LIKE LOWER('" + "%" + keyWord+ "%') ";
            }
            else if(filter.contentEquals("Location")) {
            	sql = "SELECT Bathroom.bathroom_name, Bathroom.bathroom_location, Bathroom.bathroom_id, Rating.rating_id, Rating.bathroom_id, Rating.overall_rating "
            			+ "FROM Bathroom, Rating "
            			+ "WHERE Rating.bathroom_id = Bathroom.bathroom_id "
            			+ "AND LOWER(Bathroom.bathroom_location) LIKE LOWER('" + "%" + keyWord+ "%') ";        	
            }
            
            if(sort.contentEquals("Rating")) {
            	sql += "ORDER BY Rating.overall_rating DESC";  
            }
            else if(sort.contentEquals("Cleanliness")) {
            	sql += "ORDER BY Rating.cleanliness DESC";  
            }
            else if(sort.contentEquals("Accessibility")) {
            	sql += "ORDER BY Rating.accessibility DESC";  
            }
            else if(sort.contentEquals("Wait Time")) {
            	sql += "ORDER BY Rating.wait_time ASC";  
            }
            
    		PreparedStatement ps = conn.prepareStatement(sql);
    		rs = ps.executeQuery();
    		
            	
            while(rs.next()) {
            	String name = rs.getString("bathroom_name");
            	for(Bathroom bath : mBathrooms) {
            		if(bath.getBathroomName().equalsIgnoreCase(name)) {
            			bathrooms.add(bath);
            		}
            	}
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bathrooms;

    }
}

//Code adapted from https://stackoverflow.com/questions/23070298/get-nested-json-object-with-gson-using-retrofit
class BathroomDeserializer implements JsonDeserializer<BathroomWrapper> {
    @Override
    public BathroomWrapper deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonElement content = je.getAsJsonObject();
        return new Gson().fromJson(content, BathroomWrapper.class);
    }
}
