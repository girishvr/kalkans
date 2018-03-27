<html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="css/mapstyle.css" type="text/css">

<body>
<div class="w3-card-4">
<div class="w3-container w3-theme w3-card">
  <h1 style="font-size:30px;font-family:Roboto" align="center">WELCOME TO FIRE DEPARTMENT PORTAL!!</h1>
<br></div>
</div>


<br><div id="map" ></div>
	
	
	
	<?php
	session_start();
	require "connection.php";
	
	$rowid = $_GET['id'];
	
	$_SESSION["uid"] = $rowid;
	echo $_SESSION["uid"];
	
	
	
	
	
	$query1="select * from emergency where userId=".$rowid;
	$res=mysqli_query($conn,$query1);
	
	
	
		/*echo"<div class='btn-group' > 
			<button style='float:right;'>Alert Team</button></br></br></br>
			<button style='float:right;'>Action</button>
		</div>";*/
	echo "<div class=\"data-table\">";
	echo "<br><table align='center'><thead >";
	while ($row = mysqli_fetch_assoc($res)) {
	//echo "<th  style=\"font-size:19px;\">   EMERGENCY TYPE : ".$row['etype']."</th>";
	$mark1=$row['lattitude'];
	$mark2=$row['longitude'];
	
	
	
}
echo"</thead></table></div>";


echo "<script>
      function initMap() {
        var uluru = {lat: ".$mark1.", lng:". $mark2."};
		
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 5,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
		  animation:google.maps.Animation.BOUNCE,
          map: map
		  
        });
      }
	  </script> 
	  <script async defer
    src='https://maps.googleapis.com/maps/api/js?key=AIzaSyBmRlsjrYqOuCeESLXRDV95rKfE_xP_aNk&callback=initMap'>
   
    </script>
  
  
";
?>


<table width = "100%" border = "0">
         
         <tr valign = "top">
            <td bgcolor = "#fff" width = "30%">
               <img src='images/image.png' width="300" height="250"></img>
            </td>
				
            <td bgcolor = "#fff" height = "200" width = "30%">
<table id="t01">
  <tr>
    <th colspan='2' align="center">EMERGENCY TYPE FIRE</th>
    <!--<th>Lastname</th> 
    <th>Age</th>-->
  </tr>
  <tr>
    <td>UserId :</td>
    <td>1</td>
    
  </tr>
  <tr>
    <td>Name :</td>
    <td>Megha</td>
    
  </tr>
  <tr>
    <td>DOB :</td>
    <td>20/07/1996</td>
    
  </tr>
  <tr>
    <td>Gender   :</td>
    <td>Female</td>
    
  </tr>
  <tr>
    <td>Language  :</td>
    <td>English</td>
    
  </tr>
  <tr>
    <td>Address :</td>
    <td>Udyambag, Belagavi</td>
    
  </tr>
  
  
  
</table>

            </td>
				
            <td bgcolor = "#fff" width = "40%">
             <div class="btn-group" > 
			
			<button class="btn" onclick="alert1()" ><span>Alert Team</span></button>
			<button class="btn" onclick="Action()" ><span>Acknowledge</span></button>
			
			
		</div>
            </td>
         </tr>
         

<script type="text/javascript">
	function Action(){
		swal("Acknowledge message", {
		content: "input",
		buttons: {
			cancel: "Cancel",
			text: "Send",

		},
  
	})
	 
.then((value) => {
  //swal(`You typed: ${value}`);
  //SEND THE MSG TO USER
});
	}
	
	
	function alert1(){
		window.location="way.php";
}
</script>
</body>
</html>