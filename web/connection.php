<?php
$host="localhost";
$username="root";
$password="";
$db="sih18";

$conn=mysqli_connect($host,$username,$password,$db);
if(mysqli_connect_error())
echo "Connection failed ! ".mysqli_connect_error();
?>