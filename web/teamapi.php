<?php

// include'connection.php';
// session_start();
// $f=0;

// $value=$_POST['value'];
// $pass=$_POST['pass'];
// Fire_dept
// Police_dept
// Ambulance
// NDM

	//$value="NDM";

	$url_get_teams='http://smartindia-ers.herokuapp.com/teams/';
	$options_get_teams = array(
		'http' => array(
		   'header'  => "Content-type: application/json",
							
		   'method'  => 'GET'
		),
	);
	$context_get_teams= stream_context_create($options_get_teams);
	$output_get_team = file_get_contents($url_get_teams, false,$context_get_teams);

	 //$output_get_emergencys = json_decode($output_get_emergency,true);
	//echo json_encode($output_get_all_user);
	echo $output_get_team;




?>