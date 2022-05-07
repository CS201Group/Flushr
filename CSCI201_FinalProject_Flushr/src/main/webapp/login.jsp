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
      <h2 id="tagline">don't have an account? go back <a href=index.jsp>here</a>.</h2>
    </div>


    <!-- MANUAL LOG-IN -->
    <div id="loginMenu" class="container">

      <form method="POST" action="LoginDispatcher2">

        <!-- Username -->  
        <div class="form-group row justify-content-center">
          <label for="email-id" class="loginText col-sm-12 text-center form-label-style">Email: <span class="text-danger">*</span></label>
          <div class="col-sm-12 col-md-8 col-lg-6">
            <input type="text" class="form-control" id="email-id" name="email">
                              <h3 id="name-error" class="invalid-feedback">Email is required.</h3>
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
          <button id="submitButton" type="submit" formaction="LoginDispatcher2" class="btn btn-outline-dark btn-lg">LOG IN</button>
        </div>
      </form>

    </div>

    <div id="padding"></div>
  
  </body>
</html>



<script>
function confPwd() {
	var pw1 = document.getElementById("registerPW").value;
	//debug: alert(pw1);
	var pw2 = document.getElementById("registerPWC").value;
	//debug: alert(pw2);
	if (pw1 != pw2) {
		alert("Passwords do not match.");
		return false;
	}
	var tAC = document.getElementById("termsAndConditions").checked;
	if (!tAC) {
		alert("Please agree to Terms and Conditions to continue registration.");
		return false;
	}
	return true;
}

var googleUser = {};
var startApp = function() {
	gapi
			.load(
					'auth2',
					function() {
						// Retrieve the singleton for the GoogleAuth library and set up the client.
						auth2 = gapi.auth2
								.init({
									client_id : '283359501208-9hlna4chq4c91v3mq37k04461tjd7djl.apps.googleusercontent.com',
									cookiepolicy : 'single_host_origin',

								});
						attachSignin(document.getElementById('customBtn'));
					});

};

function attachSignin(element) {
	console.log(element.id);
	auth2.attachClickHandler(
					element,
					{},
					function(googleUser) {
						
						document.cookie = "username="
								+ googleUser.getBasicProfile().getName()
										.split(" ")[0];
						var url = "http://localhost:8080/csci201_assignment2_aadeshbajaj/GoogleDispatcher?"
								+ "google="
								+ encodeURIComponent("yes")
								+ "&name-register="
								+ encodeURIComponent(googleUser.getBasicProfile().getName())
								+ "&email-register="
								+ encodeURIComponent(googleUser.getBasicProfile().getEmail())
								+ "&password-register=&confirm-password-register=&terms-checkbox=on";
						window.location.replace(url);
					}, function(error) {
						alert(JSON.stringify(error, undefined, 2));
					});
}
</script>


<% 
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != "good" && errorMessage != "" && errorMessage != null) {
		out.println(
		"<div style = 'margin-bottom: 5px; padding:20px 0; text-align:center; background-color:#fdcddc; width=100%;'>"
				+ errorMessage + "</div>");
	} else {
		errorMessage = "";
	}
%>

<!-- LoginForm
form name="loginForm" id="loginForm" method="post" class="loginForm"
input type="email" id="loginEmail" name="loginEmail" required 
input type="password" id="loginPassword" name="loginPassword" required 
input type="submit" id="regularSignIn" value="&#xf090 Sign In" class="fa-input fa-sign-in" 
formaction="LoginDispatcher"
div id="gSignInWrapper" onclick="startApp">]
div id="customBtn" class="customGPlusSignIn"
i id="customIcon" class="fa fa-google icon-large" style="color: white; text-align: center;"
script: startApp(); -->