<?php
require("connection.php");
?>


<html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/style2.css">

<body style="font-family:'Roboto', sans-serif">

<div class="w3-card-4">
<div class="w3-container w3-theme w3-card">
  <h1 style="font-size:30px;">Welcome to Medical Department Portal!!</h1>
<br></div>
</div>

<button class="btn" style="position: absolute;right: 50px;top: 70px;"><span onclick="location.href = 'teams.php';">Team Members</span></button>
</html>







<?php

$query = mysqli_query($conn, "SELECT * 
		FROM emergency WHERE etype in ('flood','fire' )" );

if (!$query) {
	die ('SQL Error: ' . mysqli_error($conn));
}
?>
<html>
<head>
	<title>Displaying MySQL Data in HTML Table</title>
	
</head>
<body >
	<table class="data-table">
		<!--<caption class="title">The Alerts Info</caption>-->
		</br></br></br><thead>
			<tr>
				<th>EID</th>
				<th>Type</th>
				
				<th>Timestamp</th>
				<th>UserId</th>
				
				<th>Show Profile</th>	
			</tr>
		</thead>
		<tbody>
		<?php
		$i 	= 0;
		//$total 	= 0;
		while ($row = mysqli_fetch_array($query))
		{
		
			//$amount  = $row['amount'] == 0 ? '' : number_format($row['amount']);
			echo '<tr>
					<td>'.$row[0].'</td>
					<td>'.$row[1].'</td>
					
					<td>'.$row[4].'</td>
					
				
					<td>'.$row[6].'</td>
					<td><a href="details.php?id='.$row[5].'" ><button target="blank">VIEW DETAILS</button></a></td>

						
				</tr>';
				
				
			//$total += $row['amount'];
			//$no++;
			
			
			 /*$.each($("input[name='yn']:checked"), function(){            
                favorite.push($(this).val());
            });
			echo val;
			*/
		}
		
		
		?>
		
		 
		
		
		</tbody>
		
	</table>
	

	
	
</body>
</html>
