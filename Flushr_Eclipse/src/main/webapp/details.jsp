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
    
    
 <%  String bImg = (String) request.getAttribute("bathImg"); %>
    
    
    <form method="POST" action="DetailsDispatcher">
	    <div id=detailsInfoDiv>
		    <div class="brImgDiv">
		    	<img class= "bathroomImg" alt="" src=<%out.write(bImg);%>">
		    </div>
		    <div class="detailsDiv">
		    	<h1 class="blueTitle detailsTitle"><%%></h1>
		    	
		    	<div class="dInfoDiv">
			    	<h2 class="details">Location:<%%></h2>
			    	<h2 class="details">Rating: <%%></h2>
			    	<h2 class="details">Accessibility: <%%></h2>
			    	<h2 class="details">Cleanliness: <%%></h2>
			    	<h2 class="details">Wait Time: <%%></h2> 
		    	</div>
		    	<br><br><br><br><br><br>
		    	<button class="blueTitle saveBathroom" name="saveEntry" formaction="DetailsDispatcher">Save</button>
		    </div>
	    </div>
    </form>
		
		<%request.getSession().removeAttribute("selectedBathroom");
		request.getSession().invalidate();%>
		
</body>
</html>