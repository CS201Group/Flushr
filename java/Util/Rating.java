package Util;
public class Rating {
	public Rating(){
		
	}
	//rating
	private String bathroom_id;
	private String rating_id;
	private int overall_rating;
	private int cleanliness;
	private int accessibility;
	private int wait_time;
	
	public String getBathroomId() {
		return bathroom_id;
	}
	
	public String getRatingId() {
		return rating_id;
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
	
	public String setBathroomId(String id) {
		bathroom_id = id;
	}
	
	public String setRatingId(String id) {
		rating_id = id;
	}
	
	public int setCleanliness(int c) {
		cleanliness = c;
	}
	
	public int setAccessibility(int a) {
		accessibility = a;
	}

	public int setWaitTime(int w) {
		wait_time = w;
	}
}
