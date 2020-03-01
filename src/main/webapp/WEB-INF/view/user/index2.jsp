<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html class="no-js" lang="en">


<head>

    <!--- basic page needs
   ================================================== -->
    <meta charset="utf-8">
    <title>FAAS</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- mobile specific metas
   ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSS
   ================================================== -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/base.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/main.css">

    <!-- script
   ================================================== -->
    <script src="<%=request.getContextPath()%>/adminResources/js/modernizr.js"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/pace.min.js"></script>

    <!-- favicons
	================================================== -->
    <link rel="shortcut icon" href="images/faas.png" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">

</head>

<body id="top">

    <!-- header 
   ================================================== -->
   <header id="header" class="row">   

   		<div class="header-logo">
	        <a href="#">FAAS</a>
	    </div>

	   	<nav id="header-nav-wrap">
			<ul class="header-main-nav">
				<li class="current"><a class="smoothscroll"  href="#home" title="home">Home</a></li>
			</ul>

            <a href="/login.html" title="sign-up" class="button button-primary cta">Sign Up</a>
		</nav>

		<a class="header-menu-toggle" href="#"><span>Menu</span></a>    	
   	
   </header> <!-- /header -->


   <!-- home
   ================================================== -->
   <section id="home" data-parallax="scroll" data-image-src="adminResources/images/jjj.jpg" data-natural-width=1000 data-natural-height=1000>

        <div class="overlay"></div>
        <div class="home-content">        

            <div class="row contents">                     
                <div class="home-content-left">

                    <h3 data-aos="fade-up">Welcome to FAAS</h3>

                    <h1 data-aos="fade-up">
                        Creative Landing <br>
                        Portal to Generate <br>
                        Your Code.
                    </h1>

                </div>

                <div class="home-image-right">
                    <img src="adminResources/images/gero.png" 
                        srcset="adminResources/images/gero.png"  
                        data-aos="fade-up"
                        >
                 </div>
 </div>

        </div> <!-- end home-content -->

        <ul class="home-social-list">
            <li>
                <a href="#"><i class="fa fa-facebook-square"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-twitter"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-instagram"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-youtube-play"></i></a>
            </li>
        </ul>
        <!-- end home-social-list -->

        <div class="home-scrolldown">
            <a href="#about" class="scroll-icon smoothscroll">
                <span>Scroll Down</span>
                <i class="icon-arrow-right" aria-hidden="true"></i>
            </a>
        </div>

    </section> <!-- end home -->  


    <!-- about
    ================================================== -->
    <section id="about">

        <div class="row about-intro">

            <div class="col-four">
                <h1 class="intro-header" data-aos="fade-up">About Our App</h1>
            </div>
            <div class="col-eight">
                <p class="lead" data-aos="fade-up">
				CODERS...Tired of writing same code again and again? We all know that it is very BORING to make different files again and again to execute single program.
                So, Code Generation can be used for small portions of code. Our portal helps you to generate various types of FORMS. 
                There are many types of forms in an application let's say Registration form, Login Form, FeedBack Form and many more.<br><br>
                </p>
            </div>                       
            
        </div>

        <div class="row about-features">

			<br> <h1 class="intro-header" data-aos="fade-up">Features</h1>

            <div class="features-list block-1-2 block-m-1-2 block-mob-full group">

                <div class="bgrid feature" data-aos="fade-up">	

<!--                     <span class="icon"><i class="icon-window"></i></span> -->            

                    <div class="service-content">	

                        <h3>Productivity</h3>

                        <p>With code generation you write the generator once and it can be reused as many times as you need. 
				Providing the specific inputs to the generator and invoke it is significantly faster than writing the code manually, therefore code generation permits to save time.
                        </p>
                        
                    </div> 	         	 

                    </div> <!-- /bgrid -->

                    <div class="bgrid feature" data-aos="fade-up">	

                     <!--    <span class="icon"><i class="icon-image"></i></span> -->                          

                    <div class="service-content">	
                        <h3>Simplification</h3>  

                        <p>With code generation you generate your code from some abstract description. 
				It means that your source of truth becomes that description, not the code. 
				That description is typically easier to analyze and check compared with the whole generated code.
                        </p>

                        
                    </div>	                          

                </div> <!-- /bgrid -->

                <div class="bgrid feature" data-aos="fade-up">

                  <!--   <span class="icon"><i class="icon-paint-brush"></i></span> -->		            

                    <div class="service-content">
                        <h3>Portability</h3>

                        <p>You have a process to generate code for spring framework. 
				You can also target multiple platforms at once.  
				You can use your own database without changing the code it can be MYSQL, oracle etc.
				You can configure your own database in xml file.
                        </p> 
                            
                    </div> 	            	               

                </div> <!-- /bgrid -->

                    <div class="bgrid feature" data-aos="fade-up">

                       <!--  <span class="icon"><i class="icon-file"></i></span> -->	              

                    <div class="service-content">
                        <h3>Consistency</h3>

                        <p>With code generation you get always the code you expect. 
				The generated code is designed according to the same principles, the naming rule match, etc. 
				The code always works the way you expect, of course except in the case of bugs in the generator. 
				The quality of the code is consistent. 
				With code written manually instead you can have different developers use different styles and occasionally introduce errors even in the most repetitive code.
                        </p> 
                        
                    </div>                

                    </div> <!-- /bgrid -->

                
            </div> <!-- end features-list -->

        </div> <!-- end about-features -->

        <div class="row about-how">
          
            <h1 class="intro-header" data-aos="fade-up">How The App Works?</h1>           

            <div class="about-how-content" data-aos="fade-up">
                <div class="about-how-steps block-1-2 block-tab-full group">

                    <div class="bgrid step" data-item="1">
                        <h3>Sign-Up</h3>
                        <p>New users have to create an account to avail the advantage of the portal. User needs to provide some basic and necessary details while creating an account.
                        </p> 
                    </div>

                    <div class="bgrid step" data-item="2">
                        <h3>Project creation</h3>
                        <p>First of all, user has to create a project in which the code will be generated. Then a module for that project is to be created for which user needs to generate a code. 
                        </p> 
                    </div>               
               
                    <div class="bgrid step" data-item="3">
                        <h3>Form creation</h3>
                        <p>Now, user has to create a form. Here, user has to provide accurate details like form name, form description... so that the system can give desired code. 
                        </p> 
                    </div>

                    <div class="bgrid step" data-item="4">
                        <h3>Generate & Download</h3>
                        <p>In the last, user has to click on "Generate code" link. This link will create a zip file which contains the code generated by the system along with databse connection.Then by clicking the "Download" link, user can download the code. 
                        </p> 
                    </div>  

                </div>           
           </div> <!-- end about-how-content -->

        </div> <!-- end about-how -->

                
    </section> <!-- end about -->  

    <div id="preloader"> 
    	<div id="loader"></div>
    </div>  

    <!-- Java Script
    ================================================== -->
    <script src="<%=request.getContextPath()%>/adminResources/js/jquery-2.1.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/plugins.js"></script>
    <script src="<%=request.getContextPath()%>/adminResources/js/main.js"></script>

</body>

</html>