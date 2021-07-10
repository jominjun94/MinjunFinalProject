<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
</head>
<body>




    <form  class="loginForm" action="/auth/signup" method="post">
      <h2>SignUp</h2>
      <div class="idForm">
        <input type="text" class="id" placeholder="ID(3~20)" name = "username">
      </div>
      <div class="passForm">
        <input type="password" class="pw" placeholder="PW(4~20)" name= "password">
      </div>
        <div class="nameForm">
        <input type="text" class="name" placeholder="name" name = "name">
      </div>
      <div class="emailForm">
        <input type="email" class="email" placeholder="email" name = "email">
      </div><br/>
      
      
      
      
      <button class="btn">
        SIGN UP
      </button>
   	
      <div class="bottomText">
        Do you have ID? <a href="/auth/signin">sign in</a>
      </div>
 </form>
 
 
 
 

 
 
  </body>
</html>
