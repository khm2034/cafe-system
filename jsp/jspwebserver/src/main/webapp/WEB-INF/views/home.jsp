<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset = "UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>OTO CAFE</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body>
        <div class="container">
            <image class="img-responsive center-block img-rounded" src = "images/main_banner.jpg">
            <form class="form-signin" method="post" action="managerLogin">
                <label for="id" class="sr-only">ID</label>
                <input type="text" id="id" name="id" class="form-control form-join" placeholder="ID" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="pw" name="pw" class="form-control form-join" placeholder="Password" required>
               
                <div class="center-block row form-join">
                    <button class="btn btn-lg btn-default col-xs-6" type="submit">로그인</button>
                    <button class="btn btn-lg btn-default col-xs-6" type="button" onclick="location.href='join'">회원가입</button>
                </div>
            </form>
        </div> 


        <script src= "https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
    </body> 
</html>