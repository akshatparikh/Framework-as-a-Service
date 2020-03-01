<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="adminResources/images/logo-fav.png">
    <title>Beagle</title>
    <link rel="stylesheet" type="text/css" href="adminResources/css/perfect-scrollbar.css"/>
    <link rel="stylesheet" type="text/css" href="adminResources/css/material-design-iconic-font.min.css"/>
    <link rel="stylesheet" href="adminResources/css/app.css" type="text/css"/>
  </head>
   
   
  <body class="be-splash-screen">
    <div class="be-wrapper be-login">
    
      <div class="be-content">
      
        <div class="main-content container-fluid">
        
          <div class="splash-container">
          
            <div class="card card-border-color card-border-color-primary">
            
              <div class="card-header"><img class="logo-img" src="adminResources/images/logo.png" alt="logo" width="{conf.logoWidth}" height="27"><span class="splash-description">Please enter your user information.</span></div>
              
              <div class="card-body">
              
  			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>              
                
                <form  method="post" action="step2">
                  <div class="login-form">
                    <div class="form-group">
                      <input class="form-control" name="OTP"  id="otp" type="text" placeholder="Enter OTP" autocomplete="off">
                    </div>
                    <span id="otpSpn"></span>
                    <div class="form-group">
                      <input class="form-control" name="password"  id="password" type="text" placeholder="newPassword" autocomplete="off">
                    </div>
                    <span id="pwdSpn"></span>
                    
                    <div class="form-group">
                      <input class="form-control" name="confirmPassword"   id="confirmpassword"  type="text" placeholder="confirmPassword" autocomplete="off">
                    </div>
                    <span id="con_pwdSpn"></span>
                    
                    <div class="form-group row login-submit"> 
                      <div class="col-6"><input type="submit" class="btn btn-primary btn-xl" value="Change Password"></div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="adminResources/js/jquery.min.js" type="text/javascript"></script>
    <script src="adminResources/js/perfect-scrollbar.min.js" type="text/javascript"></script>
    <script src="adminResources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="adminResources/js/app.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      	//-initialize the javascript
      	App.init();
      });
    </script>
    
    <script type="text/javascript">
		
		var generatedOTP = <%=session.getAttribute("generatedOTP")%>;
		
		$("#otp").keyup(function(){
			
			
			
			if(generatedOTP == $("#otp").val()){
				$("#otpSpn").html("OTP Matched.");
				$("#otpSpn").css("color" , "green");
				$("#otpSpn").css("font-weight" , "bold");
				$("#calculate").attr("disabled" , false);
			}
			else{
				$("#otpSpn").html("Wrong OTP.");
				$("#otpSpn").css("color" , "red");
				$("#otpSpn").css("font-weight" , "bold");
				$("#calculate").attr("disabled" , true);
			}
			
		});
		
		
		$("#confirmpassword").keyup(function()
				{
					if($("#password").val() == $("#confirmpassword").val()){
						$("#con_pwdSpn").html("Password Matched.");
						$("#con_pwdSpn").css("color" , "green");
						$("#con_pwdSpn").css("font-weight" , "bold");
						$("#calculate").attr("disabled" , false);
					}
					else{
						$("#con_pwdSpn").html("Wrong Password.");
						$("#con_pwdSpn").css("color" , "red");
						$("#con_pwdSpn").css("color" , "red");
						$("#con_pwdSpn").css("font-weight" , "bold");
						$("#calculate").attr("disabled" , true);
						}
				});
		  

	/* 	 $("#input").keyup(function(){
			  $('#result').val(md5(input.value));
		  });
		  
		  $("#reinput").keyup(function(){
			 
			  if(($("#input").val() == $("#reinput").val()) && (generatedOTP == $("#otp").val())){
				 $("#calculate").attr("disabled" , false);
				 console.log("pwd matched");
			 } 
			 else{
				 $("#calculate").attr("disabled" , true);
				 console.log("pwd not matched");
			 }
		  }); */
		  
		
		</script>
  </body>
</html>