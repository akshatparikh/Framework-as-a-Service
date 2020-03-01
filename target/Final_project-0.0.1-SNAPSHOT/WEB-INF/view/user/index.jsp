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
              <div class="widget widget-fullwidth be-loading">
                <div class="widget-head">
                  <div class="tools">
                    <div class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"><span class="icon mdi mdi-more-vert d-inline-block d-md-none"></span></a>
                      <div class="dropdown-menu" role="menu"><a class="dropdown-item" href="#">Week</a><a class="dropdown-item" href="#">Month</a><a class="dropdown-item" href="#">Year</a>
                        <div class="dropdown-divider"></div><a class="dropdown-item" href="#">Today</a>
                      </div>
                   
                  </div>
                  <div class="button-toolbar d-none d-md-block">
                  </div>
                </div>
                <div class="widget-chart-container">
                
					<span class="title">Steps to be followed by a user:</span><br>
					<div style="font-size: 14px">
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
		&nbsp&nbsp&nbsp&nbsp		4.4). Then in Form Field, user has to enter the Field Name he wants in his code <b>without putting a space in between the name</b>. For ex: username, address, gender.	<br><br>
		&nbsp&nbsp&nbsp&nbsp		4.5). Under that in Field Type user has to select the data-type for the field he enters. For now, we only provide 3 types "text", "textarea", "radio".<br><br>
		&nbsp&nbsp&nbsp&nbsp		4.6). Then user has to press "Add" button and his entered details will be displayed in the table below. <br><br>
		&nbsp&nbsp&nbsp&nbsp		4.7). In the last, user needs to submit the form by pressing "Submit" button.<br><br> 				
					5). Now, user can generate and download the code under the "Generate Code" section.<br><br> 
		&nbsp&nbsp&nbsp&nbsp 		5.1). Here user will see the list of projects for which he created a form.<br><br> 
		&nbsp&nbsp&nbsp&nbsp		5.2). User has to click on "Generate Code" for generating a code otherwise download will be failed.<br><br> 
		&nbsp&nbsp&nbsp&nbsp		5.3). After that, clicking on "Download" tab will download the code.<br><br> 
					<b>Note: At the time of importing a downloaded project, user has to create a package in "Project-->src" of the same name as a folder because any IDE can (For ex: Eclipse) import 
   <br> a folder, not a package.</b>
		
		
					</div> 
					
					                  
                  </div>
                </div>
                <div class="be-spinner">
                 
                </div>
              </div>
            </div>
          </div>
                    
          
        </div>
      </div>
      <nav class="be-right-sidebar">
        <div class="sb-content">
          <div class="tab-navigation">
            <ul class="nav nav-tabs nav-justified" role="tablist">
              <li class="nav-item" role="presentation"><a class="nav-link active" href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">Chat</a></li>
              <li class="nav-item" role="presentation"><a class="nav-link" href="#tab2" aria-controls="tab2" role="tab" data-toggle="tab">Todo</a></li>
              <li class="nav-item" role="presentation"><a class="nav-link" href="#tab3" aria-controls="tab3" role="tab" data-toggle="tab">Settings</a></li>
            </ul>
          </div>
          <div class="tab-panel">
            <div class="tab-content">
              <div class="tab-pane tab-chat active" id="tab1" role="tabpanel">
                <div class="chat-contacts">
                  <div class="chat-sections">
                    <div class="be-scroller-chat">
                      <div class="content">
                        <h2>Recent</h2>
                        <div class="contact-list contact-list-recent">
                          <div class="user"><a href="#"><img src="adminResources/images/avatar1.png" alt="Avatar">
                              <div class="user-data"><span class="status away"></span><span class="name">Claire Sassu</span><span class="message">Can you share the...</span></div></a></div>
                          <div class="user"><a href="#"><img src="adminResources/images/avatar2.png" alt="Avatar">
                              <div class="user-data"><span class="status"></span><span class="name">Maggie jackson</span><span class="message">I confirmed the info.</span></div></a></div>
                          <div class="user"><a href="#"><img src="adminResources/images/avatar3.png" alt="Avatar">
                              <div class="user-data"><span class="status offline"></span><span class="name">Joel King		</span><span class="message">Ready for the meeti...</span></div></a></div>
                        </div>
                        <h2>Contacts</h2>
                        <div class="contact-list">
                          <div class="user"><a href="#"><img src="adminResources/images/avatar4.png" alt="Avatar">
                              <div class="user-data2"><span class="status"></span><span class="name">Mike Bolthort</span></div></a></div>
                          <div class="user"><a href="#"><img src="adminResources/images/avatar5.png" alt="Avatar">
                              <div class="user-data2"><span class="status"></span><span class="name">Maggie jackson</span></div></a></div>
                          <div class="user"><a href="#"><img src="adminResources/images/avatar6.png" alt="Avatar">
                              <div class="user-data2"><span class="status offline"></span><span class="name">Jhon Voltemar</span></div></a></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="bottom-input">
                    <input type="text" placeholder="Search..." name="q"><span class="mdi mdi-search"></span>
                  </div>
                </div>
                <div class="chat-window">
                  <div class="title">
                    <div class="user"><img src="adminResources/images/avatar2.png" alt="Avatar">
                      <h2>Maggie jackson</h2><span>Active 1h ago</span>
                    </div><span class="icon return mdi mdi-chevron-left"></span>
                  </div>
                  <div class="chat-messages">
                    <div class="be-scroller-messages">
                      <div class="content">
                        <ul>
                          <li class="friend">
                            <div class="msg">Hello</div>
                          </li>
                          <li class="self">
                            <div class="msg">Hi, how are you?</div>
                          </li>
                          <li class="friend">
                            <div class="msg">Good, I'll need support with my pc</div>
                          </li>
                          <li class="self">
                            <div class="msg">Sure, just tell me what is going on with your computer?</div>
                          </li>
                          <li class="friend">
                            <div class="msg">I don't know it just turns off suddenly</div>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                  <div class="chat-input">
                    <div class="input-wrapper"><span class="photo mdi mdi-camera"></span>
                      <input type="text" placeholder="Message..." name="q" autocomplete="off"><span class="send-msg mdi mdi-mail-send"></span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="tab-pane tab-todo" id="tab2" role="tabpanel">
                <div class="todo-container">
                  <div class="todo-wrapper">
                    <div class="be-scroller-todo">
                      <div class="todo-content"><span class="category-title">Today</span>
                        <ul class="todo-list">
                          <li>
                            <label class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox" checked=""><span class="custom-control-label">Initialize the project</span>
                            </label>
                          </li>
                          <li>
                            <label class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox"><span class="custom-control-label">Create the main structure							</span>
                            </label>
                          </li>
                          <li>
                            <label class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox"><span class="custom-control-label">Updates changes to GitHub							</span>
                            </label>
                          </li>
                        </ul><span class="category-title">Tomorrow</span>
                        <ul class="todo-list">
                          <li>
                            <label class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox"><span class="custom-control-label">Initialize the project							</span>
                            </label>
                          </li>
                          <li>
                            <label class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox"><span class="custom-control-label">Create the main structure							</span>
                            </label>
                          </li>
                          <li>
                            <label class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox"><span class="custom-control-label">Updates changes to GitHub							</span>
                            </label>
                          </li>
                          <li>
                            <label class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox"><span class="custom-control-label" title="This task is too long to be displayed in a normal space!">This task is too long to be displayed in a normal space!							</span>
                            </label>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                  <div class="bottom-input">
                    <input type="text" placeholder="Create new task..." name="q"><span class="mdi mdi-plus"></span>
                  </div>
                </div>
              </div>
              <div class="tab-pane tab-settings" id="tab3" role="tabpanel">
                <div class="settings-wrapper">
                  <div class="be-scroller-settings"><span class="category-title">General</span>
                    <ul class="settings-list">
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" checked="" name="st1" id="st1"><span>
                            <label for="st1"></label></span>
                        </div><span class="name">Available</span>
                      </li>
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" checked="" name="st2" id="st2"><span>
                            <label for="st2"></label></span>
                        </div><span class="name">Enable notifications</span>
                      </li>
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" checked="" name="st3" id="st3"><span>
                            <label for="st3"></label></span>
                        </div><span class="name">Login with Facebook</span>
                      </li>
                    </ul><span class="category-title">Notifications</span>
                    <ul class="settings-list">
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" name="st4" id="st4"><span>
                            <label for="st4"></label></span>
                        </div><span class="name">Email notifications</span>
                      </li>
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" checked="" name="st5" id="st5"><span>
                            <label for="st5"></label></span>
                        </div><span class="name">Project updates</span>
                      </li>
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" checked="" name="st6" id="st6"><span>
                            <label for="st6"></label></span>
                        </div><span class="name">New comments</span>
                      </li>
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" name="st7" id="st7"><span>
                            <label for="st7"></label></span>
                        </div><span class="name">Chat messages</span>
                      </li>
                    </ul><span class="category-title">Workflow</span>
                    <ul class="settings-list">
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" name="st8" id="st8"><span>
                            <label for="st8"></label></span>
                        </div><span class="name">Deploy on commit</span>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </nav>
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