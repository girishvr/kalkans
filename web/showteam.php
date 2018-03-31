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
  <meta http-equiv="refresh" content="15"/>
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
  



    <div class="col-sm-9">
	<br><br><br><br>


	<table class="data-table" id="table">
		
		<thead>
			<tr>
				<th data-field="team_id">TeamId</th>
				<th data-field="name">Name</th>
				<th data-field="dept_name">Department Name</th>
				<th data-field="phone">Phone</th>
				
				<!--<th>View</th>-->
			</tr>
		</thead>
		<tbody align="center">
    <script language="javascript" type="text/javascript">
    	
      	$.post('teamapi.php',function(responseText){
			console.log(responseText);
      	myObj = JSON.parse(responseText);  
          //txt += "<table border='1'>"
		console.log(myObj);
        var tableData = myObj//[myObj]
				$('#table').bootstrapTable({
					data:tableData
				});
				

        

		});
       
	
        

			
		 

 </script>
<!--<script src="bootstrap-table-zh-CN.js"></script>-->

</body>
</html>