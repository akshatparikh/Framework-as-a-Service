<nav class="navbar navbar-expand fixed-top be-top-header">
        <div class="container-fluid" style="background-image: url(/adminResources/images/jjj.jpg); background-size: 1600px 100px">
          <div class="be-navbar-header">
	<a href="#">
	   		<img alt="" src="/adminResources/images/faas.png" height="50px">
	   	</a>          </div>
          <div class="be-right-navbar">
            <ul class="nav navbar-nav float-right be-user-nav">
              <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-expanded="false"><img src="<%=request.getContextPath()%>/adminResources/images/avatar.png" alt="Avatar"><span class="user-name">Túpac Amaru</span></a>
                <div class="dropdown-menu" role="menu">     
                  <div class="user-info">
                    <div class="user-name">
                    	${registrationVO.firstName}
                    </div>
                    <div class="user-position online">Available</div>
                  </div>
                  				<a class="dropdown-item"  href="/addAdmin"><span class="icon mdi mdi-power"></span>Add Admin</a>
                  				<a class="dropdown-item"  href="/logout"><span class="icon mdi mdi-power"></span>Logout</a>
                </div>
              </li>
            </ul>
            <div class="page-title"><span>Home</span></div>

           </div>
      </nav>