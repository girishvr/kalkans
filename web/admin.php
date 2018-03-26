<?php
require("connection.php");
?>


<html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
<link rel="stylesheet" href="css/style1.css" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Roboto' rel="stylesheet" type="text/css">






<body style="font-family:Roboto">


	<div class="container-fluid">

	<div class="w3-card-4">
	<div class="w3-container w3-theme w3-card">
	<h1 style="font-size:30px;font-family:Roboto" align="center">Welcome to Control Room!!</h1>
	<br></div>
	</div>
	
	<td bgcolor = "#fff" width = "40%">
	<div class="btn-group" > 
	<button class="btn" onclick="goto()" style="position:absolute; right:50px; top:90px; font-family:Roboto" ><span> Departments</span></button>
	</div>
	</td>
</body>
	<script type="text/javascript">
	function goto(){
		window.location="showdepartment.php";
	}
	</script>
	
</html>






<?php	
$sql = 'SELECT * 
		FROM emergency ';
		
$query = mysqli_query($conn, $sql);

if (!$query) {
	die ('SQL Error: ' . mysqli_error($conn));
}
?>
<html>
<head>
	<title>Displaying MySQL Data in HTML Table</title>
	<link rel="stylesheet" href="css/style1.css" type="text/css">
</head>
<body>
	<!--<button class="btn" >ACTION</button>-->
	
	</br></br>

	<table class="data-table" style="font-family:Roboto">
		<!--<caption class="title">THE ALERTS INFORMATION</caption>-->
		</br>
		</br><thead>
			<tr>
				<th>EID</th>
				<th> Emergency Type</th>
				
				<th>Timestamp</th>
				<th>UserId</th>
				<th>Status</th>
				
				<th>SHOW PROFILE</th>
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
					<td>'.$row[6].'</td>
					<td><a href="details.php?id='.$row[5].'"><button >View Details</button></a></td>

						
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
		<!--<tfoot>
			<tr>
				<th colspan="4">TOTAL</th>
				<thth>
			</tr>
		</tfoot>-->
	</table>
	

</div>	
</body>
</html>
