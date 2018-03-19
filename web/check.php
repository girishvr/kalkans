<?php

include'connection.php';
session_start();
$f=0;

$uname=$_POST['user'];
$pass=$_POST['pass'];

if($uname=="medical" && $pass=="123")
header('location: medicaldept.php');


else if($uname=="fire" && $pass=="123")
header('location: firedept.php');

 else if($uname=="police" && $pass=="123")
header('location: policedept.php');

else if($uname=="ndm" && $pass=="123")
header('location: ndmdept.php');


else
{ 
echo "Wrong password. Try again.";
			header("Refresh: 5; URL=deptlogin.html");
			exit();
			
}








//$query=mysqli_query($con,"SELECT * FROM user WHERE username='$uname'");
//$query1=mysqli_query($con,"SELECT * FROM Admin WHERE uname='$uname'");



/*
while($row = mysqli_fetch_assoc($query1))
{
if($uname==$row['uname'] && $pass==$row['password'])
{
	header('location: adminLevels.php');
}
}
while($row = mysqli_fetch_assoc($query))
{ 
   
if($uname==$row['username'] && $pass==$row['password'])
{
$f=1;

if(isset($_POST['uname']) && isset($_POST['pass']))
{
$_SESSION['uname'] = $_POST['uname'];
$_SESSION['pass'] = $_POST['pass'];
}
	header('location: TestLevel.php');
}
}

if($f==0)
{
	echo "<script>alert(\"Enter valid Username and Password !!\");</script>";
	echo "<script>window.location='login.php'</script>";
}
*/	

?>