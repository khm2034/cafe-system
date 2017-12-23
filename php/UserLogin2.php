<?php
  $con = mysqli_connect("localhost","root","sqlrootpw","dbproject");

   $userID = $_POST["userID"];
   $userPassword = base64_encode(hash('sha256' ,$_POST["userPassword"], true));
   //$userPassword = $_POST["userPassword"];

   $statement = mysqli_prepare($con,"SELECT *FROM users WHERE userID = ? AND userPassword = ?");
   mysqli_stmt_bind_param($statement,"ss",$userID,$userPassword);
   mysqli_stmt_execute($statement);

   mysqli_stmt_store_result($statement);
   mysqli_stmt_bind_result($statement,$userID);
 
   $response = array();
   $response["success"] = false;
   
   while(mysqli_stmt_fetch($statement)){
      $result = mysqli_query($con,"SELECT userNum FROM users WHERE userID = '$userID'");
      $row = mysqli_fetch_array($result);
      $response["userNum"] = $row['userNum'];
      $response["success"] = true;
   	
   }

   echo json_encode($response);
   ?>
   

