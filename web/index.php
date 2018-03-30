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
		console.log(responseText);
		myObj = JSON.parse(responseText);
		console.log(myObj);
        txt += "<table border='1'>"
        for (x in myObj) {
			console.log(JSON.stringify(myObj));
			//var data=JSON.stringify(myObj);
            txt += "<tr><td>" + myObj[x].name+ "</td><td>" + myObj[x].phone + "</td></tr>";
			 
       
        txt += "</table>" 
		
       document.write(txt);
		
		console.log(myObj);
	}
});
}
   /*var obj, dbParam, xmlhttp, myObj,x, txt = "";
	obj ={ "table":"jsontables", "limit":20 };
	dbParam = JSON.stringify(obj);
	xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        myObj = JSON.parse(this.responseText);
        txt += "<table border='1'>"
        for (x in myObj) {
			console.log(JSON.stringify(myObj));
			//var data=JSON.stringify(myObj);
            txt += "<tr><td>" + myObj[x].name+ "</td><td>" + myObj[x].phone + "</td></tr>";
			 
       
        txt += "</table>" 
		
       document.write(txt);
		
		console.log(myObj);
		}
};
	}
xmlhttp.open("POST", "check.php", true);
xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xmlhttp.send("x=" + dbParam);
*/


			



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
   

   /*function callbackFunction(xmlhttp) 
   {
       alert("xmlhttp.responseXML");
       console.log(xmlhttp.response);
         console.log(xmlhttp.responseText);
   }*/
</script>


</body>
</html>