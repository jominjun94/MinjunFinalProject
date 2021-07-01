<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var = "principal"/>
</sec:authorize>


<!DOCTYPE html>
<html>
<head>




<style type="text/css">
*{
  margin: 0px;
  padding: 0px;
  text-decoration: none;
  font-family:sans-serif;

}

body {
  background-image: #34495e;
}

.loginForm {
  position:absolute;
  width:300px;
  height:400px;
  padding: 30px, 20px;
  background-color:#FFFFFF;
  text-align:center;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}

.loginForm h2{
  text-align: center;
  margin: 30px;
}

.idForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.passForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.emailForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}


.nameForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.PhoneForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.id {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.pw {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.email {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.name {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.phone {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}



.btn {
  position:relative;
  left:40%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80%;
  height:40px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
}

.btn:hover {
  background-position: right;
}

.bottomText {
  text-align: center;
}



</style>






<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>




    <form class="loginForm" id="profileUpdate" onsubmit="update(${principal.user.id},event)">
      <h2>UPDATE</h2>
      <div class="idForm">
        <input type="text" class="id" placeholder="ID" name = "username" value="${principal.user.username}" readonly="readonly">
      </div>
      <div class="passForm">
        <input type="password" class="pw" placeholder="PW" name= "password" required="required">
      </div>
        <div class="nameForm">
        <input type="text" class="name" placeholder="name" name = "name" value="${principal.user.name}" required="required">
      </div>
      <div class="emailForm">
        <input type="email" class="email" placeholder="email" name = "email" value="${principal.user.email}">
      </div>
        <div class="PhoneForm">
        <input type="text" class="phone" placeholder="phone" name = "phone" value="${principal.user.phone}">
      </div>
      <button class="btn">
     	UPDATE
      </button>
   
      <div class="bottomText">
        <a href="/">HOME</a>
      </div>
 </form>
 
   
<script src="/js/update.js"></script>


  </body>

</html>



