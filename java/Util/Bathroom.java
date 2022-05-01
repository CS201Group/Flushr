package Util;
public class Bathroom {
	public Bathroom(){
		
	}
	//bathroom
	private String bathroom_id;
	private String bathroom_location;
	private String image_url;
	
	public String getBathroomId() {
		return bathroom_id;
	}
	
	public String getBathroomLocation() {
		return bathroom_location;
	}
	
	public String getImageUrl() {
		return image_url;
	}
	
	public String setBathroomId(String id) {
		bathroom_id = id;
	}
	
	public String setBathroomLocation(String loc) {
		bathroom_location = loc;
	}
	
	public String setImageUrl(String url) {
		image_url = url;
	}

}
