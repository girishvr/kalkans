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



<script language="javascript">

   function getUsers()
   {



     
       console.log("Api Call");

         $.post('check.php', { value: "" }, function(data){

            console.log(data);
            // console.log(data[1]);
            // console.log(data[2]);

            mdata = JSON.parse(data);
            console.log(mdata)

            var jsonObj = $.parseJSON('[' + data + ']');

            console.log(jsonObj);

            for (i in jsonObj)
            {
               alert(jsonObj[i]["name"]);
            }

            // $.each(data, function(key, val){
            //     alert ("Response, " + val + "!" + key);
            //     console.log("Api Call Response");
            // });

 
        });


       // URL = "http://smartindia-ers.herokuapp.com/users/1/";

       // var xmlhttp = new XMLHttpRequest();

       // xmlhttp.responseType = 'text';
       // xmlhttp.open("GET", URL, true);
       // xmlhttp.setRequestHeader("Content-Type", "application/json");
       
       // // xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
       // alert(xmlhttp.requestText);
       // // alert("xmlhttp.responseXML");

       // xmlhttp.addEventListener("onreadystatechange", callbackFunction, false);
       // xmlhttp.send();
   }

   function callbackFunction(xmlhttp) 
   {
       alert("xmlhttp.responseXML");
       console.log(xmlhttp.response);
         console.log(xmlhttp.responseText);
   }
</script>


</body>
</html>