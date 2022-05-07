<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Flushr</title>

    <!----- BOOTSTRAP ----->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- GLOBAL STYLING -->
    <link rel="stylesheet" href="css/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@700;800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&family=Nunito:wght@700;800&display=swap" rel="stylesheet">

    <!-- RESPONSIVE MEDIA DESIGN -->
    <style type="text/css">
      #headingDiv {
          top: 50%;
          position: fixed;
          width: 80%;
        }
      #loginMenu {
          position: fixed;
          top: 40%;
        }
      @media screen and (max-width: 800px){
        #headingDiv {
          top: 30%;
          position: fixed;
          width: 80%;
        }
        #headingDivLogIn {
          top: 35%;
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
          top: 30%;
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

    <!-- JAVASCRIPT CONNECT TO SERVLETS -->
    <script>
      function deleteAllCookies() {
          var cookies = document.cookie.split(";");
    
          for (var i = 0; i < cookies.length; i++) {
              var cookie = cookies[i];
              var eqPos = cookie.indexOf("=");
              var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
              document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
          }
      }
    </script>
    <script>
      function trySignup(){
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "signup?signupEmail="+document.signupform.email.value + 
            "&signupName=" + document.signupform.name.value + 
            "&signupPassword=" + document.signupform.password.value);
        
        xhttp.onreadystatechange = function(){
          
          if(this.readyState == XMLHttpRequest.DONE){
            
            if(this.responseText == "success"){
              document.cookie="name=" + document.signupform.name.value
              window.location = "mainFeed.jsp";
            }
            else{
              document.getElementById("validateSignup").innerHTML = this.responseText;
            }
          }
          document.cookie="name=" + document.signupform.name.value
          window.location = "mainFeed.jsp";
        }
        xhttp.send();	
        return false;
      }
    </script>

  </head>
  <body>
      <div id="headingDiv">
        <h1 id="title">SIGN UP</h1>
        <h2 id="tagline">don't wanna sign up? continue without an account <a href="main.jsp">here</a>.</h2>
      </div>
      
    <!-- MANUAL SIGN-IN -->
    <div id="loginMenu" class="container">

      <form name="signupform" onSubmit="return trySignup()" method="POST" action="RegisterDispatcher2">

        <!-- Email -->  
        <div class="form-group row justify-content-center">
          <label for="name-id" class="loginText col-sm-12 text-center form-label-style">Name: <span class="text-danger">*</span></label>
          <div class="col-sm-12 col-md-8 col-lg-6">
            <input type="text" class="form-control" id="name-id" name="registerName">
                              <h3 id="name-error" class="invalid-feedback">Name is required.</h3>
          </div>
        </div>

        <!-- Username -->  
        <div class="form-group row justify-content-center">
          <label for="username-id" class="loginText col-sm-12 text-center form-label-style">Email: <span class="text-danger">*</span></label>
          <div class="col-sm-12 col-md-8 col-lg-6">
            <input type="text" class="form-control" id="email-id" name="registerEmail">
                              <h3 id="email-error" class="invalid-feedback">Email is required.</h3>
          </div>
        </div>

        <!-- Password -->
        <div class="form-group row justify-content-center">
          <label for="password-id" class="loginText col-sm-12 text-center form-label-style">Password: <span class="text-danger">*</span></label>
          <div class="col-sm-12 col-md-8 col-lg-6">
            <input type="password" class="form-control" id="password-id" name="registerPassword">
                              <h3 id="password-error" class="invalid-feedback">Password is required.</h3>
          </div>
        </div>

        <!-- Required Text -->
        <div class="row justify-content-center">
          <div class="col-sm-12 col-md-8 col-lg-6"> 
            <span class="text-danger font-italic">Required *</span>
          </div>
        </div>
        
        <!-- Signup Button -->
        <div class="row justify-content-center">
          <button id="submitButton" type="submit" class="btn btn-outline-dark btn-lg">SIGN UP</button>
        </div>
      </form>

    </div>

    <div id="padding"></div>


<!--
    <div id="my-signin2">
      <div id="googleLogIn" class="row">
        <div class="col-md-3">
          <a id="googleButton" class="btn btn-outline-dark" href="/users/googleauth" role="button" style="text-transform:none">
            <img width="20px" style="margin-bottom:0px; margin-right:5px" alt="Google sign-in" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png"/>SIGNUP WITH GOOGLE
          </a>
        </div>
      </div>
    </div>
-->
      
  </body>
</html>


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

<!-- Register Form:
form action="RegisterDispatcher" name="registerForm" id="registerForm" onsubmit="return confPwd();" method="GET" class="registerForm">
input type="email" id="registerEmail" name="registerEmail" required
input type="text" id="registerName" name="registerName" required />
input type="password" id="registerPW" name="registerPW" required />
input type="password" id="registerPWC" name="registerPWC" required />
input type="checkbox" id="termsAndConditions" name="termsAndConditions" value="TAC"> 
input type="submit" id="registerSubmit" value="&#xf234 Create Account" class="registerSubmit fa fa-user-plus" /> -->