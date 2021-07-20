<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var = "principal"/>
</sec:authorize>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
       
        <title>MINJUN</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="resources/assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
        <!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css">-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="resources/css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <a class="menu-toggle rounded" href="#"><i class="fas fa-bars"></i></a>
        <nav id="sidebar-wrapper">
            <ul class="sidebar-nav">
           		<c:if test = "${principal == null}">	
                <li class="sidebar-brand"><a href="#page-top">Project</a></li>
                </c:if>
                <c:if test = "${principal != null}">	
                <li class="sidebar-brand"><a href="#page-top">${principal.user.name}'s forum</a></li>
                </c:if>
                <li class="sidebar-nav-item"><a href="#page-top">Home</a></li>
                <c:if test = "${principal == null}">
                <li class="sidebar-nav-item"><a href="/auth/signin">SIGNIN</a></li>
                </c:if>
                <c:if test = "${principal == null}">
                <li class="sidebar-nav-item"><a href="/auth/signup">SIGNUP</a></li>
				</c:if>
				<c:if test = "${principal != null}">	
               <li class="sidebar-nav-item"><a href="/user/update">UPDATE</a></li>
                </c:if>
                <c:if test = "${principal != null}">	
               <li class="sidebar-nav-item"><a href="/image/upload">WRITE</a></li>
                </c:if>
                 <c:if test = "${principal != null}">	
               <li class="sidebar-nav-item"><a href="/user/${principal.user.id}">MYPAGE</a></li>
                </c:if>
                 <li class="sidebar-nav-item"><a href="/board">QnA</a></li>
				 <c:if test = "${principal != null}">	
               <li class="sidebar-nav-item"><a href="/logout">LOGOUT</a></li>
                </c:if>
                 <c:if test = "${principal.user.role == 'ROLE_ADMIN'}">	
            	  <li class="sidebar-nav-item"><a href="/admin/board">ADMIN</a></li>
            	  </c:if>
            </ul>
        </nav>
        <!-- Header-->
        <header class="masthead d-flex align-items-center">
            <div class="container px-4 px-lg-5 text-center">
            
            	    <c:if test = "${principal == null}">
            		<h1 class="mb-1">Project</h1>
    				</c:if>
    				<c:if test = "${principal != null}">
                <h1 class="mb-1">${principal.user.name}'s DREAM</h1>
             </c:if>
                 <h3 class="mb-5"><em>TRY YOUR DREAM</em></h3>
                 
               <c:if test = "${principal == null}">
               <button class="btn btn-primary btn-xl" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">SIGN IN</button>
               </c:if>
               
            </div>
        </header>
      
        <!-- Services-->
        <section class="content-section bg-primary text-white text-center" id="services">
            <div class="container px-4 px-lg-5">
                <div class="content-section-heading">
                    <h3 class="text-secondary mb-0">Services</h3>
                    <h2 class="mb-5">What We Offer</h2>
                </div>
                <div class="row gx-4 gx-lg-5">
                    <div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
                        <span class="service-icon rounded-circle mx-auto mb-3"><i class="icon-screen-smartphone"></i></span>
                        <h4><strong>Look at other pictures</strong></h4>
                      
                    </div>
                    <div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
                        <span class="service-icon rounded-circle mx-auto mb-3"><i class="icon-pencil"></i></span>
                        <h4><strong>Write your story</strong></h4>
                      
                    </div>
                    <div class="col-lg-3 col-md-6 mb-5 mb-md-0">
                        <span class="service-icon rounded-circle mx-auto mb-3"><i class="icon-like"></i></span>
                        <h4><strong>You can give a like</strong></h4>
                        <p class="text-faded mb-0">
                          
                       
                        </p>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <span class="service-icon rounded-circle mx-auto mb-3"><i class="icon-mustache"></i></span>
                        <h4><strong>You can ask questions</strong></h4>
                   
                    </div>
                </div>
            </div>
        </section>



        <!-- Footer-->
        <footer class="footer text-center">
            <div class="container px-4 px-lg-5">
                <p class="text-muted small mb-0">Copyright &copy; MINJUN Website 2021</p>
            </div>
        </footer>
        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top"><i class="fas fa-angle-up"></i></a>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="resources/js/scripts.js"></script>
        
    </body>
    
    
    
    
    
    
    
    <!-- modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">SIGN IN</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="/auth/signin" method="post" >
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">YOUR ID</label>
            <input type="text" class="form-control" id="recipient-name" name = "username">
          </div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">YOUR PASSWORD</label>
            <input type="password" class="form-control" id="recipient-name" name = "password">
          </div>
        	<button class="btn btn-primary">SIGN IN</button>
        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

     
         </form>
      </div>
   
     
    </div>
  </div>
</div>
</body>

    
    
    
    
    
</html>
