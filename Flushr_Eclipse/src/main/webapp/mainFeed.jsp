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
            <button class="menuButton">saved</button>
            <button class="menuButton active">search</button>
            <button class="menuButton">profile</button>
        </div>
    </div>
    <form>
      <div id="feedForm">
        <div id="searchDiv">
          <button id="feedSearchButton"> 
            <i class="fa-solid fa-magnifying-glass" id="searchIcon"></i>
          </button>
          <input type="text" id="feedSearch" name="feedSearch" placeholder="Search for nearby bathrooms..."/>
        </div>
      </div>
       
      <div id="feedDisplayHeader">
          <h1 id="feedSubHeader">Recently used</h1>
          <h1 id="feedSubHeader2">by people near you</h1>
      </div>
      <div>

      <!-- –––––––––––––––––––––NOT WORKING FOR SOME REASON––––––––––––––––––––– -->
      <!-- <div class="feedImgContainer">
        <img src="me10.jpg" class="feedImg"/>
      </div> -->
      <div id="placeHolderImgFeed"></div>

      <div class="feedDescription">
        <div class="feedDesRow1">
          <button class="brTitle">
            Ronald Tutor Hall (RTC)
          </button>
          <div class="feedDirectionIcon">
            <i class="fa-solid fa-paper-plane"></i>
            <h1>0.1 mi</h1>
          </div>
        </div>

        <div class="feedDesRow2">
          <h1 id="feedStars">4.7 stars</h1>

          <div class="feedWait">
            <h1 class="feedWaitFont">average wait time: </h1>
            <h1 class="feedWaitFont" style="padding-left: 10px;"> 1 min.</h1>
          </div>
        </div>  
      </div>
    </form>    
  </body>
</html>



