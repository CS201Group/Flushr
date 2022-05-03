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
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&family=Nunito:wght@700;800&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://kit.fontawesome.com/adade898d1.js" crossorigin="anonymous"></script>

    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&family=Nunito:wght@700;800&display=swap" rel="stylesheet">
  </head>
  <body>
    <div id="mainHeaderDiv">
        <div id="logo">
          <p1 id="headerTitle">FLUSHR.</p1>
          
        </div>
        <div id="menuButtons">
            <button class="menuButton">saved</button>
            <button class="menuButton active">search</button>
            <button class="menuButton">profile</button>
        </div>
    </div>
      <form>
        <div id="mapDiv">
            <a id="map"></a>

            <div class="yellowButton" style="margin-top: 1.5%;">
                <div id="mainSearchDiv">
                    <button id="feedSearchButton" style="background-color: #FDCA40;"> 
                      <i class="fa-solid fa-magnifying-glass" style="font-size: 30px;"></i>
                    </button>
                    <input type="text" id="mainFeedSearch" name="feedSearch" placeholder="Search for nearby bathrooms..."/>
                </div>
            </div>
            
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

            <div id="resultsDiv" >
                <p id="resultsTitle" class="blueTitle">We found the best bathrooms for you.</p>
            </div>

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