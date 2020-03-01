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
  </head>
  <body>
    <div class="be-wrapper">
       <jsp:include page="header.jsp"></jsp:include>
       <jsp:include page="menu.jsp"></jsp:include>
      <div class="be-content">
        <div class="page-head">
          <h2 class="page-head-title">Form Validation</h2>
          <nav aria-label="breadcrumb" role="navigation">
            <ol class="breadcrumb page-head-nav">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item"><a href="#">Forms</a></li>
              <li class="breadcrumb-item active">Validation</li>
            </ol>
          </nav>
        </div>
        <div class="main-content container-fluid">
          <div class="row">
            <div class="col-lg-6">
              <div class="card card-border-color card-border-color-primary">
                <div class="card-header card-header-divider">Basic Form<span class="card-subtitle">This is the default bootstrap form layout</span></div>
                <div class="card-body">
                  <form action="#" data-parsley-validate="" novalidate="">
                    <div class="form-group">
                      <label for="inputUserName">User Name</label>
                      <input class="form-control" id="inputUserName" type="text" name="nick" parsley-trigger="change" required="" placeholder="Enter user name" autocomplete="off">
                    </div>
                    <div class="form-group">
                      <label for="inputEmail">Email address</label>
                      <input class="form-control" id="inputEmail" type="email" name="email" parsley-trigger="change" required="" placeholder="Enter email" autocomplete="off">
                    </div>
                    <div class="form-group">
                      <label for="inputPassword">Password</label>
                      <input class="form-control" id="inputPassword" type="password" placeholder="Password" required="">
                    </div>
                    <div class="form-group">
                      <label for="inputRepeatPassword">Repeat Password</label>
                      <input class="form-control" id="inputRepeatPassword" data-parsley-equalto="#inputPassword" type="password" required="" placeholder="Password">
                    </div>
                    <div class="row pt-0 pt-sm-5">
                      <div class="col-sm-6 pb-2 pb-sm-4 pb-lg-0 pr-0">
                        <label class="be-checkbox custom-control custom-checkbox">
                          <input class="custom-control-input" type="checkbox"><span class="custom-control-label">Remember me</span>
                        </label>
                      </div>
                      <div class="col-sm-6 pl-0">
                        <p class="text-right">
                          <button class="btn btn-space btn-primary" type="submit">Submit</button>
                          <button class="btn btn-space btn-secondary">Cancel</button>
                        </p>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
            <div class="col-lg-6">
              <div class="card card-border-color card-border-color-primary">
                <div class="card-header card-header-divider">Horizontal Form<span class="card-subtitle">This is the horizontal bootstrap layout</span></div>
                <div class="card-body">
                  <form data-parsley-validate="" novalidate="">
                    <div class="form-group row">
                      <label class="col-3 col-lg-2 col-form-label text-right" for="inputEmail2">Email</label>
                      <div class="col-9 col-lg-10">
                        <input class="form-control" id="inputEmail2" type="email" required="" parsley-type="email" placeholder="Email">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-3 col-lg-2 col-form-label text-right" for="inputPassword2">Password</label>
                      <div class="col-9 col-lg-10">
                        <input class="form-control" id="inputPassword2" type="password" required="" placeholder="Password">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-3 col-lg-2 col-form-label text-right" for="inputWebSite">Web Site</label>
                      <div class="col-9 col-lg-10">
                        <input class="form-control" id="inputWebSite" type="url" required="" parsley-type="url" placeholder="URL">
                      </div>
                    </div>
                    <div class="row pt-2 pt-sm-5 mt-1">
                      <div class="col-sm-6 pb-2 pb-sm-4 pb-lg-0 pr-0">
                        <label class="be-checkbox custom-control custom-checkbox">
                          <input class="custom-control-input" type="checkbox"><span class="custom-control-label">Remember me</span>
                        </label>
                      </div>
                      <div class="col-sm-6 pl-0">
                        <p class="text-right">
                          <button class="btn btn-space btn-primary" type="submit">Submit</button>
                          <button class="btn btn-space btn-secondary">Cancel</button>
                        </p>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <div class="card card-border-color card-border-color-primary">
                <div class="card-header card-header-divider">Validation Types<span class="card-subtitle">Parsley different validation types</span></div>
                <div class="card-body">
                  <form>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Required</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" type="text" required="" placeholder="Type something">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Min Length</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" type="text" required="" data-parsley-minlength="6" placeholder="Min 6 chars.">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Max Length</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" type="text" required="" data-parsley-maxlength="6" placeholder="Max 6 chars.">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Range Length</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" type="text" required="" data-parsley-length="[5,10]" placeholder="Text between 5 - 10 chars length">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Min Value</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" type="text" required="" data-parsley-min="6" placeholder="Min value is 6">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Max Value</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" type="text" required="" data-parsley-max="6" placeholder="Max value is 6">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Range Value</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" required="" type="text" min="6" max="100" placeholder="Number between 6 - 100">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Regular Exp</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" type="text" required="" data-parsley-pattern="#[A-Fa-f0-9]{6}" placeholder="Hex. Color">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Equal To</label>
                      <div class="col-sm-4 col-lg-3 mb-3 mb-sm-0">
                        <input class="form-control" id="pass2" type="password" required="" placeholder="Password">
                      </div>
                      <div class="col-sm-4 col-lg-3">
                        <input class="form-control" type="password" required="" data-parsley-equalto="#pass2" placeholder="Re-Type Password">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-sm-3 col-form-label text-sm-right">Min check</label>
                      <div class="col-sm-6">
                        <div class="custom-controls-stacked">
                          <label class="custom-control custom-checkbox">
                            <input class="custom-control-input" id="ck1" name="ck1" type="checkbox" data-parsley-multiple="groups" value="bar" data-parsley-mincheck="2" data-parsley-errors-container="#error-container1"><span class="custom-control-label">Option 1</span>
                          </label>
                          <label class="custom-control custom-checkbox">
                            <input class="custom-control-input" id="ck2" name="ck2" type="checkbox" data-parsley-multiple="groups" value="bar2" data-parsley-mincheck="2" data-parsley-errors-container="#error-container1"><span class="custom-control-label">Option 2</span>
                          </label>
                          <label class="custom-control custom-checkbox">
                            <input class="custom-control-input" id="ck3" name="ck3" type="checkbox" data-parsley-multiple="groups" value="bar3" data-parsley-mincheck="2" required="" data-parsley-errors-container="#error-container1"><span class="custom-control-label">Option 3</span>
                          </label>
                          <div id="error-container1"></div>
                        </div>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-sm-3 col-form-label text-sm-right">Max check</label>
                      <div class="col-sm-6">
                        <div class="custom-controls-stacked">
                          <label class="custom-control custom-checkbox">
                            <input class="custom-control-input" type="checkbox" value="bar" id="e1" data-parsley-multiple="group1" data-parsley-errors-container="#error-container2"><span class="custom-control-label">Option 1</span>
                          </label>
                          <label class="custom-control custom-checkbox">
                            <input class="custom-control-input" type="checkbox" value="bar" id="e2" data-parsley-multiple="group1" data-parsley-errors-container="#error-container2"><span class="custom-control-label">Option 2</span>
                          </label>
                          <label class="custom-control custom-checkbox">
                            <input class="custom-control-input" type="checkbox" value="bar" id="e3" data-parsley-multiple="group1" data-parsley-maxcheck="1" data-parsley-errors-container="#error-container2"><span class="custom-control-label">Option 3</span>
                          </label>
                          <div id="error-container2"></div>
                        </div>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">E-Mail</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" type="email" required="" parsley-type="email" placeholder="Enter a valid e-mail">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">URL</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" parsley-type="url" type="url" required="" placeholder="URL">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Digits</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" data-parsley-type="digits" type="text" required="" placeholder="Enter only digits">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Number</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" data-parsley-type="number" type="text" required="" placeholder="Enter only numbers">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Alphanumeric</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" data-parsley-type="alphanum" type="text" required="" placeholder="Enter alphanumeric value">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Textarea</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <textarea class="form-control" required=""></textarea>
                      </div>
                    </div>
                    <div class="form-group row text-right">
                      <div class="col col-sm-10 col-lg-9 offset-sm-1 offset-lg-0">
                        <button class="btn btn-space btn-primary" type="submit">Submit</button>
                        <button class="btn btn-space btn-secondary">Cancel</button>
                      </div>
                    </div>
                  </form>
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