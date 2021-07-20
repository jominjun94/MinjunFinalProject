<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var = "principal"/>
</sec:authorize>
    
 
<!DOCTYPE html>
<html lang="en">
<head>
   <title></title>
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
			<a class="navbar-brand" href="#!">ADMIN</a>
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
	<br/>


<div class="container">
	


	
	<div>
		No.<span id="id"><i>${board.id}</i></span> <br/> <span><i>name : ${board.user.name} </i></span>
	</div>
	<br />
	<div>
		<h3> ${board.title}</h3>
	</div>
	<hr />
	<div>
		<div>${board.content}</div>
	</div>
	<hr />
	
	
	
	  
	   
				
				<button class="btn btn-outline-dark mt-auto" onclick="history.back()">back</button>
				
				<c:if test="${board.user.username == principal.user.username}">
				<button type="button" class="btn btn-outline-dark mt-auto" id ="btn-delete">delete</button>
				</c:if>
	


				
	
			
	
	
	

</div>
	<br/>
 	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; MINJUN
				Website 2021</p>
		</div>
	</footer>
<script src="/js/board.js"></script>
</body>
</html>

