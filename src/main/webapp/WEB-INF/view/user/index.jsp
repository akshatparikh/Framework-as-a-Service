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
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/f.png">
    <title>FAAS</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/perfect-scrollbar.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/material-design-iconic-font.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/jquery-jvectormap-1.2.2.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/jqvmap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/app.css" type="text/css"/>
  </head>
  <body>
    <div class="be-wrapper be-fixed-sidebar">
      
      <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="menu.jsp"></jsp:include>     
      
      <div class="be-content">
        <div class="main-content container-fluid">
          <div class="row">
            <div class="col-12 col-lg-6 col-xl-3">
                        <div class="widget widget-tile">
	                          <div class="chart sparkline" id="spark1">
                          <canvas width="85" height="35" style="display: inline-block; width: 85px; height: 35px; vertical-align: top;"></canvas>
                          </div>
                          <div class="data-info">
                            <div class="desc">Total Projects</div>
                            <div class="value"><span class="indicator indicator-equal mdi mdi-chevron-right"></span>
                            <span class="number" data-toggle="counter" data-end="${countOfUser}">0</span>
                            </div>
                          </div>
                        </div>
            </div>
            <div class="col-12 col-lg-6 col-xl-3">
                        <div class="widget widget-tile">
                          <div class="chart sparkline" id="spark2"></div>
                          <div class="data-info">
                            <div class="desc">List of complaints</div>
                            
                            <div class="value"><span class="indicator indicator-positive mdi mdi-chevron-up"></span><span class="number" data-toggle="counter" data-end="${countOfComplaint}">0</span>
                            </div>
                          </div>
                        </div>
            </div>
            <div class="col-12 col-lg-6 col-xl-3">
                        <div class="widget widget-tile">
                          <div class="chart sparkline" id="spark3"></div>
                          <div class="data-info">
                            <div class="desc">Pending Complaints</div>
                            <div class="value"><span class="indicator indicator-positive mdi mdi-chevron-up">
                            </span><span class="number" data-toggle="counter" data-end="${countOfPendingComplaint}">0</span>
                            </div>
                          </div>
                        </div>
            </div>
            <div class="col-12 col-lg-6 col-xl-3">
                        <div class="widget widget-tile">
                          <div class="chart sparkline" id="spark4"></div>
                          <div class="data-info">
                            <div class="desc">Resolved Complaints</div>
                            <div class="value"><span class="indicator indicator-negative mdi mdi-chevron-down"></span><span class="number" data-toggle="counter" data-end="${countOfSolvedComplaint}">0</span>
                            </div>
                          </div>
                        </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <div class="widget widget-fullwidth be-loading" style="background-image: url(/adminResources/images/bbb.jpg); background-repeat: no repeat;background-size: 1300px 900px">
                <div class="widget-head">
                <div class="widget-chart-container" style="font-family:FreeMono, monospace;">
                
					<span class="title">Steps to be followed by a user:</span><br>
					<div style="font-size: 17px; ">
					1). New users have to create an account to avail the advantage of the portal.<br><br>
					2). If the user has account, then he/she has to choose "Manage Project" tab from the side menu-bar. <br><br>
			&nbsp&nbsp&nbsp&nbsp	2.1).Here, user has to click on "Add Project" to create a new project. For ex.: E-Commerce System<br><br>
			&nbsp&nbsp&nbsp&nbsp	2.2).Under that, on "View Project" tab, user can see all his projects.<br><br>
					3). After creating a project, user has to add a specific module for which user needs to generate the code.<br><br>
			&nbsp&nbsp&nbsp&nbsp    3.1). Here, user has to click on "Add Module" to create a new module. For ex.: Login<br><br>
			&nbsp&nbsp&nbsp&nbsp	3.2). Under that, on "View Module" tab, user can see all his modules along with the project in which they belong.<br><br>
					4). After that, user has to click on "Add Form" tab where he has to provide necessary details for the module.<br><br>
		&nbsp&nbsp&nbsp&nbsp		4.1). User has to select a project and a module for which he wants the code.<br><br>
		&nbsp&nbsp&nbsp&nbsp		4.2). After that, user has to enter the name of the form which will be stored in the "path" attribute of the form tag.<br><br>
		&nbsp&nbsp&nbsp&nbsp		4.3). Then user has to enter form description for reference.<br><br>
		&nbsp&nbsp&nbsp&nbsp		4.4). Then in Form Field, user has to enter the Field Name he wants in his code <b>without putting a space in between the 
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  name</b>. For ex: username, address, gender.	<br><br>
		&nbsp&nbsp&nbsp&nbsp		4.5). Under that in Field Type user has to select the data-type for the field he enters. For now, we only provide 3 types 
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp		          "text", "textarea", "radio".<br><br>
		&nbsp&nbsp&nbsp&nbsp		4.6). Then user has to press "Add" button and his entered details will be displayed in the table below. <br><br>
		&nbsp&nbsp&nbsp&nbsp		4.7). In the last, user needs to submit the form by pressing "Submit" button.<br><br> 				
					5). Now, user can generate and download the code under the "Generate Code" section.<br><br> 
		&nbsp&nbsp&nbsp&nbsp 		5.1). Here user will see the list of projects for which he created a form.<br><br> 
		&nbsp&nbsp&nbsp&nbsp		5.2). User has to click on "Generate Code" for generating a code otherwise download will be failed.<br><br> 
		&nbsp&nbsp&nbsp&nbsp		5.3). After that, clicking on "Download" tab will download the code.<br><br> 
					<b>Note: At the time of importing a downloaded project, user has to create a package in "Project->src" of the same name as a folder because any IDE can (For ex: Eclipse) import 
   a folder, not a package.</b>
		
					</div> 
                  </div> 
                  
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    
    
    
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/perfect-scrollbar.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/app.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.flot.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.flot.pie.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.flot.time.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.flot.resize.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.flot.orderBars.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/curvedLines.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.flot.tooltip.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.sparkline.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/countUp.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery-ui.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.vmap.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.vmap.world.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      	//-initialize the javascript
      	App.init();
      	App.dashboard();
      
      });
    </script>
  </body>
</html>