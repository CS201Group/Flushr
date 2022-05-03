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
  </head>
  <body>
    <!-- Header -->
    <div class="headerBar">
        <div id="logo" onclick="location.href='main.jsp'">
            <h1 id="headerTitle">FLUSHR.</h1>
        </div>
        <div id="menuButtons">
          <button class="menuButton active" onclick="location.href='saved.jsp'">saved</button>
          <button class="menuButton" onclick="location.href='main.jsp'">search</button>
          <button class="menuButton" onclick="location.href='profile.jsp'">profile</button>
        </div>
      </div> 
      
      <form>
        <!-- Saved section -->
        <div id="placeholder1">
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
        </div>
        <div id="placeholder2">
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
        </div>

        
      </form>


  </body>
</html>