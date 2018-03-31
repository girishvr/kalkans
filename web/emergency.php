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

	$value="NDM";

	$url_get_emergency ='http://smartindia-ers.herokuapp.com/getcalamitys';
	$options_get_emergency = array(
		'http' => array(
		   'header'  => array("Content-type: application/json",
							'DEPTTYPE:'.$value
						),
		   'method'  => 'GET',
		),
	);
	$context_get_emergency = stream_context_create($options_get_emergency);
	$output_get_emergency = file_get_contents($url_get_emergency, false,$context_get_emergency);

	 //$output_get_emergencys = json_decode($output_get_emergency,true);
	//echo json_encode($output_get_all_user);
	echo $output_get_emergency;




?>