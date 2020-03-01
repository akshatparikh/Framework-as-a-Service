<div class="be-left-sidebar">
        <div class="left-sidebar-wrapper"><a class="left-sidebar-toggle" href="#">Home</a>
          <div class="left-sidebar-spacer">
            <div class="left-sidebar-scroll">
              <div class="left-sidebar-content">
                <ul class="sidebar-elements">
                  <li class="divider">Menu</li>
                  <li class="active"><a href="/user/index"><i class="icon mdi mdi-home"></i><span>Home</span></a>
                  </li>
                  <li class="parent"><a href="#"><i class="icon mdi mdi-face"></i><span>Manage Project</span></a>
                    <ul class="sub-menu">
                      <li><a href="<%=request.getContextPath()%>/user/loadProject.html">Add Project</a>
                      </li>
                      <li><a href="<%=request.getContextPath()%>/user/loadviewProject.html">View Project</a>
                      </li>
                    </ul>
                  </li>
                  
                  <li class="parent"><a href="#"><i class="icon mdi mdi-face"></i><span>Manage Module</span></a>
                    <ul class="sub-menu">
                      <li><a href="<%=request.getContextPath()%>/user/loadModule.html">Add Module</a>
                      </li>
                      <li><a href="<%=request.getContextPath()%>/user/loadviewModule.html">View Module</a>
                      </li>
                    </ul>
                  </li>
                  
                   <li><a href="<%=request.getContextPath()%>/user/loadForm.html"><i class="icon mdi mdi-face"></i><span>Add Form</span></a></li>
                   
                   <li><a href="<%=request.getContextPath()%>/user/loadCode.html"><i class="icon mdi mdi-face"></i><span>Generate Code</span></a></li>
                   
                   <li class="parent"><a href="#"><i class="icon mdi mdi-face"></i><span>Complaints</span></a>
                    <ul class="sub-menu">
                      <li><a href="<%=request.getContextPath()%>/user/loadComplaint.html">Add Complaint</a>
                      </li>
                      <li><a href="<%=request.getContextPath()%>/user/loadviewComplaint.html">View Complaint</a>
                      </li>
                    </ul>
                  </li>
                   
                  <li class="parent"><a href="#"><i class="icon mdi mdi-face"></i><span>Feedback</span></a>
                    <ul class="sub-menu">
                      <li><a href="<%=request.getContextPath()%>/user/loadFeedback.html">Add Feedback</a>
                      </li>
                      <li><a href="<%=request.getContextPath()%>/user/loadviewFeedback.html">View Feedback</a>
                      </li>
                    </ul>
                  </li>

                  </ul>
              </div>
            </div>
          </div>
         <div class="progress-widget">
       </div>
     </div>
</div>