<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>

<style>


p 
{
auto; margin-right: auto;

 }

</style>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
   <meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="../resources/assets2/favicon.ico" />
<!-- Bootstrap icons--> <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../resources/css2/styles.css" rel="stylesheet" />
        <link rel="icon" type="image/x-icon" href="resources/assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
        <!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css">-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="resources/css/styles.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="#!">${principal.user.name}</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">HOME</a></li>
											<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/image/likes">HOT POST</a></li>
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/user/usersubview">SUBSCRIBEPAGE</a></li>
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/user/${principal.user.id}">MYPAGE</a></li>
					<c:if test="${principal.user.id == dto.user.id}">
						<li class="nav-item"><a class="nav-link active" href="/image/upload">WRITE</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/board">QnA</a></li>
				</ul>

			</div>
		</div>
	</nav>
	<!-- Header-->
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
			
				
			
				
			<c:choose>
				<c:when test="${empty photo.postImageUrl}">
				<h1 class="display-4 fw-bolder">	<a href = "/photo/upload"><img src="/resources/cinqueterre.png" class="rounded-circle" alt= "take photo" width="100" height="100"></a> ${dto.user.name}
					POST</h1>
				</c:when>
				
				<c:otherwise>
					
				<h1 class="display-4 fw-bolder">	<a href = "/photo/upload"><img src="/upload2/${photo.postImageUrl}" class="rounded-circle" alt= "take photo" width="100" height="100"></a> ${dto.user.name}
					POST</h1>
			
				
				
				</c:otherwise>
			</c:choose>
			
			

			
			
		
			
				
				
				
					<c:if test="${principal.user.id == dto.user.id}">
					     <button class = "btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">SUB LIST</button>
					</c:if>
				
				<c:choose>
					<c:when test="${dto.subscribeState}">
						<input class="btn btn-secondary" type="button" onclick="toggleSubscribe(${dto.user.id})"
							value="SUBSCRIBECANCEL" id="myButton1" />
					</c:when>
					<c:otherwise>
						<input class="btn btn-secondary" type="button" onclick="toggleSubscribe(${dto.user.id})"
							value="SUBSCRIBE" id="myButton1" />
					</c:otherwise>
				</c:choose>
			


				<p class="lead fw-normal text-white-50 mb-0">${dto.user.images.size()} POST</p>
			</div>
		</div>
	</header>
	
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">


				<c:if test="${empty dto.user.images}">

					
						
							
							
							
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<img class="card-img-top" src="/resources/talk.jpg" />
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<br />
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto"
										href="/image/upload">Write Your Story</a>
								</div>
							</div>
						</div>
					</div>
							
				</c:if>

				<c:forEach var="image" items="${dto.user.images}">
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<img class="card-img-top" src="/upload2/${image.postImageUrl}" />
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<br />
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto"
										href="/image/${image.id}">View options</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; MINJUN
				Website 2021</p>
		</div>
	</footer>
	
	
	
    <!-- modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
     <h5 class="modal-title" id="exampleModalLabel">SUBSCRIBE LIST</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      
      
      
      
      
      <div class="modal-body">
     	
     	
     	<c:if test="${empty users}">
     	
     	 <div class="mb-3">
          <p><label for="recipient-name" class="col-form-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SUBSCRIBE LIST&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="btn btn-outline-dark mt-auto">empty</button>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/image/likes"><button class="btn btn-secondary" type="button" >Move To HOT Post</button></a> </label></p>
          
        </div>
     	</c:if>
     	
     	
     	<c:forEach var = "user" items="${users}">
          <div class="mb-3">
          <p><label for="recipient-name" class="col-form-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NAME&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="btn btn-outline-dark mt-auto">${user.name}</button>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/user/${user.id}"><button class="btn btn-secondary" type="button" > Move</button></a> </label></p>
          
        </div>
        </c:forEach>
        
        	
        

     
       
      </div>
   
     
    </div>
  </div>
</div>
	
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="../resources/js2/scripts.js"></script>
	<script src="/js/profile.js"></script>
</body>
</html>
