  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <title>Shop Item - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="../resources/assets3/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../resources/css/styles.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">${principal.user.name}</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="/user/${principal.user.id}">MYPAGE</a></li>
                        
                    </ul>
                    <form class="d-flex">
                       
                    </form>
                </div>
            </div>
        </nav>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="/upload2/${imagedto.image.postImageUrl}" alt="..." /></div>
                    <div class="col-md-6">
                       
                        <h1 class="display-5 fw-bolder">${imagedto.image.caption}</h1>
              
                        <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi consequatur obcaecati excepturi alias magni, accusamus eius blanditiis delectus ipsam minima ea iste laborum vero?</p>
                        <div class="d-flex">
                        
                        
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="${imagedto.likeCount}" style="max-width: 3rem" />
                            
                            
                            <c:choose>
                            	<c:when test="${imagedto.likeState}">
                            <input class="btn btn-outline-dark flex-shrink-0" type="button" onclick="toggleLike(${imagedto.image.id})" id = "buttonLike" value="LikeCancel"/>
                               
                          
                            </c:when>
                            <c:otherwise>
                            <input class="btn btn-outline-dark flex-shrink-0" type="button" onclick="toggleLike(${imagedto.image.id})" id = "buttonLike" value="LIKE"/>
                               
  					
                         
                            </c:otherwise>
                   		</c:choose>
                   				
                   				<c:if test = "${imagedto.user.id == principal.user.id}">
                   				&nbsp;&nbsp; <input class="btn btn-outline-dark flex-shrink-0" type="button" onclick="deleteImage(${imagedto.image.id})"  value="x"/>
                             	</c:if>
                        </div>
                    </div>
                </div>
            </div>
        </section>
      
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../resources/js/scripts.js"></script>
       
       
       
       
       
       
        <script src="/js/view.js"></script>
    </body>
</html>
