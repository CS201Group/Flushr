<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta
	content="283359501208-9hlna4chq4c91v3mq37k04461tjd7djl.apps.googleusercontent.com"
	name="google-signin-client_id">
<title>Login / Register</title>
<script
	src="https://apis.google.com/js/client:platform.js?onload=renderButton"
	async defer>
</script>
<link href="https://fonts.googleapis.com" rel="preconnect">
<link crossorigin href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css2?family=Lobster&family=Roboto:wght@300&display=swap"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet" type="text/css">

<script crossorigin="anonymous"
	src="https://kit.fontawesome.com/3204349982.js"></script>
<script async defer src="https://apis.google.com/js/platform.js"></script>
<link rel="stylesheet" href="index.css">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet" type="text/css">
<script src="https://apis.google.com/js/api:client.js"></script>
<script> 

</script>
</head>

<body>

	


	<div style="display: flex;">
		<form name="loginForm" id="loginForm" method="post" class="loginForm">
			<br> <br>
			<h1>Login</h1>
			<label for="loginEmail">Email</label> <br> <input type="email" 
				id="loginEmail" name="loginEmail" required /> <br> <label
				for="loginPassword">Password</label> <br> <input
				type="password" id="loginPassword" name="loginPassword" required />
			<br> <input type="submit" id="regularSignIn"
				value="&#xf090 Sign In" class="fa-input fa-sign-in"
				formaction="LoginDispatcher" /> <br class="submissionBreak">
			<div id="gSignInWrapper" onclick="startApp">

				<div id="customBtn" class="customGPlusSignIn">
					<i id="customIcon" class="fa fa-google icon-large"
						style="color: white; text-align: center;"></i> <span
						class="buttonText" style="color: white; width: 70%;">Sign
						in with Google</span>
				</div>
			</div>
			<div id="name"></div>
			<script>
				startApp();
			</script>
		</form>



		<form action="RegisterDispatcher" name="registerForm"
			id="registerForm" onsubmit="return confPwd();" method="GET"
			class="registerForm">
			<h1>Register</h1>

			<label for="registerEmail">Email</label> <br> <input
				type="email" id="registerEmail" name="registerEmail" required /> <br>

			<label for="registerName">Name</label><br> <input type="text"
				id="registerName" name="registerName" required /><br> <label
				for="registerPW">Password</label><br> <input type="password"
				id="registerPW" name="registerPW" required /><br> <label
				for="registerPWC">Confirm Password</label> <br> <input
				type="password" id="registerPWC" name="registerPWC" required /> <br>

			<input type="checkbox" id="termsAndConditions"
				name="termsAndConditions" value="TAC"> <label
				id="checkboxLabel" for="termsAndConditions">I have read and
				agree to all terms and conditions of SalEats</label><br> <input
				type="submit" id="registerSubmit" value="&#xf234 Create Account"
				class="registerSubmit fa fa-user-plus" />

		</form>
		<div style="clear: both"></div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

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

<!-- Register Form:
form action="RegisterDispatcher" name="registerForm" id="registerForm" onsubmit="return confPwd();" method="GET" class="registerForm">
input type="email" id="registerEmail" name="registerEmail" required
input type="text" id="registerName" name="registerName" required />
input type="password" id="registerPW" name="registerPW" required />
input type="password" id="registerPWC" name="registerPWC" required />
input type="checkbox" id="termsAndConditions" name="termsAndConditions" value="TAC"> 
input type="submit" id="registerSubmit" value="&#xf234 Create Account" class="registerSubmit fa fa-user-plus" /> -->