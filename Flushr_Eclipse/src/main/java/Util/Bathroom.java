package Util;
public class Bathroom {
	public Bathroom(){
		
	}
	//bathroom
	private String bathroom_name;
	private String bathroom_location;
	private double overall_rating;
	private double cleanliness;
	private double accessibility;
	private double wait_time;
	private String image;

	
	public String getBathroomName() {
		return bathroom_name;
	}
	public String getBathroomLocation() {
		return bathroom_location;
	}
	
	public String getImage() {
		return image;
	}
	
	public double getRating() {
		return overall_rating;
	}
	
	public double getCleanliness() {
		return cleanliness;
	}
	
	public double getAccessibility() {
		return accessibility;
	}
	
	public double getWaitTime() {
		return wait_time;
	}
	
	


	public void setBathroomName(String name) {
		bathroom_name = name;
	}
	
	public void setBathroomLocation(String loc) {
		bathroom_location = loc;
	}
	
	public void setImage(String url) {
		image = url;
	}

	public void setRatingId(double rating) {
		overall_rating = rating;
	}
	
	public void setCleanliness(double c) {
		cleanliness = c;
	}
	
	public void setAccessibility(double a) {
		accessibility = a;
	}

	public void setWaitTime(double w) {
		wait_time = w;
	}
	
	
	

	

}
