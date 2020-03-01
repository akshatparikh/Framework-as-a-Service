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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap4.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminResources/css/responsive.bootstrap4.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/app.css" type="text/css"/>
  </head>
  <body>
    <div class="be-wrapper">
       <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="menu.jsp"></jsp:include>
      <div class="be-content">
        <div class="page-head">
          <h2 class="page-head-title">View Project</h2>
          <nav aria-label="breadcrumb" role="navigation">
            <ol class="breadcrumb page-head-nav">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item"><a href="#">Manage Projects</a></li>
              <li class="breadcrumb-item active">View Project</li>
            </ol>
          </nav>
        </div>
        
       
        <div class="main-content container-fluid">
          <div class="row">
            <div class="col-sm-12">
              <div class="card card-table">
                <div class="card-header">List of Projects
                  <div class="tools dropdown"><span class="icon mdi mdi-download"></span><a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown"><span class="icon mdi mdi-more-vert"></span></a>
                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" href="#">Action</a><a class="dropdown-item" href="#">Another action</a><a class="dropdown-item" href="#">Something else here</a>
                      <div class="dropdown-divider"></div><a class="dropdown-item" href="#">Separated link</a>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <table class="table table-striped table-hover table-fw-widget" id="table1">
                    <thead>
                      <tr>
                        <th>Sr.No</th>
                        <th>User Name</th>
                        <th>Project Name</th>
                        <th>Project Description(s)</th>
                        
                      </tr>
                    </thead>
                     <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
                    <tbody>
                    
                    
                    <c:forEach var="i" varStatus="j" items="${projectList}">
                    <tr>
                        <td>${j.count}</td>
                        <td>${i.loginVO.username}</td>
                        <td>${i.projectName}</td>
                        <td>${i.projectDescription}</td>
                      </tr>
                    </c:forEach>
                    
                    
                    
                     </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          
          
    	</div>
    </div></div>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/perfect-scrollbar.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/app.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery.dataTables.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/dataTables.bootstrap4.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/buttons.flash.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/jszip.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/pdfmake.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/vfs_fonts.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/buttons.colVis.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/buttons.print.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/buttons.html5.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/buttons.bootstrap4.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/dataTables.responsive.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/responsive.bootstrap4.min.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      	//-initialize the javascript
      	App.init();
      	App.dataTables();
      });
    </script>
  </body>
</html>