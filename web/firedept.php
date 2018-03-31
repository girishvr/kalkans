<?php
require("connection.php");
?>


<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="css/style2.css">










<body style="font-family:'Roboto', sans-serif">




<div class="container-fluid">

<div class="w3-card-4" >
<div class="w3-container w3-theme w3-card" >
  <h1 style="font-size:30px;font-family:Roboto;" align="center">Welcome to Fire Department Portal!!</h1>
<br></div>
</div>

</html>




			
			<button class="btn" style="position: absolute;right: 50px;top: 70px;"><span onclick="location.href = 'teams.php';">Team Members</span></button>
				
		
            



<?php	
$sql = 'SELECT * 
		FROM emergency where etype="fire" ';
		
$query = mysqli_query($conn, $sql);

if (!$query) {
	die ('SQL Error: ' . mysqli_error($conn));
}
?>
<html>
<head>
	<title>Displaying MySQL Data in HTML Table</title>
	<style type="text/css">
		
		
	</style>
</head>
<body style="font-family:'Roboto', sans-serif;">
<br><br><br>
	<table class="data-table">
		
		<thead>
			<tr>
				<th>EID</th>
				<th>Type</th>
				
				<th>Timestamp</th>
				<th>UserId</th>
				
				
				<th>View</th>
			</tr>
		</thead>
		<tbody>
		<?php
		$i 	= 0;
		//$total 	= 0;
		while ($row = mysqli_fetch_array($query))
		{
			
			$i=$i+1;
			
			echo '<tr>
					<td>'.$row[0].'</td>
					<td>'.$row[1].'</td>
					
					<td>'.$row[4].'</td>
					<td>'.$row[5].'</td>
				
					
					<td><a href="details.php?id='.$row[5].'"><button >View Details</button></a></td>

						
				</tr>';
				
				
			
		}
		
		
		?>
		
		 
		
		
		</tbody>
		
	</table>
	

</div>	
</body>
</html>
