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
    
  </head>
  
  <body>
      <!-- Header -->
    <div id="mainHeaderDiv">
        <div id="logo" onclick="location.href='main.jsp'">
          <p1 id="headerTitle">FLUSHR.</p1>
        </div>
        
        <div id="menuButtons">
            <button class="menuButton" onclick="location.href='saved.jsp'">saved</button>
            <button class="menuButton active" onclick="location.href='main.jsp'">search</button>
            <button class="menuButton" onclick="location.href='profile.jsp'">profile</button>
        </div>
    </div>


    <form action="SearchDispatcher2">
      
    <div id="googleMap" style="width:92%;height:400px;left:4%"></div>
    
	<script>
		
		var map;
		var service;
		var infowindow;

		function initMap() {
			  var usc = new google.maps.LatLng(34.0225093,-118.288733);
			  
			  infowindow = new google.maps.InfoWindow();

			  map = new google.maps.Map(
			      document.getElementById('googleMap'), {center: usc, zoom: 18});

			  var request = {
			    query: 'Grace Ford Salvatori Hall USC',
			    fields: ['name', 'geometry'],
			  };

			  var service = new google.maps.places.PlacesService(map);

			  service.textSearch(request, function(results, status) {
			    if (status === google.maps.places.PlacesServiceStatus.OK) {
			      for (var i = 0; i < results.length; i++) {
			        createMarker(results[i]);
			      }
			      map.setCenter(results[0].geometry.location);
			    }
			  });
			}
 			  
	</script>

	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSsz3irHfrMxknRHUs22qIQowp4vy919k&callback=initMap"></script>
            <!-- Search button -->
            <div class="yellowButton" style="margin-top: 1.5%;">
                <div id="mainSearchDiv">
                    <button id="feedSearchButton" style="background-color: #FDCA40;"> 
                      <i class="fa-solid fa-magnifying-glass" style="font-size: 30px;"></i>
                    </button>
                    <input type="text" id="mainFeedSearch" name="feedSearch" placeholder="Search for nearby bathrooms..."/>
                </div>
            </div>
            
            <!-- Sort by buttons -->
            <div id="sortDiv">
                <input list="sortCriteria" id="sortList" class="yellowButton" placeholder="Sort by...">
                <datalist id="sortCriteria">
                    <option value="A">
                    <option value="B">
                    <option value="C">
                    <option value="D">
                </datalist>
                <input list="filterCriteria" id="filterList" class="yellowButton" placeholder="Filter by...">
                <datalist id="filterCriteria">
                    <option value="A">
                    <option value="B">
                    <option value="C">
                    <option value="D">
                </datalist>
            </div>

            <!-- Results section -->
            <div id="resultsDiv" >
                <p id="resultsTitle" class="blueTitle">We found the best bathrooms for you.</p>
            </div>

            <!-- Results data -->
            <div id="resultsData">
                <div>
                    <p class="resultText">Ronald Tutor Hall (RTC)</p>
                </div>
                <div id="mainDescriptionDiv">
                    <div>
                        <i class="fa-solid fa-paper-plane"></i>
                        <p class="resultDist">0.1mi</p>
                    </div>
                    <div>
                        <i class="fa-solid fa-face-smile"></i>
                        <p class="resultRating">4.73/5</p>
                    </div>
                </div>
            </div>
            
        </div>
        
    </form>
    
    
      
  </body>
</html>
	
