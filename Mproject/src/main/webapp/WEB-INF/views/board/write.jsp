<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var = "principal"/>
</sec:authorize>
    
 
<!DOCTYPE html>
<html lang="en">
<head>
   <title>MIN-BLOG</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
 
</head>
<body>


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
						<li class="nav-item"><a class="nav-link" href="/image/upload">WRITE</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/board">FAQ</a></li>
				</ul>

			</div>
		</div>
	</nav>
	<br/>


<div class="container">
	


	<div class="container">
 <form>
  <div class="form-group">
    <label for="title">title</label>
    <input type="text" class="form-control" placeholder="Enter title" id="title">
  </div>
 
 
 
<div class="form-group">
  <label for="content">content</label>
  <textarea class="form-control summernote" rows="5" id="content"></textarea>
</div>
 
 

	
	</form>


</div>
	
	
	
	  
	   
				&nbsp;&nbsp;&nbsp;&nbsp;<button id = "btn-save" class="btn btn-primary">write</button>
				
				<button class="btn btn-secondary" onclick="history.back()">back</button>
				
		
	


				
	
			
	
	
	

</div>
	<br/>
 	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; MINJUN
				Website 2021</p>
		</div>
	</footer>

 <script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
  </script>
   <script src="/js/board.js"></script>

</body>
</html>