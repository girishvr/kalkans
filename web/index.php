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
		
         <button type="submit" onclick="javascript:getUsers()"><span>LOGIN</span></button>
      </div>

      <!--<a href="" class="pass-forgot">Forgot your password?</a>-->

   </div>
</div>
  

</form>



<script language="javascript" type="text/javascript">
    function getUsers(){
    	
      	$.post('check.php',function(responseText){
          
          var txt = "";      		
      		myObj = JSON.parse(responseText);          
          txt += "<table border='1'>"

              for (x in myObj) {
                var data=JSON.stringify(myObj);
                txt += "<tr><td>" + myObj[x].name+ "</td><td>" + myObj[x].phone + "</td></tr>";
                txt += "</table>" 
                document.write(txt);
      	}

      });
    }
   

 </script>


</body>
</html>