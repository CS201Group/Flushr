import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import javax.servlet.ServletConfig;

import java.util.*;

import Util.*;
import java.util.List;


import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.http.*;
import java.io.*;


/**
 * Servlet implementation class LogoutDispatcher
 */
@WebServlet("/DetailsDispatcher")
public class DetailsDispatcher extends HttpServlet {
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DetailsDispatcher() {
    	super();
    }
   
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    	HttpSession session=request.getSession(false);  
    	Bathroom bRoom = (Bathroom) session.getAttribute("selectedBathroom"); 
    	String location = bRoom.getBathroomLocation();
    	String rating = String.valueOf(bRoom.getRating());
    	String accessibility = String.valueOf(bRoom.getAccessibility());
    	String cleanliness = String.valueOf(bRoom.getCleanliness());
    	String waitTime = String.valueOf(bRoom.getWaitTime());
    	String img = bRoom.getImage();
    			
    	request.setAttribute("bathImg", img);
    	request.setAttribute("bathLoc", location);
    	request.setAttribute("bathRating", rating);
    	request.setAttribute("bathAcc", accessibility);
    	request.setAttribute("bathClean", cleanliness);
    	request.setAttribute("bathWt", waitTime);
 
    	
    	try {
			request.getRequestDispatcher("details.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	//Send to doPost
    	
        doGet(request, response);
    }

}
