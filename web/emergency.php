<?php

// include'connection.php';
// session_start();
// $f=0;

// $value=$_POST['value'];
// $pass=$_POST['pass'];



	$url_get_all_users ='http://smartindia-ers.herokuapp.com/calamitys/';
	$options_get_users = array(
		'http' => array(
		   'header'  => "Content-type: application/json\r\n",  
		   'method'  => 'GET',
		),
	);
	$context_get_users = stream_context_create($options_get_users);
	$output_get_all_user = file_get_contents($url_get_all_users, false,$context_get_users);

	 // $output_get_all_users = json_decode($output_get_all_user,true);
	//echo json_encode($output_get_all_user);
	echo $output_get_all_user;




?>