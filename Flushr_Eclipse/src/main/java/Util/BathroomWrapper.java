package Util;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The class used to model a BathroomWrapper
 */

public class BathroomWrapper {
	
	public BathroomWrapper() {
		
	}
	private Bathroom[] bathroomWrapper;
	
	public Bathroom[] getBathrooms() {
		return this.bathroomWrapper;
	}	
	
	public void setBathrooms(Bathroom[] bathroomWrapper2) {
		this.bathroomWrapper = bathroomWrapper2;
	}
	
}


/*
public class BathroomWrapper {
    String id;
    
    String name;
    String image_url;
    
    String url;
    int review_count;
    String [] categories;
    
    String price;
    
    String [] address;
    String phone;

    float rating;
    
    Location location;
    
    public class Location {
    	String [] display_address;
    }
    
    public BathroomWrapper(String id, String name, String image_url, int review_count, String[] categories, String price, Location loc, String phone, float rating) {
        //TODO Initialization code
    	this.id = id;
    	this.name = name;
    	this.image_url = image_url;
    	this.review_count = review_count;
    	this.address = loc.display_address.clone();
    	
    }

    //TODO Add Getters (No Setters as the BathroomWrapper does not change in our assignment once constructed)
}
*/
//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
/*
public class BathroomWrapper{
	
	public class Category{
		@SerializedName("alias")
		@Expose
		 public String alias;
		@SerializedName("title")
		@Expose
		 public String title;
		}

		public class Coordinates{
			@SerializedName("latitude")
			@Expose
		 public double latitude;
			@SerializedName("longitude")
			@Expose
		 public double longitude;
		}

		public class Location{
			@SerializedName("address1")
			@Expose
			public String address1;
			@SerializedName("address2")
			@Expose
			public String address2;
			@SerializedName("address3")
			@Expose
			public Object address3;
			@SerializedName("city")
			@Expose
			public String city;
			@SerializedName("zip_code")
			@Expose
			public String zipCode;
			@SerializedName("country")
			@Expose
			public String country;
			@SerializedName("state")
			@Expose
			public String state;
			@SerializedName("display_address")
			@Expose
			public ArrayList<String> displayAddress;
		}
		*/
/*
 public String id;

 public String alias;
 public String name;
 public String image_url;
 public boolean is_closed;
 public String url;
 public int review_count;
 public ArrayList<Category> categories;
 public double rating;
 public Coordinates coordinates;
 public ArrayList<String> transactions;
 public String price;
 public Location location;
 public String phone;
 public String display_phone;
 public double distance;
 */
/*
 @SerializedName("id")
 @Expose
 public String id;
 @SerializedName("alias")
 @Expose
 public String alias;
 @SerializedName("name")
 @Expose
 public String name;
 @SerializedName("image_url")
 @Expose
 public String imageUrl;
 @SerializedName("is_closed")
 @Expose
 public Boolean isClosed;
 @SerializedName("url")
 @Expose
 public String url;
 @SerializedName("review_count")
 @Expose
 public Integer reviewCount;
 @SerializedName("categories")
 @Expose
 public ArrayList<Category> categories;
 @SerializedName("rating")
 @Expose
 public Float rating;
 @SerializedName("coordinates")
 @Expose
 public Coordinates coordinates;
 @SerializedName("transactions")
 @Expose
 public ArrayList<String> transactions;
 @SerializedName("price")
 @Expose
 public String price;
 @SerializedName("location")
 @Expose
 public Location location;
 @SerializedName("phone")
 @Expose
 public String phone;
 @SerializedName("display_phone")
 @Expose
 public String displayPhone;
 @SerializedName("distance")
 @Expose
 public Float distance;
 
 	public BathroomWrapper() {
 		
 	}
 	
 	public String getId() {
 		return id;
 	}
 	public String getName() {
 		return name;
 	}
 	public String getImageUrl() {
 		return imageUrl;
 	}
 	public String getUrl() {
 		return url;
 	}
 	public String getPhone() {
 		return phone;
 	}
 	public int getReviewCount() {
 		return reviewCount;
 	}
 	public String getPrice() {
 		return price;
 	}
 	public double getRating() {
 		return rating;
 	}
}

*/
