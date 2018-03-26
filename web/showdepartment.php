<?php
require("connection.php");
?>



<html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="css/style1.css" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Roboto' rel="stylesheet" type="text/css">

<body style="font-family:Roboto">


<div class="container-fluid">

	<div class="w3-card-4">
	<div class="w3-container w3-theme w3-card">
	<h1 style="font-size:30px;font-family:Roboto" align="center">Welcome to Control Room!!</h1>
	<br></div>
</div>
	<script type='text/javascript'>
	function add(){
	
	window.location="dilog/index.html";
	}
</script>
	
	<td bgcolor = "#fff" width = "40%">
	<div class="btn-group" > 
	<button class="btn" style="position:absolute; right:50px; top:90px;" onclick="add()"><span>Add</span></button>
	</div>
	</td>




</body>
</html>

<?php	
$sql = 'SELECT * 
		FROM department ';
		
$query = mysqli_query($conn, $sql);

if (!$query) {
	die ('SQL Error: ' . mysqli_error($conn));
}
?>
<body style="font-family:Roboto">
	<table class="data-table" style="font-family:Roboto">
		<!--<caption class="title">THE ALERTS INFORMATION</caption>-->
		</br></br></br></br><thead>
			<tr>
				<th width="28%">Name</th>
				<th width="28%">Location</th>
				
				<th width="28%">Username</th>
				<th width="50%">Password</th>
				<!--<th>UserId</th>
				<th>Text</th>
				
				<th>SHOW PROFILE</th>-->
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
					
					<td>'.$row[1].'</td>
					<td>'.$row[2].'</td>
					<td>'.$row[3].'</td>
					<td>'.$row[4].'</td>
					

						
				</tr>';
	
		}
		
		
		?>
		</tbody>
		
	</table>
	
</body>
</html>