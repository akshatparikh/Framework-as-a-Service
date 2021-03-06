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
 	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/demo.css"/>
 	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/font-awesome.css"/>
 	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/noJs.css"/>
 	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/style.css"/>
 
 
<script type="text/javascript">	

		var counter = 0;
		
		function addTable()
  		{	
			var addFormToTable = document.getElementById("addRadioToTable");
			
	  		var body = document.getElementsByTagName("body")[0];
	
	  		var tbl =addFormToTable; //document.createElement("table");
			
			var row =tbl.insertRow(-1);
			
			var cell0= row.insertCell(-1);
			var cell1= row.insertCell(-1);
			var cell2= row.insertCell(-1);
		//	var cell3= row.insertCell(-1);
			
			var fieldName=document.getElementById("fieldName");
			var fieldType=document.getElementById("fieldType");
			var fieldValue=document.getElementById("fieldValue");
			//var file=document.getElementById("file");
			
			cell0.innerHTML="<input type='text' name='fieldList["+counter+"].fieldName' value='"+fieldName.value+"'>";
			cell1.innerHTML="<input type='text' name='fieldList["+counter+"].fieldType' value='"+fieldType.value+"'>";
			cell2.innerHTML="<input type='text' name='fieldList["+counter+"].fieldValue' value='"+fieldName.value+"'>";
		//	cell3.innerHTML="<input type='file' name='fieldList["+counter+"].file' value='"+file.value+"'>";
			
			counter++;
		}
		
		function addRadio()
  		{	
			var addFormToTable = document.getElementById("addRadioToTable");
			
	  		var body = document.getElementsByTagName("body")[0];
	
	  		var tbl =addFormToTable;
			
			var row =tbl.insertRow(-1);
			
			var cell0= row.insertCell(-1);
			var cell1= row.insertCell(-1);
			var cell2= row.insertCell(-1);
			
			var fieldName=document.getElementById("fieldName");
			var fieldType=document.getElementById("fieldType");
			var fieldValue=document.getElementById("fieldValue");
				 
			cell0.innerHTML="<input type='text' name='fieldList["+counter+"].fieldName' value='"+fieldName.value+"'>";
			cell1.innerHTML="<input type='text' name='fieldList["+counter+"].fieldType' value='"+fieldType.value+"'>";
			cell2.innerHTML="<input type='text' name='fieldList["+counter+"].fieldValue' value='"+fieldValue.value+"'>";
			
			counter++;
		}
		
		
		function fetchModule()
		{
			var a=document.getElementById("project");
			var b=document.getElementById("module");
			b.innerHTML="";
			
			var htp=new XMLHttpRequest();
			
			htp.onreadystatechange=function()
			{
				
				if(htp.readyState==4)
				{
					
					var jsn = JSON.parse(htp.responseText);
					
					/* sta.innerHTML=""; */
					
					for(var i = 0 ; i  <jsn.length ; i++){
							
						var op = document.createElement("option");
						
						op.text = jsn[i].moduleName;
						op.value = jsn[i].moduleId;
						
						b.options.add(op);
					}
				
				}
			}
			htp.open("get","/searchModule.html?u="+a.value,true);
			htp.send();

		}
		
		function radio(type)
		{
			var l = document.getElementById("radiobtn");
			var a = document.getElementById("add");
			//var f = document.getElementById("file");
			
			if(type=="radio" || type=="checkbox" || type=="dropdown")
			{
				console.log(l);
				l.style.display = '';
				a.style.display = 'none';
				
			} else if(type == "file")
				{
					l.style.display = 'none';
					//console.log(f);
					//f.style.display = '';
					console.log(a);
					a.style.display = '';
				} 
			
			else{
				console.log(l.style.display);
				l.style.display = 'none';
				//f.style.display = 'none';
				console.log(a);
				a.style.display = '';
			}
		}
	
		</script>
  
    
  </head>
  <body>
   
  
    <div class="be-wrapper">
    
       <jsp:include page="header.jsp"></jsp:include>
       <jsp:include page="menu.jsp"></jsp:include>
      <div class="be-content">
        <div class="page-head">
          <h2 class="page-head-title">Add Form</h2>
          <nav aria-label="breadcrumb" role="navigation">
            <ol class="breadcrumb page-head-nav">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
             
              <li class="breadcrumb-item active">Add Form</li>
            </ol>
          </nav>
        </div>
        <div class="main-content container-fluid">
          
          <div class="row">
            <div class="col-md-12">
            
              <div class="card card-border-color card-border-color-primary">
              
                <div class="card-header card-header-divider">Add Form<span class="card-subtitle">Enter Form Details</span></div>
                
                <div class="card-body">
                  
                <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
                <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
                
               <f:form action="/insertForm.html" method="post" modelAttribute="FormVO" enctype="multipart/form-data">
                  
                  
                <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right"><b>Projects</b></label>
           			         <div class="col-12 col-sm-8 col-lg-6">
						         <f:select path="projectVO.projectId" id="project" onchange="fetchModule()"  style="width: 675px; height: 47px">
											<option>SELECT</option>
									<c:forEach items="${projectList}" var="z">
										<option value="${z.projectId}">${z.projectName}</option>
									</c:forEach>			
							 	 </f:select>
			    			 </div>
	        	</div>
	        	
	        	<div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right"><b>Modules</b></label>
           			         <div class="col-12 col-sm-8 col-lg-6">
						         <f:select path="moduleVO.moduleId" id="module" style="width: 675px; height: 47px">
										<option value=""></option>
							 	 </f:select>
			    			 </div>
	        	</div>
                                    
               <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right"><b>Form Name</b></label>
                      <div class="col-12 col-sm-8 col-lg-6" >
                        <f:input style="width: 675px;" class="form-control" type="text" path="formName" required="required" placeholder="Form Name"></f:input>
              		</div>
             	</div>
             	
              <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right"><b>Form Description</b></label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <f:input class="form-control" style="width: 675px;" type="textarea" path="formDescription" required="required" data-parsley-minlength="10" placeholder="Describe your form"></f:input>
                      </div>
               </div>
               
               <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right"><b>Form Field</b></label>
					                     
                     <table border="1" width="700px" rules="none">
                     
                     <tr>
                     <td >
                      <div class="form-group row">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right">Field Name</label>
                      <div class="col-12 col-sm-8 col-lg-6">
                        <input class="form-control" type="text"  required="required" placeholder="Field Name" id="fieldName">
              			*Enter a value without spacing in between them.
              		</div>
             		</div>  
					</td>
                     </tr>

					<tr>
						<td>
					
                     	<div class="form-group row">
                        <label class="col-12 col-sm-3 col-form-label text-sm-right" >Field Type</label>
                     	  <div class="col-12 col-sm-8 col-lg-6">
							<select id="fieldType" style="width: 335px; height: 47px" onchange="radio(this.value)">
								<option value="empty">- Select Datatype -</option>
								<option value="text">text</option>
								<option value="textarea">textarea</option>
								<option value="checkbox">checkbox</option>
								<option value="radio">radio</option>
								<option value="dropdown">dropdown</option>
								<option value="file">file</option>
							</select> 
							</div>
                      	</div>
							</td>
                     </tr>
					
					
					
					<tr>
						<td>
							<div class="form-group row">
							<div class="col-12 col-sm-8 col-lg-6" id="radiobtn" style="display: none;">
							</t><label class="col-12 col-sm-3 col-form-label text-sm-right" style="margin-left: 55px">Value</label>						
								<input style="margin-top:5px" type="text" id="fieldValue" name="radioButtonValues">&nbsp  Enter "," separated value. 
							<center>
								<button class="btn btn-space btn-primary" type="button" onclick="addRadio()">Add</button>
							</center>
							</div>        
							</div>            

	                    </td>
					</tr>
					
					
					<tr>
						<td>
							<div class="form-group row text-right">
                	        <div class="col col-sm-10 col-lg-9 offset-sm-1 offset-lg-0" id="add">
                       <center>
	                        <button class="btn btn-space btn-primary" type="button" onclick="addTable()">Add</button>
                       </center>
                      </div>
                    </div>
					
						</td>
		    		</tr>	
												
					</table>
				</div>
				
				 	<div class="form-group row">
				 	<%-- <div class="col-12 col-sm-8 col-lg-6"  id="other">
				 	
                      <label class="col-12 col-sm-3 col-form-label text-sm-right" style="margin-left:55px"><b>Form Field</b></label>
					                     
                      <table border="1" width="700px" height="50px" id="addFormToTable" style="margin-top:1px;margin-left: 285px">		
						<tr>
							<td><center><b>Field Name</b></center></td>
							<td><center><b>Field Type</b></center></td>
							<td><center><b>File</b></center></td>
						</tr>
					  </table>
					</div> --%>
				</div>

					<div class="form-group row">
					<div class="col-12 col-sm-8 col-lg-6"  id="other1">
                      <label class="col-12 col-sm-3 col-form-label text-sm-right" style="margin-left:55px"><b>Form Field</b></label>
					                     
                      <table border="1" width="700px" height="50px" id="addRadioToTable" style="margin-top:1px;margin-left: 285px">		
						<tr>
							<td><center><b>Field Name</b></center></td>
							<td><center><b>Field Type</b></center></td>
							<td><center><b>Field Value</b></center></td>
							<%-- <td><center><b>Image if</b></center></td> --%>
						</tr>
						</table>
					</div>
					</div>
					

					<!-- <div class="form-group row" id="addFormToTable">
                      
					</div> -->





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
    <script src="<%=request.getContextPath()%>/adminResources/js/modernizr.custom.79639.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      	//-initialize the javascript
      	App.init();
      	$('form').parsley();
      });
    </script>
  </body>
</html>