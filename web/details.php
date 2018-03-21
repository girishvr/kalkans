

<!DOCTYPE html>
<html>
  <head>
    
	
	
	
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
		

		
       #map {
        height: 400px;
        width: 100%;
       }
	   .button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 7px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
	height: 26dp
	 transition: all 0.1s ease-in-out;
}



.button4 {border-radius: 9px;}
button:hover {
    background-color: red;
}
    </style>
  </head>
  <body>
    
    <div id="map"></div>
	
	
	
	<?php
	require "connection.php";
	
	$rowid = $_GET['id'];
	
	
	
	
	
	
	
	//echo $rowdetail;
	
	//require("conn.php");
	$query1="select * from emergency where userId=".$rowid;
	$res=mysqli_query($conn,$query1);
	
	
	
	
	while ($row = mysqli_fetch_assoc($res)) {
   echo "<div style='font-size:30px;' align='center'>    EMERGENCY TYPE : ".$row['etype']." </div>";
	$mark1=$row['lattitude'];
	$mark2=$row['longitude'];
	
	
	
}


echo "<script>
      function initMap() {
        var uluru = {lat: ".$mark1.", lng:". $mark2."};
		
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 5,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
	  </script> 
	  <script async defer
    src='https://maps.googleapis.com/maps/api/js?key=AIzaSyBmRlsjrYqOuCeESLXRDV95rKfE_xP_aNk&callback=initMap'>
   
    </script>
  

    ";

	
	$query2="select * from users where userId=".$rowid;
		$res=mysqli_query($conn,$query2);
	
echo "<div align = \"center\">";
	echo "<div class=\"data-table\">";
echo "<table><tr>";

echo "<td style=\"font-size:20px;\">   USERID : </br> NAME : </br>PHONE NO. : </br>GENDER : </br>DOB : </br>LANGUAGE : </br>ADHAR NO. : </td>";
	  	 echo "<div class=\"data-table\">";
	while ($row = mysqli_fetch_array($res)) {
		echo "<td style=\"font-size:20px;\">".$row[0]."</br>".$row[1]."</br>".$row[2]."</br>".$row[6]."</br>".$row[7]."</br>".$row[8]."</br>".$row[9]."</br></td>";
		
		echo"<td width='50%' style=\"font-size:20px;\"><button class='button button4' onclick='alertTeam()' ><h3>AlertTeam</h3></button></br></br><button class='button button4' onclick='Action()' ><h3>Action</h3></button></td>";
	
	}
   echo "</tr></table>";
   echo "</div>";

	echo "</div>";
echo"<script type='text/javascript'>function Action(){
if(confirm('SEND ACKNOWLEDGEMENT!!!')){
	//send msg to the help seeker
}

else
{
	alert(\"Not acknowleged!!!\");
}
}</script>";
	
	
	?>
	
	
	
    

