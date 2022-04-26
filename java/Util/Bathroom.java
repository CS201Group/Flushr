package Util;
public class Bathroom {
	public Bathroom(){
		
	}
	//bathroom
	private String bathroom_id;
	private String bathroom_location;
	
	public String getBathroomId() {
		return bathroom_id;
	}
	
	public String getBathroomLocation() {
		return bathroom_location;
	}
	
	public String setBathroomId(String id) {
		bathroom_id = id;
	}
	
	public String setBathroomLocation(String loc) {
		bathroom_location = loc;
	}

}
