<!DOCTYPE html>
<html lang="en" >
<?php session_start(); 
header("Cache-Control: no cache");
session_cache_limiter("private_no_expire"); 
?>



<head>
  <meta charset="UTF-8">
  <title>Add teams</title>
  
  
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Roboto:400' rel='stylesheet' type='text/css'>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>

	<p id="demo"></p>


  <form method="POST"  >
  <h1>Enter Department Details </h1>
  <input placeholder="Name" type="text"  value="" name="name" required>
  <input placeholder="Phone" type="text"  value="" name="phone" required>
  <input placeholder="Department" type="text"  value="" name="dept	" required>
  
  <button type="submit" name="add" onclick="sendInfo()" >Add</button>
</form>

<!--<a href="https://twitter.com/mildrenben" target="_blank"><i class="fa fa-twitter"></i>Follow Me</a>-->


  
  

   <!-- <script  src="js/index.js"></script>-->

<script>


	function sendInfo(){
   //var obj, dbParam, xmlhttp, myObj,x, txt = "";
	//obj ={ "table":"jsontables", "limit":20 };
	//dbParam = JSON.stringify(obj);
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
         var myObj = JSON.parse(this.responseText);
		 console.log(myObj);
		 document.getElementById("demo").innerHTML = myObj.dept_name;
      // txt += "<table border='1'>"
        //for (x in myObj) {
			//console.log(JSON.stringify(myObj));
			//var data=JSON.stringify(myObj);
            //txt += "<tr><td>" + myObj[x].name+ "</td><td>" + myObj[x].phone + "</td></tr>";
			 
		
       
		
		console.log(myObj);
		
		}
		//txt += "</table>"
	//document.write(txt);		
	};
		
	xmlhttp.open("GET", "deptcheck.php", true);
	
	xmlhttp.send();
		
}		

</script>



</body>

</html>



