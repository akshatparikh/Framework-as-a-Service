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
   
   
  <body class="be-splash-screen" style="background-image: url(adminResources/images/pattern.png);">
    <div class="be-wrapper be-login">
    
      <div class="be-content">
      
        <div class="main-content container-fluid">
        
          <div class="splash-container">
          
            <div class="card card-border-color card-border-color-primary">
            
              <div class="card-header"><img class="logo-img" src="adminResources/images/logo.png" alt="logo" width="{conf.logoWidth}" height="27"><span class="splash-description">Please enter your user information.</span></div>
              
              <div class="card-body">
              
  			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>              
                
                <form  method="post" action="j_spring_security_check">
                  <div class="login-form">
                    <div class="form-group">
                      <input class="form-control" name="username"  id="username" type="text" placeholder="Email Id" autocomplete="off">
                    </div>
                    <div class="form-group">
                      <input class="form-control" name="password" id="password" type="password" placeholder="Password">
                    </div>
                    <div class="form-group row login-tools">
                      
                      <div class="col-6 login-forgot-password" style="text-align:left"><a href="/enterEmail.html">Forgot Password?</a></div>
                    </div>
                    <div class="form-group row login-submit"> 
                      <div class="col-6"><a class="btn btn-secondary btn-xl" data-dismiss="modal" href="/addUser.html">Register</a></div>
                      <div class="col-6"><input type="submit" class="btn btn-primary btn-xl" value="Sign in"></div>
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
  </body>
</html>