package Util;
public class Rating {
	public Rating(){
		
	}
	//rating
	private String bathroom_id;
	private int overall_rating;
	private int cleanliness;
	private int accessibility;
	private int wait_time;
	
	public String getBathroomId() {
		return bathroom_id;
	}
	
	public int getRating() {
		return overall_rating;
	}
	
	public int getCleanliness() {
		return cleanliness;
	}
	
	public int getAccessibility() {
		return accessibility;
	}
	
	public int getWaitTime() {
		return wait_time;
	}
	
	public void setBathroomId(String id) {
		bathroom_id = id;
	}
	
	public void setRatingId(int rating) {
		overall_rating = rating;
	}
	
	public void setCleanliness(int c) {
		cleanliness = c;
	}
	
	public void setAccessibility(int a) {
		accessibility = a;
	}

	public void setWaitTime(int w) {
		wait_time = w;
	}
}
