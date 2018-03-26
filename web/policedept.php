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
	<style type="text/css">
		
		
		.btn {


  display: block;
  margin: 30px auto;
  padding: 0;

  overflow: hidden;

  border-width: 0;
  outline: none;
  border-radius: 2px;
  box-shadow: 0 1px 4px rgba(0, 0, 0, .6);
  
  background-color: #164AA7;
  color: #ecf0f1;
  
  transition: background-color .3s;
}

.btn:hover, .btn:focus {
  background-color: #4797BC;
}

.btn > * {
  position: relative;
}

.btn span {
  display: block;
  padding: 8px 8px;
}

.btn:before {
  content: "";
  
  position: absolute;
  top: 50%;
 
  
  display: block;
  width: 0;
  padding-top: 0;
    
  border-radius: 100%;
  
  background-color: rgba(236, 240, 241, .3);
  
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}

.btn:active:before {
  width: 80%;
  padding-top: 80%;
  
  transition: width .2s ease-out, padding-top .2s ease-out;
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		body {
			font-size: 15px;
			color: #343d44;
		font-family:'Roboto', sans-serif;
			padding: 0;
			margin: 0;
			font-family: "Roboto";
		}
		table {
			margin: auto;
			font-family: "Roboto";
			font-size: 20px;
		}

		h1 {
			margin: 25px auto 0;
			text-align: center;
			text-transform: uppercase;
			font-size: 20px;
			font-family: "Times New Roman", Times, serif;
		}

		table td {
			transition: all .5s;
			font-family: "Times New Roman", Times, serif;
			}
		
		/* Table */
		.data-table {
			border-collapse: collapse;
			font-size: 15px;
			min-width: 537px;
			font-family: "Times New Roman", Times, serif;
		}

		.data-table th, 
		.data-table td {
			border: 1px solid #e1edff;
			padding: 7px 17px;
			font-family: "Roboto";
		}
		.data-table caption {
			margin: 7px;
			font-family: "Times New Roman", Times, serif;
		}

		/* Table Header */
		.data-table thead th {
			background-color: #508abb;
			color: #FFFFFF;
			border-color: #6ea1cc !important;
			text-transform: uppercase;
			font-family: "Roboto"
		}

		/* Table Body */
		.data-table tbody td {
			color: #353535;
		}
		.data-table tbody td:first-child,
		.data-table tbody td:nth-child(4),
		.data-table tbody td:last-child {
			text-align: right;
			font-family: "Roboto";
		}

		.data-table tbody tr:nth-child(odd) td {
			background-color: #f4fbff;
		}
		.data-table tbody tr:hover td {
			background-color: #ffffa2;
			border-color: #ffff0f;
		}

		/* Table Footer */
		.data-table tfoot th {
			background-color: #e5f5ff;
			text-align: right;
		}
		.data-table tfoot th:first-child {
			text-align: left;
			font-family: "Roboto";
		}
		.data-table tbody td:empty
		{
			background-color: #ffcccc;
		}
		
		
		#yn 
		{
			width: 30px;
			height: 30px;
		}
		
		.title
		{
		font-size:50px;
		color:#111F11;
		
		}
		
		#update
		{
		font-size:30px;
		background-color: #111111;
		color:white;
		font-family: "Roboto";
		}
		

		
	</style>
</head>
<body >
	<table class="data-table" >
		<!--<caption class="title">The Alerts Info</caption>-->
		</br></br></br><thead style="font-family:'Roboto', sans-serif">
			<tr>
				<th>EID</th>
				<th>Type</th>
				<th>Lattitude</th>
				<th>Longitude</th>
				<th>Timestamp</th>
				<th>UserId</th>
				
				
				<th>Action</th>
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
					<td>'.$row[2].'</td>
					<td>'.$row[3].'</td>
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
