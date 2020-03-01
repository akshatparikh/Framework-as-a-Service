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
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/logo-fav.png">
    <title>Beagle</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/perfect-scrollbar.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/material-design-iconic-font.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/app.css" type="text/css"/>
 
 <script type="text/javascript">

function validateEmail()
{
	var a=document.getElementById("email");
	var errorMesaage = document.getElementById("errorMessage");
	
	var htp=new XMLHttpRequest();
	
	htp.onreadystatechange=function()
	{
		if(htp.readyState==4)
			{
			var data  = htp.responseText.trim();
			
			console.log(data.length);
			
				if (data == 'Duplicate') {
					a.value='';					
				
					errorMesaage.style.display="";
				}
				else{
					errorMesaage.style.display='none';
				}
			
			}
	}
	htp.open("get","validateEmail.html?email="+a.value,true);
	htp.send();
}
	
</script>
 
 
  </head>
   
  <body class="be-splash-screen">
    <div class="be-wrapper be-login be-signup">
      <div class="be-content">
        <div class="main-content container-fluid">
          <div class="splash-container sign-up">
            <div class="card card-border-color card-border-color-primary">
              <div class="card-header"><img class="logo-img" src="<%=request.getContextPath()%>/adminResources/images/logo.png" alt="logo" width="102" height="27"><span class="splash-description">Please enter your user information.</span></div>
              <div class="card-body">
              
              
              <%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
            	<%@taglib prefix="d" uri="http://java.sun.com/jstl/core_rt" %>
           
                <f:form action="updateProfile.html" method="post" modelAttribute="profileList"><span class="splash-title pb-4">Sign Up</span>
               	
               	
                  <div class="form-group">
                    <f:input onkeyup="validate()" class="form-control" onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122' id="firstName" path="firstName" type="text" placeholder="First Name" autocomplete="off" value="${i.firstName}"></f:input>
					<span style="color: red;display: none" id="sfn1">Enter First Name</span>
					<span style="color: red;display: none" id="sfn2">Enter Valid Name</span>
                  </div>
                  
                   <div class="form-group">
                    <f:input onkeyup="validate()" class="form-control" onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122' id="middleName" name="middleName" path="middleName" type="text" placeholder="Middle Name" autocomplete="off" value="${i.middleName}"></f:input>
					<span style="color: red;display: none" id="smn1">Enter Middle Name</span>
					<span style="color: red;display: none" id="smn2">Enter Valid Name</span>
                   </div>
                   
                   <div class="form-group">
                    <f:input onkeyup="validate()" class="form-control" onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122' id="lastName" name="lastName" path="lastName" type="text" placeholder="Last Name" autocomplete="off" value="${i.lastName}"></f:input>
					<span style="color: red;display: none" id="sln1">Enter Last Name</span>
					<span style="color: red;display: none" id="sln2">Enter valid name</span>
                   </div>
                   
                   <div class="form-group">
                    <f:input onkeyup="validate()" class="form-control" onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122' id="occupation" name="occupation" path="occupation" type="text" placeholder="Occupation" autocomplete="off" value="${i.occupation}"></f:input>
					<span style="color: red;display: none" id="soc1">Enter Occupation</span>
					<span style="color: red;display: none" id="soc2">Enter valid Occupation</span>
                   </div>
                   
                   <div class="form-group">
                    <f:input onkeyup="validate()" class="form-control" id="birthDate" name="birthDate" path="birthDate" type="date" placeholder="Birth Date" autocomplete="off" value="${i.birthDate}"></f:input>
					<span style="color: red;display: none" id="sdob">Enter your birth date</span>
                   </div>
                   
                  <center>
                  <div style="display: none;" id="errorMessage"><span style="color: red;">This email address is already exists</span></div>
                  </center>
                  
                  <div class="form-group">
                    <f:input onkeyup="validate()" class="form-control" id="email" name="loginVO.username" type="email" path="loginVO.username" placeholder="E-mail" onblur="validateEmail()" autocomplete="off" value="${i.loginVO.username}"></f:input>
					<span style="color: red;display: none" id="sem1">Enter Email</span>
					<span style="color: red;display: none" id="sem2">Email Address Not Valid</span>
                  </div>

                  <div class="form-group">
                    <f:input onkeyup="validate()" class="form-control" type="text" onkeypress='return event.charCode>=48 && event.charCode<=57' id="mobile" name="mobile" path="mobileNo" placeholder="Mobile Number" autocomplete="off" value="${i.mobileNo}"></f:input>
                	<span style="color: red;display: none" id="spn1">Enter phone number</span>
					<span style="color: red;display: none" id="spn2">Enter Valid number</span>
                  </div>
                  
                  <div class="form-group">
                    <f:textarea onkeyup="validate()" class="form-control" id="address" name="address" path="address" placeholder="Address" autocomplete="off" value="${i.address}"></f:textarea>
					<span style="color: red;display: none" id="sadd1">Enter Address</span>
					<span style="color: red;display: none" id="sadd2">Enter proper address</span>
                  </div>
                  
                  <div class="form-group row signup-password">
                    <div class="col-6">
                      <f:input onkeyup="validate()" class="form-control" name="password" id="password" path="loginVO.password" type="password"  placeholder="Password" value="${i.loginVO.password}"></f:input>
                      <span style="color: red;display: none" id="spwd1">Enter Password</span>
					  <span style="color: red;display: none" id="spwd2">Using Minimum 8 charcter</span>
                    </div>
                    <div class="col-6">
                      <input onkeyup="validate()" class="form-control" name="confirmPassword" id="confirmPassword" type="password"  placeholder="Confirm Password">
                      <span style="color: red;display: none" id="sconpwd1">Enter Confirm Password</span>
					  <span style="color: red;display: none" id="sconpwd2">Passwords Don't Match</span>
                    </div>
                  </div>
                  
                  
                  
                  <f:hidden path="userId" value="${i.userId}"/>
                  
                  <f:hidden path="loginVO.loginId" value="${i.loginVO.loginId}"/>
                  
                  <div class="form-group pt-2">
                    <button type="submit" onclick="validate()" class="btn btn-block btn-primary btn-xl" value="Sign Up">Sign up</button>
                  </div>
                  
                  <div class="title"><span class="splash-title pb-3">Or</span></div>
                  
                  <div class="form-group row social-signup pt-0">
                    <div class="col-6">
                      <button class="btn btn-lg btn-block btn-social btn-facebook btn-color" type="button"><i class="mdi mdi-facebook icon icon-left"></i>Facebook</button>
                    </div>
                    <div class="col-6">
                      <button class="btn btn-lg btn-block btn-social btn-google-plus btn-color" type="button"><i class="mdi mdi-google-plus icon icon-left"></i>Google Plus</button>
                    </div>
                  </div>
                  
                  <div class="form-group pt-3 mb-3">
                    <label class="custom-control custom-checkbox">
                      <input class="custom-control-input" type="checkbox"><span class="custom-control-label">By creating an account, you agree the <a href="#">terms and conditions</a>.</span>
                    </label>
                  </div>
                  
                </f:form>
              </div>
            </div>
            <div class="splash-footer">&copy; 2018 Your Company</div>
          </div>
        </div>
      </div>
    </div>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/perfect-scrollbar.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/app.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/signup.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      	//-initialize the javascript
      	App.init();
      });
      
    </script>
  </body>
</html>