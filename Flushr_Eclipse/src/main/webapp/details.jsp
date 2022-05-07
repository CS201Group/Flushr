<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Flushr</title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@700;800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&family=Nunito:wght@700;800&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://kit.fontawesome.com/adade898d1.js" crossorigin="anonymous"></script>

    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&family=Nunito:wght@700;800&display=swap" rel="stylesheet">
    <%@
		page import="java.util.ArrayList,Util.BathroomDataParser,Util.Bathroom"
    %>
  </head>

<%@page import="java.util.ArrayList,Util.BathroomDataParser,Util.Bathroom" %>

<body>
<!-- TODO -->

	 <div id="mainHeaderDiv">
        <div id="logo" onclick="location.href='main.jsp'">
          <p1 id="headerTitle">FLUSHR.</p1>
        </div>
        
        <div id="menuButtons">
            <button class="menuButton active" onclick="location.href='main.jsp'">back</button>
        </div>
    </div>
    
    
    <%Bathroom br = (Bathroom) request.getSession().getAttribute("selectedBathroom"); %>
    
    <script>
    function saveEntry() {
    	<%
    	
    	String currentSaved = (String) request.getSession().getAttribute("valuesStored"); 
    	if (currentSaved == null) {
    		request.getSession().setAttribute("valuesStored", "t");
    		request.getSession().setAttribute("idx", 1);
    	} else {
    		int index = (int) request.getSession().getAttribute("idx"); 
    		request.getSession().setAttribute(String.valueOf(index), true);
    		for (int i = 0; i < index; i++) {
    			System.out.println(request.getSession().getAttribute(String.valueOf(i)));
    		}
    	}
    	
    	
    	
    	%>
    }
    </script>
    
    <form method="POST" action="DetailsDispatcher">
	    <div id=detailsInfoDiv>
		    <div class="brImgDiv">
		    	<img class= "bathroomImg" alt="" src=<%out.write(br.getImage());%>">
		    </div>
		    <div class="detailsDiv">
		    	<h1 class="blueTitle detailsTitle"><%out.write(br.getBathroomName());%></h1>
		    	
		    	<div class="dInfoDiv">
			    	<h2 class="details">Location: <%out.write(br.getBathroomLocation());%></h2>
			    	<h2 class="details">Rating: <%out.write(String.valueOf(br.getRating())); %></h2>
			    	<h2 class="details">Accessibility: <%out.write(String.valueOf(br.getAccessibility()));%></h2>
			    	<h2 class="details">Cleanliness: <%out.write(String.valueOf(br.getCleanliness()));%></h2>
			    	<h2 class="details">Wait Time: <%out.write(String.valueOf(br.getWaitTime()));%></h2> 
		    	</div>
		    	
		    	<br><br><br><br><br><br>
		    	<button class="blueTitle saveBathroom" name="saveEntry" href="main.jsp">Save</button>
		    </div>
	    </div>
    </form>
		
		
		
</body>
</html>