<html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
<link rel="stylesheet" href="css/style.css" type="text/css">


<style>
.btn {


  display: block;
  margin: 30px auto;
  padding: 0;

  overflow: hidden;

  border-width: 0;
  outline: none;
  border-radius: 2px;
  box-shadow: 0 1px 4px rgba(0, 0, 0, .6);
  
  background-color: #164AA7;
  color: #ecf0f1;
  
  transition: background-color .3s;
}

.btn:hover, .btn:focus {
  background-color: #4797BC;
}

.btn > * {
  position: relative;
}

.btn span {
  display: block;
  padding: 5px 5px;
}

.btn:before {
  content: "";
  
  position: absolute;
  top: 50%;
 
  
  display: block;
  width: 0;
  padding-top: 0;
    
  border-radius: 100%;
  
  background-color: rgba(236, 240, 241, .3);
  
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}

.btn:active:before {
  width: 120%;
  padding-top: 120%;
  
  transition: width .2s ease-out, padding-top .2s ease-out;
}
	
	
	
	
	
	
	
	table {
    width:100%;
}
table, th, td {
    border: 0px solid white;
    border-collapse: collapse;
	font-family:"Roboto";
	
	
}
th, td {
    padding: 5px;
    text-align: left;
	text-align: center;
	font-size:20px;
	
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color: #fff;
}
table#t01 th {
	
    background-color: #164AA7;
    color: white;
}
	
	
	


	


#map {
        height: 400px;
        width: 100%;
		align:center;
       }

</style>










<body>
<div class="w3-card-4">
<div class="w3-container w3-theme w3-card">
  <h1 style="font-size:30px;font-family:Roboto" align="center">WELCOME TO FIRE DEPARTMENT PORTAL!!</h1>
<br></div>
</div>


<br><div id="map" ></div>
	
	
	
	<?php
	require "connection.php";
	
	$rowid = $_GET['id'];
	
	
	
	
	
	
	
	
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
    <td>Smith</td>
    
  </tr>
  <tr>
    <td>Name :</td>
    <td>Jackson</td>
    
  </tr>
  <tr>
    <td>DOB :</td>
    <td>Doe</td>
    
  </tr>
  <tr>
    <td>Gender   :</td>
    <td>Doe</td>
    
  </tr>
  <tr>
    <td>Language  :</td>
    <td>Doe</td>
    
  </tr>
  <tr>
    <td>Adhar No. :</td>
    <td>Doe</td>
    
  </tr>
  
  
  
</table>

            </td>
				
            <td bgcolor = "#fff" width = "40%">
             <div class="btn-group" > 
			
			<button class="btn" ><span>Alert Team</span></button>
			<button class="btn" ><span>Acknowledge</span></button>
			
			
		</div>
            </td>
         </tr>
         















</body>
</html>