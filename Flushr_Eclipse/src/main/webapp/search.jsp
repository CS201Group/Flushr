<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Lobster&family=Roboto:wght@300&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="search.css">
    <script src="https://kit.fontawesome.com/3204349982.js"
            crossorigin="anonymous"></script>

    <%@
		page import="java.util.ArrayList,Util.Restaurant"
    %>
</head>
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
	
	<form class="footerForm" action="SearchDispatcher2" method="GET">
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
		
		<% 
			ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) request.getAttribute("allRestaurants");
					if (restaurants != null) {%>
						<h1 id="resultsText">
							Results for <% 
							String r = (String) request.getAttribute("gSearch");
							
							out.print(r); %>
							 in <% String s = (String) request.getAttribute("searchSelect");
								out.print(s);  %>
						</h1>	
					<% for (int i = 0; i < restaurants.size(); i++) { %>
						<div id="container">
							<div id="imageArea">
								<img  id="image" src="<%out.write(restaurants.get(i).getImageUrl());%>" /> 
								
							</div>
							<div id="textArea">
								<div id="restName">
									<form action="DetailsDispatcher" method="GET">
										<button id="nameButton" type="submit">
											<%out.write(restaurants.get(i).getName());%>
										</button>
										<input type="hidden" name="detailsID" value=<%out.write(restaurants.get(i).getId()); %>>
									</form>
								</div>
								<div id="restText">
									<p>Price: <%
									if (restaurants.get(i).getPrice() != null) {
										out.write(restaurants.get(i).getPrice());
									}%></p>
									<p>Review Count: <%
										out.write(Integer.toString(restaurants.get(i).getReviewCount()));
									%></p>
									<p id="rating">Rating: 
									<%
									Double stars = (restaurants.get(i).getRating());
									for (int j = 0; j < stars;j++) {
										out.write("&starf;");
									}
									
									%></p>

									<a id=yelpLink href="<% out.write(restaurants.get(i).getUrl());%>">Yelp Link</a>
								</div>
							</div>
						</div>
					<%  }
					}
					%>

	
</body>
</html>