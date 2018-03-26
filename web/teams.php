<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
<link rel="stylesheet" href="css/style1.css" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<script src="sweetalert.min.js"></script>
</head>





<div class="container-fluid">

<div class="w3-card-4">
<div class="w3-container w3-theme w3-card">
<body>
  <h1 style="font-size:30px;font-family:'Roboto', sans-serif" align="center">Welcome to Fire Department Portal!!</h1>
</br></div>
</div>


             <!--<div class="btn-group" > -->
			
			<button class="btn" style="position: absolute;right: 50px;top: 70px;" ><span  onclick="addMember()" >Add Member</span></button>
				
		
           
			
			<script>
			 function addMember()
			 {
			
			
}
			</script>
			
			
			
			
			
			
		<br><br><br>	
	<table class="data-table">
		
		<thead>
			<tr>
				<th>Name</th>
				<th>Phone No.</th>
				
			</tr>
		</thead>
		<tbody>

<?php

require("connection.php");

$res="select * from `team` where deptName='fire'";
$query = mysqli_query($conn,$res);

		
		
		while ($row = mysqli_fetch_array($query))
		{
		
			
			echo '<tr>
					<td>'.$row[1].'</td>
					<td>'.$row[3].'</td>
					
				
					
						
				</tr>
				
				
				</tbody>
		
	</table>';
				
				
			
		}
		
		
		?>
		
		 
		
		
		


</div>
</body>

</html>


