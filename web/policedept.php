<?php
session_start();
require("connection.php");
?>



<!doctype html>
<html lang="en">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="css/style2.css">


<body style="font-family:'Roboto', sans-serif">





<div class="w3-card-4">
<div class="w3-container w3-theme w3-card">
  <h1 style="font-size:30px;font-family:Roboto">Welcome to Police Department Portal!!</h1>
<br></div>
</div>

<button class="btn" style="position: absolute;right: 50px;top: 70px;"><span onclick="location.href = 'teams.php';">Team Members</span></button>
</html>







<?php

$sql = 'SELECT * 
		FROM emergency where etype in ("fire" ,"accident" ,"woman safety" ,"terrorist" )' ;
		
		
$query = mysqli_query($conn, $sql);
if (!$query) {
	die ('SQL Error: ' . mysqli_error($conn));
}
?>
<html>
<head>
	<title>Displaying MySQL Data in HTML Table</title>
	
</head>
<body >
	<table class="data-table" >
		<!--<caption class="title">The Alerts Info</caption>-->
		</br></br></br><thead style="font-family:'Roboto', sans-serif">
			<tr>
				<th>EID</th>
				<th>Type</th>
				
				<th>Timestamp</th>
				<th>UserId</th>
				
				
				<th>View</th>
			</tr>
		</thead>
		<tbody style="font-family:Times New Roman">
		<?php
		//$i 	= 0;
		//$total 	= 0;
		while ($row = mysqli_fetch_array($query))
		{
			//echo '<form method="POST">';
			//$i=$i+1;
			//$user=$row[0];
			//$amount  = $row['amount'] == 0 ? '' : number_format($row['amount']);
			echo '<tr style="font-family:Times New Roman">
					<td>'.$row[0].'</td>
					<td>'.$row[1].'</td>
					
					<td>'.$row[4].'</td>
					
				
					<td>'.$row[6].'</td>';
					
		echo '<td><a href="details.php?id='.$row[5].' "><button name="view" >VIEW DETAILS</button></a></td> 
				</tr>';
				
				
				}
			?>
			 
		
                 
				
		
		
<!--<td><a href="profile.php"><button >View Profile</button></a></td>-->
		
		 
		
		
	
		
	</table>
	
</body>
</html>
