<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <script src="https://kit.fontawesome.com/adade898d1.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&family=Nunito:wght@700;800&display=swap" rel="stylesheet">
  </head>
  <body>
    <div id="headerDiv">
        <div id="logo">
          <p1 id="headerTitle">FLUSHR.</p1>
          <p1 id="slogan">for your bathroom needs.</p1>
        </div>
        <div id="menuButtons">
            <button class="menuButton" onclick="location.href='saved.jsp'">saved</button>
            <button class="menuButton active" onclick="location.href='main.jsp'">search</button>
            <button class="menuButton" onclick="location.href='profile.jsp'">profile</button>
        </div>
    </div>
    <p id="profileText2">A Page To Pass The Time While Waiting For The Bathroom</p>
    <form method="POST" action="RunSimulation">
      <div id="feedForm">
        <div id="searchDiv">
          <button id="feedSearchButton" type="submit" formaction="RunSimulation"> 
          	Run Bathroom Simulation
          </button>
        </div>
      </div>
       <% 
	String simulation = (String) request.getAttribute("simulation");
	if (simulation != "good" && simulation != "" && simulation != null) {
		out.println(
		"<div style = 'margin-bottom: 5px; padding:20px 0; text-align:center; background-color:#fdcddc; width=100%;'>"
				+ simulation + "</div>");
	} else {
		simulation = "";
	}
%>
		
      <!-- –––––––––––––––––––––NOT WORKING FOR SOME REASON––––––––––––––––––––– -->
      <!-- <div class="feedImgContainer">
        <img src="me10.jpg" class="feedImg"/>
      </div> -->
      
    </form>    
  </body>
</html>



