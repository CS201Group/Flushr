<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Details</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Lobster&family=Roboto:wght@300&display=swap"
            rel="stylesheet">
    <script src="https://kit.fontawesome.com/3204349982.js"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="search.css">
</head>
<%
    //TODO perform search

    //TODO check if logged in
%>

<%@ page import="java.util.ArrayList,Util.*"%>

<body>
<!-- TODO -->

<nav>
			<span class ="salEatsBanner" id = "banner">
					<a href="index.jsp">SalEats!</a>
					
					<% String userName = null;
					userName = (String) session.getAttribute("userName");
 
 					if (userName != null) {
 						out.write("<span class='potentialUsername'> Hi " + userName + "! </span>");
 					}%>
			</span>
			
			
			
			<!--  MAKE SURE TO COPY THIS LOGOUT SHIT TO OTHER JSP PAGES -->
			
			
			<span class="homeAndLoginBanner">
				<a href="index.jsp">Home &nbsp;</a>
				<% 
				if (userName == null) {
					out.write("<a href='auth.jsp'/>&nbsp;" + "Login / Register" + "</a>");
				}
				else {
					out.write("<a href='LogoutDispatcher'/>&nbsp;" + "Logout" + "</a>");
				}%>
			</span>			
		</nav>
		
	<hr />
	
	<br>
	
	<form class="footerForm" action="SearchDispatcher" method="GET">
			<select name="searchSelect" id="category" required>
				<option value="Category">Category</option>
				<option value="Name">Name</option>	
			</select>
			
 			<input type="search" id="gsearch" name="gsearch" class="searchBar">

 			<button type="submit"><i class="fa fa-search"></i></button>
 			
 			<span class="formRadios">
 				
	 			<input type="radio" name="sortCriteria" value="Price" />
				<label for="Price">Price</label>
				
				<input type="radio" name="sortCriteria" value="ReviewCount"/>
				<label for="Review count">Review Count</label>
				
				<input type="radio" name="sortCriteria" value="Rating"/>
				<label for="Rating">Rating</label>
				
			</span>
		</form>
		<br><br><br><br><br><br>
		
<% Restaurant r = (Restaurant)request.getAttribute("detailsRest"); //System.out.println(r.getName()); %>
<% String s = r.getName(); out.print(s); %>
				 
			</h1>	
					
						<div>
							<div id="imageArea">
								<img  id="image" src="<%out.write(r.getImageUrl());%>" /> 
								
							</div>
							<div id="textArea">
								<div id="restText">
									<p>Address: 
									<%out.write(r.getLocation().getAddress1());%>
									</p>
				
									<p>
									<% out.write(r.getPhone());%>
									</p>
									
									<p >Categories: 
									<%
									for (int i = 0; i < r.getCategories().size(); i++) {
										if (i != r.getCategories().size() -1) {
											out.write(r.getCategories().get(i).getTitle() + ", ");
										}
										else {
											out.write(r.getCategories().get(i).getTitle());
										}
									}
									%>
									</p>
									<p>
									Price: <%out.write(r.getPrice());%>
									</p>

									<p>
									Rating: <% Double stars = (r.getRating());
									for (int j = 0; j < stars;j++) {
										out.write("&starf;");
									}
									%>
									</p>
								</div>
							</div>
						</div>
					
		
		
		
</body>
</html>