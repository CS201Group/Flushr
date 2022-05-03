<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login to Flushr.</title>

    <!----- BOOTSTRAP ----->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!----- GLOBAL STYLING ----->
    <link rel="stylesheet" href="css/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@700;800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&family=Nunito:wght@700;800&display=swap" rel="stylesheet">

    <!-- RESPONSIVE MEDIA DESIGN -->
    <style type="text/css">
      @media screen and (max-width: 800px){
        #headingDivLogIn {
          top: 32%;
          position: fixed;
          margin:0;
          padding:0;
          width: 100%;
        }
        #title{
          font-size: 60px;
          line-height: 100%;
        }
        #tagline{
          line-height: 90%;
          font-size: 15px;
        }
        #loginMenu {
          position: fixed;
          top: 40%;
        }
        #submitButton {
          display: inline-block;
          align-items: center;
          justify-content: center;
          width: 80%;
        }
        #googleLogIn {
          top: 85%;
          margin: 0.25%;
        }
      }
    </style>

    <!----- GOOGLE SIGN-IN API CLIENT LIBRARY ----->
    <script src="https://accounts.google.com/gsi/client" async defer></script>

  </head>

  <body onload="deleteAllCookies()">

    <!-- HEADING -->
    <div id="headingDivLogIn">
      <h1 id="title">LOG IN</h1>
      <!-- GO BACK / CONTINUE AS GUEST -->
      <h2 id="tagline">don't have an account? go back <a href=landing.html>here</a>.</h2>
    </div>


    <!-- MANUAL LOG-IN -->
    <div id="loginMenu" class="container">

      <form action="login.html" method="POST">

        <!-- Username -->  
        <div class="form-group row justify-content-center">
          <label for="username-id" class="loginText col-sm-12 text-center form-label-style">Email: <span class="text-danger">*</span></label>
          <div class="col-sm-12 col-md-8 col-lg-6">
            <input type="text" class="form-control" id="username-id" name="email">
                              <h3 id="username-error" class="invalid-feedback">Email is required.</h3>
          </div>
        </div>

        <!-- Password -->
        <div class="form-group row justify-content-center">
          <label for="password-id" class="loginText col-sm-12 text-center form-label-style">Password: <span class="text-danger">*</span></label>
          <div class="col-sm-12 col-md-8 col-lg-6">
            <input type="password" class="form-control" id="password-id" name="password">
                              <h3 id="password-error" class="invalid-feedback">Password is required.</h3>
          </div>
        </div>

        <!-- Required Text -->
        <div class="row justify-content-center">
          <div class="col-sm-12 col-md-8 col-lg-6">
            <span class="text-danger font-italic">Required *</span>
          </div>
        </div>
        
        <!-- Log-In Button -->
        <div class="row justify-content-center">
          <button id="submitButton" type="submit" class="btn btn-outline-dark btn-lg">LOG IN</button>
        </div>
      </form>

    </div>

    <div id="padding"></div>


    <!-- GOOGLE LOG-IN BUTTON -->
    <div id="my-signin2">
      <div id="googleLogIn" class="row">
        <div class="col-md-3">
          <a id="googleButton" class="btn btn-outline-dark" href="/users/googleauth" role="button" style="text-transform:none">
            <img width="20px" style="margin-bottom:0px; margin-right:5px" alt="Google sign-in" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png"/>LOGIN WITH GOOGLE
          </a>
        </div>
      </div>
    </div>
    
      
  
  </body>
</html>