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
import Util.RestaurantDataParser;

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
        
        //System.out.println(result);
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
    	System.out.println("kms2");
//    	String searchType = request.getParameter("search-dropdown");
//    	String keyWord = request.getParameter("search-text");
//    	String sort = request.getParameter("sort-by");
//    	if (sort != null && searchType != null && keyWord != null) {
//    		ArrayList<Bathroom> results = RestaurantDataParser.getRestaurants(keyWord, sort, searchType);
//        	request.setAttribute("results", results);
//        	request.getRequestDispatcher("search.jsp").forward(request, response);
//    	}
//    	else {
//    		
//    	}
//    	
    	
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