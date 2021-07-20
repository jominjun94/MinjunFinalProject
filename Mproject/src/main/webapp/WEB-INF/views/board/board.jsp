
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var = "principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
						<li class="nav-item"><a class="nav-link active" href="/image/upload">WRITE</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/board">QnA</a></li>
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/board/reply">REPLY</a></li>
						
				</ul>

			</div>
		</div>
	</nav>
	<br/>
	
<div class="container">
  <h2> Give feedback to the developer <a class="btn btn-outline-dark mt-auto" href="/board/write">Write Your Opinion</a> </h2> 
          
  <table class="table table-striped">
    <thead>
      <tr>
      	<th>No</th>
        <th>Title</th>
        <th>Name</th>
        <th>Date</th>
      	<th></th>
      </tr>
    </thead>
    
    <tbody>
    
	<c:forEach var = "board" items = "${boards.content}">
      <tr>
      	<td>${board.id}</td>
        <td>${board.title}</td>
  		<td>${board.user.name}</td>
        <td>${board.createDate}</td>
      
            	<th>
          <c:if test="${board.user.username == principal.user.username}">
			<a class="btn btn-outline-dark mt-auto"
				href="/board/${board.id}">enter</a>
			</c:if>
			 <c:if test="${board.user.username != principal.user.username}">
			<a class="btn btn-outline-dark mt-auto"
				href="#">secrete</a>
			</c:if>
				</th>
				
 		</tr>
	</c:forEach>
    </tbody>
  </table>
</div>
<div class="text-center">
									
										
							
													<!-- start -->					
	<c:choose>
		<c:when test="${boards.first}"></c:when>
		<c:otherwise>
			<a class="btn btn-outline-dark mt-auto" href = "/board/?page=0">start</a>
			<a class="btn btn-outline-dark mt-auto" href = "/board/?page=${boards.number-1}">&larr;</a>
		</c:otherwise>
	</c:choose>
	
	
	<c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
		<c:choose>
			<c:when test="${boards.pageable.pageNumber + 1 == i }">
				<a class="btn btn-outline-dark mt-auto" href = "/board/?page=${i-1}">${i}</a>
			</c:when>
			<c:otherwise>
				<a class="btn btn-outline-dark mt-auto" href = "/board/?page=${i-1}">${i}</a>
			</c:otherwise>
		
		
		</c:choose>
		
	
	
	</c:forEach>
	
	
			<!-- end -->
	<c:choose>
		<c:when test="${boards.last}"></c:when>
		<c:otherwise>
			<a class="btn btn-outline-dark mt-auto" href = "/board/?page=${boards.number+1}">&rarr;</a>
			<a class="btn btn-outline-dark mt-auto" href = "/board/?page=${boards.totalPages-1}">last</a>
		</c:otherwise>
	</c:choose>
					
								</div><br/>

	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; MINJUN
				Website 2021</p>
		</div>
	</footer>
	
	

	

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

	<script src="../resources/js2/scripts.js"></script>
	<script src="/js/profile.js"></script>
	<script src="/js/story.js"></script>
</body>
</html>