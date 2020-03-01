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
    <link rel="stylesheet" type="text/css" href="adminResources/css/jquery-jvectormap-1.2.2.css"/>
    <link rel="stylesheet" type="text/css" href="adminResources/css/jqvmap.min.css"/>
    <link rel="stylesheet" type="text/css" href="adminResources/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="adminResources/css/app.css" type="text/css"/>
  </head>
  <body>
    <div class="be-wrapper be-fixed-sidebar">
      <jsp:include page="header1.jsp"></jsp:include>
      </div>
        <div class="main-content container-fluid" style="background-color: white">

          <div class="row">
            <div class="col-md-12">
              <div class="widget widget-fullwidth be-loading" style="background-image: url(adminResources/images/bbb.jpg); background-size: 1800px 1300px; height: 1000px">
                
                <div class="widget-chart-container"">
                  
                  <p style="font-size:25px "><center> <p style="font-size:150px; font-family:courier, monospace; padding-top: 80px">WHY US?</p></center></p> <br><br>
            
            
                  
              <p style="font-size:25px; font-family:FreeMono, monospace;line-height: 0.8">  <b style="font-size:100px;font-family:courier, monospace; ">C</b>  ODERS...Tired of writing same code again and again? We all know that it is very BORING to make different files again and again to execute single program.
                So, Code Generation can be used for small portions of code. Our portal helps you to generate various types of FORMS. 
                There are many types of forms in an application let's say Registration form, Login Form, FeedBack Form and many more.<br><br>
                The reason to use code generation are fundamentally four: productivity, simplification, portability and consistency.
               </p> <br>
                
                <p style="font-size:22px;font-family:FreeMono, monospace;line-height: 1.2">
               <span style='font-size:25px;font-family:FreeMono, monospace;'>&#8680; <u >Productivity</u></span><br><br>
				With code generation you write the generator once and it can be reused as many times as you need. 
				Providing the specific inputs to the generator and invoke it is significantly faster than writing the code manually, therefore code generation permits to save time.
				</p> <br>
				
				<p style="font-size:22px;font-family:FreeMono, monospace; line-height: 1.2">
				
				<span style='font-size:25px;'>&#8680; <u>Simplification</u></span><br><br>
				With code generation you generate your code from some abstract description. 
				It means that your source of truth becomes that description, not the code. 
				That description is typically easier to analyze and check compared with the whole generated code.
				</p> <br>
				
				<p style="font-size:22px;font-family:FreeMono, monospace; line-height: 1.2">
				
				<span style='font-size:25px;'>&#8680; <u>Portability</u></span><br><br>
				You have a process to generate code for spring framework. 
				You can also target multiple platforms at once.  
				You can use your own database without changing the code it can be MYSQL, oracle etc.
				You can configure your own database in xml file.
				</p> <br>
				
				<p style="font-size:22px;font-family:FreeMono, monospace; line-height: 1.2">
				<span style='font-size:25px;'>&#8680; <u>Consistency</u></span><br><br>
				With code generation you get always the code you expect. 
				The generated code is designed according to the same principles, the naming rule match, etc. 
				The code always works the way you expect, of course except in the case of bugs in the generator. 
				The quality of the code is consistent. 
				With code written manually instead you can have different developers use different styles and occasionally introduce errors even in the most repetitive code.
                </p><br><br>  
                
                 
                  <div id="main-chart" style="height: 0px;"></div>
                </div>
                
                <div class="be-spinner">
                  <svg width="40px" height="40px" viewBox="0 0 66 66" xmlns="http://-www.w3.org/2000/svg">
                    <circle class="circle" fill="none" stroke-width="4" stroke-linecap="round" cx="33" cy="33" r="30"></circle>
                  </svg>
                </div>
              </div>
            </div>
          </div>
          
    <script src="adminResources/js/jquery.min.js" type="text/javascript"></script>
    <script src="adminResources/js/perfect-scrollbar.min.js" type="text/javascript"></script>
    <script src="adminResources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="adminResources/js/app.js" type="text/javascript"></script>
    <script src="adminResources/js/jquery.flot.js" type="text/javascript"></script>
    <script src="adminResources/js/jquery.flot.pie.js" type="text/javascript"></script>
    <script src="adminResources/js/jquery.flot.time.js" type="text/javascript"></script>
    <script src="adminResources/js/jquery.flot.resize.js" type="text/javascript"></script>
    <script src="adminResources/js/jquery.flot.orderBars.js" type="text/javascript"></script>
    <script src="adminResources/js/curvedLines.js" type="text/javascript"></script>
    <script src="adminResources/js/jquery.flot.tooltip.js" type="text/javascript"></script>
    <script src="adminResources/js/jquery.sparkline.min.js" type="text/javascript"></script>
    <script src="adminResources/js/countUp.min.js" type="text/javascript"></script>
    <script src="adminResources/js/jquery-ui.min.js" type="text/javascript"></script>
    <script src="adminResources/js/jquery.vmap.min.js" type="text/javascript"></script>
    <script src="adminResources/jss/jquery.vmap.world.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      	//-initialize the javascript
      	App.init();
      	App.dashboard();
      
      });
    </script>
  </body>
</html>