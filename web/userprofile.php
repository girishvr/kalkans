<!DOCTYPE html>
<html lang="en" >
<?php session_start(); 
header("Cache-Control: no cache");
session_cache_limiter("private_no_expire"); 
?>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="css/mapstyle.css" type="text/css">


<!--<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />--> 
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  
  <meta charset="utf-8">

  
  <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="css/style2.css">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">

  <!-- Latest compiled and minified JavaScript -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>

  <!-- Latest compiled and minified Locales -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
  


</head>
<body>
<div class="w3-card-4">
<div class="w3-container w3-theme w3-card">
  <h1 style="font-size:30px;font-family:Roboto" align="center">WELCOME TO FIRE DEPARTMENT PORTAL!!</h1>
<br></div>
</div>


<br><div id="map" ></div>
<script>
		var mark1=17.6343263, mark2=78.7354377;
      function initMap() {
        var uluru = {lat: mark1, lng:mark2};
		
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 5,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
		  animation:google.maps.Animation.BOUNCE,
          map: map
		  
        });
      }
	  </script> 
	  <script async defer
    src='https://maps.googleapis.com/maps/api/js?key=AIzaSyBmRlsjrYqOuCeESLXRDV95rKfE_xP_aNk&callback=initMap'>
   
    </script>
	


<div class="container-fluid">
  <div class="row content">
<table class="data-table" id="table">
		
		<thead>
			<tr>
				<th data-field="user_id">User Id</th>
				<th data-field="name">Name</th>
				<th data-field="DOB">DOB</th>
				<th data-field="gender">Gender</th>
				<!--<th >Timestamp</th>-->
				<th data-field="language">Language</th>
				<th data-field="adhar">Adhar Number</th>
				
				<!--<th>View</th>-->
			</tr>
		</thead>
		<tbody align="center">

  
  <script language="javascript" type="text/javascript">
    	
      	$.post('profileapi.php',function(responseText){
			console.log(responseText);
      		var myObj = JSON.parse(responseText);          
          //txt += "<table border='1'>"
				console.log(myObj);
				$('#table').bootstrapTable({
					data:myObj
				});

		});
       /* $('#table').on("click-row.bs.table", function (editable, columns, row){
          
			//window.location="details.php";
          // var col = ($(this).index());
          console.log(columns);
		  console.log(columns.user_id);
		  console.log(columns.etype);
		  //sessionStorage.setItem(columns.user_id);
			window.location="userprofsile.php";
                //display(one);
          // console.log(row);
			//Session["user_id"] = columns.user_id;
			//console.log(Session["user_id"]);
        });*/
	
        

			
		 

 </script>




</body>
</html>