<?php



$value=$_POST['uname'];
$pass=$_POST['pwd'];



	$url_dept_login ='http://smartindia-ers.herokuapp.com/dept_login/';
	$options_login = array(
		'http' => array(
		   'header'  =>array( "Content-type: application/json",
								'uname:'.$value,
								'password:'.$pass
							),
		   'method'  => 'GET',
		   
		),
	);
	$context_login = stream_context_create($options_login);
	$output_login = file_get_contents($url_dept_login, false,$context_login);

	 // $output_get_all_users = json_decode($output_get_all_user,true);
	//echo json_encode($output_login);
	echo $output_login;




?>