<?php 
  $con = mysqli_connect("localhost","root","sqlrootpw","dbproject");
   mysqli_query("set names utf8");
   mysqli_set_charset($con, "utf8");

  $regDate = $_POST["regDate"];
  $userID = $_POST["userID"];
  $userPassword = base64_encode(hash('sha256', $_POST["userPassword"], true));
  //$userPassword = $_POST["userPassword"];
  $userGender = $_POST["userGender"];
  $userName = $_POST["userName"];
  $userEmail = $_POST["userEmail"];
  $userPhone = $_POST["userPhone"];
  $userbirth = $_POST["userbirth"];

  $result = mysqli_query($con, "SELECT IFNULL(MAX(userNum), 0)+1 FROM users");
  $row = mysqli_fetch_array($result);
  $userNum = (int)$row[0];
  
  $response = array();
  
  $statement = mysqli_prepare($con,"INSERT INTO users(userNum, userID, userPassword,
  userGender, userName, userBirth, userEmail, userPhone, regDate) 
  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
  mysqli_stmt_bind_param($statement, "issssssss", $userNum, $userID, $userPassword, 
  $userGender,$userName,$userbirth, $userEmail, $userPhone, $regDate);
  mysqli_stmt_execute($statement);
  $response["success"] = true;

  echo json_encode($response);
  

  ?>
