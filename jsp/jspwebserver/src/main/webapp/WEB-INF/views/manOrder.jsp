<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset = "UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>OTO CAFE</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/dashboard.css">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body>
    	<nav class="navbar navbar-inverse navbar-fixed-top">
      		<div class="container-fluid">
        		<div class="navbar-header">
          			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			            <span class="sr-only">Toggle navigation</span>
			            <span class="icon-bar"></span>
			            <span class="icon-bar"></span>
			            <span class="icon-bar"></span>
          			</button>
         			<a class="navbar-brand" href="#">OTO CAFE</a>
        		</div>
        		<div id="navbar" class="navbar-collapse collapse">
		          <ul class="nav navbar-nav navbar-right">
		            <li><a href="manOrder">주문목록</a></li>
		            <li><a href="manList">상품리스트</a></li>
		            <li><a href="manSeat">좌석관리</a></li>
		            <li><a href="manUser">회원관리</a></li>
		            <li><a href="manStock">재고관리</a></li>
		            <li><a href="manProfit">판매실적</a></li>
		            <li><a href="/jspweb/">로그아웃</a></li>
		          </ul>
		        </div>
		      </div>
		    </nav>

    		<div class="container-fluid">
     			<div class="row">
        			<div class="col-sm-3 col-md-2 sidebar">
          				<ul class="nav nav-sidebar form-left-nav">
				            <li class="active"><a href="manOrder">주문목록<span class="sr-only">(current)</span></a></li>
				            <li><a href="manList">상품리스트</a></li>
				            <li><a href="manSeat">좌석관리</a></li>
				            <li><a href="manUser">회원관리</a></li>
				            <li><a href="manStock">재고관리</a></li>
			           		<li><a href="manProfit">판매실적</a></li>
				        </ul>
				    </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <image class="img-responsive center-block img-rounded" src = "images/main_banner.jpg">
            <div class="form-subject">
                    주문목록
                </div>
                <hr class="form-hr">
                <!--
          <h1 class="page-header">Dashboard</h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
          </div>

          <h2 class="sub-header">Section title</h2>
          -->
          <div class="table-responsive">
            <table class="table table-striped">
              <thead class="form-thead">
                <tr>
                  <th style="text-align:center;">날짜</th>
                  <th style="text-align:center;">주문번호</th>
                  <th style="text-align:center;">ID</th>
                  <th style="text-align:center;">주문메뉴</th>
                  <th style="text-align:center;">수량</th>
                  <th style="text-align:center;">사이즈</th>
                  <th style="text-align:center;">완료확인</th>
                </tr>
              </thead>
              <tbody class="form-tbody">
                <c:forEach var="row" items="${list}">
		                <tr>
		                	<td style="text-align:center;">${row.date}</td>
		                	<td style="text-align:center;">${row.orderNum}</td>
		                	<td style="text-align:center;">${row.id}</td>
		                	<td style="text-align:center;">
		                		<c:forTokens items="${row.fullMenu}" delims="," var="item">
		                			${item}<br>
		                		</c:forTokens>
		                	</td>
		                	<td style="text-align:center;">
		                		<c:forTokens items="${row.count}" delims="," var="item">
		                			${item}<br>
		                		</c:forTokens>
		                	</td>
		                	<td style="text-align:center;">
		                		<c:forTokens items="${row.size}" delims="," var="item">
		                			${item}<br>
		                		</c:forTokens>
		                	</td>
		                	<td style="text-align:center;">
		               			<button type="button" class="btn btn-default" onclick="submitFunc('${row.orderNum}', 'complete')">완료</button>
		                     	<button type="button" class="btn btn-default" onclick="submitFunc('${row.orderNum}', 'cancle')">취소</button>
		                    </td>  
		                </tr>
		                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
    </div>


        <script src= "https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script>
        
        	var orderItemNum = parseInt('${itemLength}');
        	
        	$(document).ready(function(){
        		setInterval(checkInsert, 1000);
        	});
        
        	function submitFunc(orderNum, type){
        		
				var query = {"orderNum":orderNum, "type":type};
				
				$.ajax({
					url : "manOrder/submit",
					type : "post",
					data : query,
					success : function(data) {
						if(data == 1){
							location.reload();
						}else{
							
						}
					}
				});	
        	}
        	
        	function checkInsert(){
        		$.ajax({
					url : "manOrder/checkCount",
					success : function(data) {
						if(orderItemNum != data)
							location.reload();
					}
				});	
        	}
        </script>
    </body>
</html>