<?php
require("connection.php");
?>


<html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">








<body>


<div class="container-fluid">

<div class="w3-card-4">
<div class="w3-container w3-theme w3-card">
  <h1 style="font-size:30px;font-family:Times New Roman" align="center">Welcome to Fire Department Portal!!</h1>
<br></div>
</div>
</html>








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
		body {
			font-size: 15px;
			color: #343d44;
			font-family: "Times New Roman";
			padding: 0;
			margin: 0;
		}
		table {
			margin: auto;
			font-family: "Times New Roman";
			font-size: 20px;
		}

		h1 {
			margin: 25px auto 0;
			text-align: center;
			text-transform: uppercase;
			font-size: 10px;
		}

		table td {
			transition: all .5s;
		}
		
		/* Table */
		.data-table {
			border-collapse: collapse;
			font-size: 20px;
			min-width: 537px;
		}

		.data-table th, 
		.data-table td {
			border: 1px solid #e1edff;
			padding: 10px 10px;
		}
		.data-table caption {
			margin: 7px;
		}

		/* Table Header */
		.data-table thead th {
			background-color: #508abb;
			color: #FFFFFF;
			border-color: #6ea1cc !important;
			text-transform: uppercase;
		}

		/* Table Body */
		.data-table tbody td {
			color: #353535;
		}
		.data-table tbody td:first-child,
		.data-table tbody td:nth-child(4),
		.data-table tbody td:last-child {
			text-align: center;
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
		
    border: none;
    color: white;
    padding: 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 10px;
    margin: 4px 2px;
	height: 26dp;
	 transition: all 0.1s ease-in-out;
		}
		
			button:hover {
    background-color: #33FF90;
	
	
}
		
		
		#update
		{
		font-size:30px;
		background-color: #111111;
		color:white;
		}
		

		
	</style>
</head>
<body>
	<table class="data-table">
		<!--<caption class="title">THE ALERTS INFORMATION</caption>-->
		</br></br></br><thead>
			<tr>
				<th>EID</th>
				<th>Type</th>
				<th>Lattitude</th>
				<th>Longitude</th>
				<th>Timestamp</th>
				<th>UserId</th>
				<th>Text</th>
				
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
					<td>'.$row[2].'</td>
					<td>'.$row[3].'</td>
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
