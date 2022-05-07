import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonParseException;

import Util.Bathroom;
import Util.BathroomDataParser;
//import Util.BathroomDataParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Servlet implementation class SearchDispatcher
 */

@WebServlet("/SearchDispatcher2")
public class SearchDispatcher2 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public SearchDispatcher2() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        ServletContext servletContext = getServletContext();
        // TODO get json file as stream, Initialize FakeYelpAPI by calling its initalize
        // method
        InputStream istream = servletContext.getResourceAsStream(Util.Constant.FileName);
        Scanner sc = new Scanner(istream);
        sc.useDelimiter("\\A");

        String result = "";
        while(sc.hasNext())
        	result += sc.next();
        
        System.out.println("INIt RAN");
        try {
			BathroomDataParser.Init(result);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String searchType = request.getParameter("feedSearch");
    	
    	String filterCriteria = request.getParameter("filterCriteria");

    	String sortCriteria = request.getParameter("sortCriteria");
    	
    	System.out.println("keyword: " + searchType);
    	System.out.println("filter: " + filterCriteria);
    	System.out.println("sort: " + sortCriteria);

    
    	
    	if(searchType == null)
    		searchType = "";
    	if(filterCriteria == null)
    		filterCriteria = "Name";
    	if(sortCriteria == null)
    		sortCriteria = "Rating";

    	ArrayList<Bathroom> results = BathroomDataParser.getBathrooms(searchType, sortCriteria, filterCriteria);
    	
    	for( Bathroom bath: results) {
    		System.out.println("name:" + bath.getBathroomName());
    		System.out.println("location: " + bath.getBathroomLocation());
    		System.out.println("rating:" + bath.getRating());
    		System.out.println("accessibility: " + bath.getAccessibility());
    		System.out.println("cleanliness:" + bath.getCleanliness());
    		System.out.println("wait_time: " + bath.getWaitTime());
    		
    		System.out.println();
    		
    	}	
    		
    		request.setAttribute("bathroomResults", results);
        	request.getRequestDispatcher("main.jsp").forward(request, response);
    	}

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}