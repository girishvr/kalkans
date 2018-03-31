<!DOCTYPE html>
<html lang="en" >
<?php session_start(); 
header("Cache-Control: no cache");
session_cache_limiter("private_no_expire"); 
?>
<head><title> DEPARTMENT LOGIN</title>
   <link rel="stylesheet" type="text/css" href="login.css">
   <!-- <link rel="stylesheet" type="text/css" href="css/bootstrap.css" /> -->
   <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
   <!-- <script type="text/javascript" src="js/bootstrap.js"></script> -->

</head>
<body>
<p id="demo"></p>
<!-- <form action="check.php" method="POST"> -->
<div class="materialContainer">


   <div class="box">

      <div class="title">LOGIN</div>

      <div class="input">
         <!--<label for="name">Username</label>-->
         <input type="text" placeholder="username" name="name" id="name">
         <span class="spin"></span>
      </div>

      <div class="input">
         <!--<label for="pass">Password</label>-->
         <input type="password" placeholder="password"  name="pass" id="pass">
         <span class="spin"></span>
      </div>

      <div class="button login">
		
         <button type="submit" onclick="javascript:login()"><span>LOGIN</span></button>
      </div>

      <!--<a href="" class="pass-forgot">Forgot your password?</a>-->

   </div>
</div>
  

</form>



<script language="javascript" type="text/javascript">
    function login(){
		var username, password;
		  username=document.getElementById("name").value;
    	password=document.getElementById("pass").value;
    	$.post('login.php',{uname:username,pwd:password},function(responseText){
          
			console.log(responseText);
      myObj = JSON.parse(responseText);
			var data=JSON.stringify(myObj);
			console.log(myObj);
			//console.log(data);
			var status=myObj.status;
			//var userDetails=myObj.details.user_details[dept_name];
			
			console.log(status);
			//document.write(status);
			
			//if success
				if(status=="Success"){
					
					window.location="calamity.php";    
				}
				else{
					alert("try again");
				}
			//load next page
			//else 
				//show alert try again

              

      });
    }
   

 </script>


</body>
</html>