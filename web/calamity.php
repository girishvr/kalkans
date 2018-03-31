<!DOCTYPE html>
<html lang="en" >
<?php session_start(); 
header("Cache-Control: no cache");
session_cache_limiter("private_no_expire"); 
?>
<head><title> calamity details</title>
   <!--<link rel="stylesheet" type="text/css" href="login.css">-->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" /> 
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  
  <meta charset="utf-8">
  <meta http-equiv="refresh" content="5"/>
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">

  <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="css/style2.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">

  <!-- Latest compiled and minified JavaScript -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>

  <!-- Latest compiled and minified Locales -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
  
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
	  width:15%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 500px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
	
  </style>
  </head>



<body style="font-family:'Roboto', sans-serif">
	<div class="container-fluid">

<div class="w3-card-4" >
<div class="w3-container w3-theme w3-card" >
  <h1 style="font-size:30px;font-family:Roboto">Welcome to Fire Department Portal!!</h1> 
  

<br></div>
</div>


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      
      <ul class="nav nav-pills nav-stacked" width="30%">
       <!-- <li class="active"><a href="#section1">Home</a></li>-->
	   <li><a href="showdepartment.php"><b>Emergencies</b></a></li>
        <li><a href="teams.php?id=2">Show Teams</a></li>
        <li><a href="dilog/d/addteam.php" target="blank">Add Team Member</a></li>
		<li><a href="index.html">Logout</a></li>
        
      </ul><br>
    </div>

    <div class="col-sm-9">
	<br><br><br><br>


	<table class="data-table" id="table">
		
		<thead>
			<tr>
				<th data-field="eid">EID</th>
				<th data-field="etype">Type</th>
				<th data-field="lat">Lattitude</th>
				<th data-field="lon">Longitude</th>
				<th data-field="timestamp">Timestamp</th>
				<th data-field="user_id">UserId</th>
				<th data-field="text">Message</th>
				
				<th>View</th>
			</tr>
		</thead>
		<tbody align="center">
    <script language="javascript" type="text/javascript">
    	
      	$.post('emergency.php',function(responseText){
			//console.log(responseText);
      	myObj = JSON.parse(responseText);  
          //txt += "<table border='1'>"
				console.log(myObj);
        var tableData = myObj.result//[myObj]
				$('#table').bootstrapTable({
					data:tableData
				});

        console.log("calamity_count " + localStorage.calamity_count);
        console.log("length" + tableData.length);

        if (localStorage.calamity_count != 0){
          if (tableData.length > localStorage.calamity_count){
            //play sound
            var audio = new Audio('sound/audio_file.mp3');
            audio.play();
          }
          localStorage.calamity_count = tableData.length;
        }

		});
        $('#table').on("click-row.bs.table", function (editable, columns, row){
          
		      console.log(columns);
          localStorage.user_id = columns.user_id;
          console.log(localStorage.user_id);
    		  console.log(columns.etype);
		  
		      window.location="userprofile.php";
		  //session 

      });
	
        

			
		 

 </script>
<!--<script src="bootstrap-table-zh-CN.js"></script>-->

</body>
</html>