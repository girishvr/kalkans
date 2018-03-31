<?php

require("connection.php");

if(isset($_GET['id'])) {
$txt= $_GET['id'];

echo $txt;
$query1="select * from emergency where userid=".$txt."";
	$result=mysqli_query($conn,$query1);
	
	
	
	while ($row = mysqli_fetch_assoc($result)) {
    
	$mark1=$row['lat'];
	$mark2=$row['lon'];

	

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
	  </script> ";

}



?>


<!DOCTYPE html>
<html>
  <head>
    <style>
       #map {
        min-height: 900px;
        float: left;
        width: 65%;
       }


    </style>
  </head>
  <body>
    <div>
  
   
	  <div id="map"></div>
		<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAMoFWu2K0pg05rtpMCyXOfx2eo-AgRZCE&callback=initMap">
    </script>
	</div>

		
	<div style="float: left	; width: 35%;">
  <p>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<?php
	
	//$query1="select * from emergency where userid='1a'";
	//$result=mysqli_query($conn,$query1);
	
	
	
	while ($row = mysqli_fetch_assoc($result)) {
    
	echo $row[1];
	}	
	
	?>
  </p>

  <br><br><br><br><br><br>
  <p>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspimage
  </p>
<br><br><br><br>
 <?php 
 echo '
 
    <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

		';
//echo "rgr";
if(isset($_GET['id'])) {
$txt= $_GET['id'];

echo $txt;
$query="SELECT * FROM users where userid=".$txt;
$result = mysqli_query($conn,$query);
echo "<table>";
//echo $result;
while($row = mysqli_fetch_array($result)) 
{ 
echo "<tr>"; 
echo "<td>" . $row[0] . "</td>";
echo "<td>" . $row[1] . "</td>"; 
echo "<td>" . $row[2] . "</td>"; 
echo "<td>" . $row[3] . "</td>"; 
echo "<td>" . $row[4] . "</td>"; 
echo "<td>" . $row[5] . "</td>"; 
echo "<td>" . $row[6] . "</td>"; 
echo "<td>" . $row[7] . "</td>"; 
echo "</tr>"; 
} 
echo "</table>"; 
}

 
?>
</p>
  

  </body>
</html>	
	<?php  mysqli_close($conn);   ?>	