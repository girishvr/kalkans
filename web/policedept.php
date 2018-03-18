<?php
session_start();
require("connection.php");
$conn = mysqli_connect($host, $username, $password, $db);
if (!$conn) {
	die ('Failed to connect to MySQL: ' . mysqli_connect_error());	
}

$sql = 'SELECT * 
		FROM emergency where type in ("fire" ,"accident" ,"woman safety" ,"terrorist" )' ;
		
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
			font-family: "segoe-ui", "open-sans", tahoma, arial;
			padding: 0;
			margin: 0;
		}
		table {
			margin: auto;
			font-family: "Lucida Sans Unicode", "Lucida Grande", "Segoe Ui";
			font-size: 12px;
		}

		h1 {
			margin: 25px auto 0;
			text-align: center;
			text-transform: uppercase;
			font-size: 17px;
		}

		table td {
			transition: all .5s;
		}
		
		/* Table */
		.data-table {
			border-collapse: collapse;
			font-size: 14px;
			min-width: 537px;
		}

		.data-table th, 
		.data-table td {
			border: 1px solid #e1edff;
			padding: 7px 17px;
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
			text-align: right;
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
		<caption class="title">The Alerts Info</caption>
		<thead>
			<tr>
				<th>EID</th>
				<th>Type</th>
				<th>Lattitude</th>
				<th>Longitude</th>
				<th>Timestamp</th>
				<th>UserId</th>
				<th>Status</th>
				
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		<?php
		$i 	= 0;
		//$total 	= 0;
		while ($row = mysqli_fetch_array($query))
		{
			//echo '<form method="POST">';
			$i=$i+1;
			$user=$row[0];
			//$amount  = $row['amount'] == 0 ? '' : number_format($row['amount']);
			echo '<tr>
					<td>'.$row[0].'</td>
					<td>'.$row[1].'</td>
					<td>'.$row[2].'</td>
					<td>'.$row[3].'</td>
					<td>'.$row[4].'</td>
					<td>'.$row[5].'</td>
				
					<td>'.$row[6].'</td>
					<td><button name="view" onclick="view('.$user.')">View Profile</button></td>
		
				</tr>';
				
				
				}
			?>
			 
		<script type="text/javascript" language="JavaScript">
                  function view(a)
            {
                
                window.location = 'control_panel2.html';
$_SESSION["user"]="a";
            }
             </script>
				
		
		
<!--<td><a href="profile.php"><button >View Profile</button></a></td>-->
		
		 
		
		
	
		
	</table>
	
</body>
</html>
