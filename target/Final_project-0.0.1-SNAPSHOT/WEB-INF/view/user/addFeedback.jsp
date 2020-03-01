<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/star-rating.css" type="text/css"/>
  </head>
  <body>
    <div class="be-wrapper">
       <jsp:include page="header.jsp"></jsp:include>
       <jsp:include page="menu.jsp"></jsp:include>
      <div class="be-content">
        <div class="page-head">
          <h2 class="page-head-title">Feedback</h2>
          <nav aria-label="breadcrumb" role="navigation">
            <ol class="breadcrumb page-head-nav">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item"><a href="#">Feedback</a></li>
              <li class="breadcrumb-item active">Add Feedback</li>
            </ol>
          </nav>
        </div>
        <div class="main-content container-fluid">
          
          <div class="row">
            <div class="col-md-12">
              <div class="card card-border-color card-border-color-primary">
                <div class="card-header card-header-divider">Add Feedback<span class="card-subtitle">Enter Feedback</span></div>
                <div class="card-body">
 
                   <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
 
                  <f:form action="/insertFeedback.html" modelAttribute="FeedbackVO" method="post">
                    <div class="form-group row">
                      <f:label class="col-12 col-sm-3 col-form-label text-sm-right" path="feedbackTitle"><b>Feedback Title</b></f:label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <f:input class="form-control" type="text" required="" placeholder="Title of your Feedback" path="feedbackTitle"/>
                      </div>
                    </div>
                   
                    <div class="form-group row">
                      <f:label class="col-12 col-sm-3 col-form-label text-sm-right" path="feedbackDescription"><b>Feedback Description</b></f:label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <f:input class="form-control" type="text" required="" data-parsley-minlength="10" placeholder="Describe your view" path="feedbackDescription"/>
                      </div>
                    </div>
                    
                     <div class="form-group row">
                      <f:label class="col-12 col-sm-3 col-form-label text-sm-right" path="feedbackDescription" required=""><b>Rating</b></f:label>
                      <div class="col-12 col-sm-8 col-lg-6">
                     
							  <div class="rating">
							    <input type="radio" id="star5" name="feedbackRating" value="5" class="radio-1" />
							    <label for="star5" class="star star-1" title="Excellent"></label>
							    <input type="radio" id="star4" name="feedbackRating" value="4" class="radio-2" />
							    <label for="star4" class="star star-2" title="Great"></label>
							    <input type="radio" id="star3" name="feedbackRating" value="3" class="radio-3" />
							    <label for="star3" class="star star-3" title="Average"></label>
							    <input type="radio" id="star2" name="feedbackRating" value="2" class="radio-4" />
							    <label for="star2" class="star star-4" title="Poor"></label>
							    <input type="radio" id="star1" name="feedbackRating" value="1" class="radio-5" />
							    <label for="star1" class="star star-5" title="Bad"></label>
							  </div>
					
                      </div>
                    </div>
                  
                    <div class="form-group row text-right">
                      <div class="col col-sm-10 col-lg-9 offset-sm-1 offset-lg-0">
                       <center>
                        <button class="btn btn-space btn-primary" type="submit">Submit</button>
                        <button class="btn btn-space btn-secondary">Cancel</button>
                       </center>
                      </div>
                    </div>
                  </f:form>
 
 
 
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
                          <div class="user"><a href="#"><img src="<%=request.getContextPath()%>/adminResources/images/avatar1.png" alt="Avatar">
                              <div class="user-data"><span class="status away"></span><span class="name">Claire Sassu</span><span class="message">Can you share the...</span></div></a></div>
                          <div class="user"><a href="#"><img src="<%=request.getContextPath()%>/adminResources/images/avatar2.png" alt="Avatar">
                              <div class="user-data"><span class="status"></span><span class="name">Maggie jackson</span><span class="message">I confirmed the info.</span></div></a></div>
                          <div class="user"><a href="#"><img src="<%=request.getContextPath()%>/adminResources/images/avatar3.png" alt="Avatar">
                              <div class="user-data"><span class="status offline"></span><span class="name">Joel King		</span><span class="message">Ready for the meeti...</span></div></a></div>
                        </div>
                        <h2>Contacts</h2>
                        <div class="contact-list">
                          <div class="user"><a href="#"><img src="<%=request.getContextPath()%>/adminResources/images/avatar4.png" alt="Avatar">
                              <div class="user-data2"><span class="status"></span><span class="name">Mike Bolthort</span></div></a></div>
                          <div class="user"><a href="#"><img src="<%=request.getContextPath()%>/adminResources/images/avatar5.png" alt="Avatar">
                              <div class="user-data2"><span class="status"></span><span class="name">Maggie jackson</span></div></a></div>
                          <div class="user"><a href="#"><img src="<%=request.getContextPath()%>/adminResources/images/avatar6.png" alt="Avatar">
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
                    <div class="user"><img src="<%=request.getContextPath()%>/adminResources/images/avatar2.png" alt="Avatar">
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
    <script src="<%=request.getContextPath()%>/adminResources/js/parsley.min.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      	//-initialize the javascript
      	App.init();
      	$('form').parsley();
      });
    </script>
  </body>
</html>