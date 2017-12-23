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
            <li><a href="manOrder">주문목록</a></li>
            <li><a href="manList">상품리스트</a></li>
            <li><a href="manSeat">좌석관리</a></li>
            <li><a href="manUser">회원관리</a></li>
            <li class="active"><a href="manStock">재고관리<span class="sr-only">(current)</span></a></li>
            <li><a href="manProfit">판매실적</a></li>
          </ul>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <image class="img-responsive center-block img-rounded" src = "images/main_banner.jpg">
            <div class="form-subject">
               	재고관리
            </div>
            <hr class="form-hr">
          
          <div class="table-responsive">
	         <table class="table table-striped">
	           <thead class="form-thead">
	             <tr>
	                <th>날짜</th>
	                <th>품목명</th>
	                <th>단가</th>
	                <th>수량</th>
	                <th></th>
	             </tr>
	           </thead>
	           <tbody>
          		<c:forEach var="row" items="${list}">
	             	
	              <tr>
	              	<td>${row.date}</td>
	              	<td>${row.name}</td>
	              	<td>${row.unitPrice}</td>
	              	<td>${row.amount}</td>
	              	<td>
	              		<form method="post" action="manStock/delete" >
	              			<button type="button" onclick="modalSetting('${row.date}', '${row.name}', '${row.unitPrice}', '${row.amount}', '${row.id}');" class="btn btn-default" data-toggle="modal" data-target="#myModal">수정</button>
	              			<input type="text" name="delId" style="display:none;" value="${row.id}">
	                    	<button type="submit" class="btn btn-default">삭제</button>
	                   	</form>
	                  </td>  
	              </tr>
	              
	             </c:forEach>
	           </tbody>
	         </table>
	       </div>
          
          <button class="btn btn-default" data-toggle="modal" data-target="#myModal" onclick="init();" >재고추가</button>

          <!-- Modal -->
          <div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm">
              <div class="modal-content">

                <form method="post" action="insertStock">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">재고 추가</h4>
                  </div>
                  <div class="modal-body">
                    <div class="container-fluid">
                      <div class="col-xs-12 modal-data">
                          <div class="row" id ="data">
                              <label class ="form-label col-xs-4 modal-label">날짜 : </label>
                              <input type="date" id="date" name="date" class="form-input col-xs-8"  required>
                          </div>
                          <div class="row" id ="data">
                              <label class ="form-label col-xs-4 modal-label">품명 : </label>
                              <input type="text" id="name" name="name" class="form-input col-xs-8"  required>
                          </div>
                          <div class="row" id ="data">
                              <label class ="form-label col-xs-3 modal-label">단가 : </label>
                              <input type="text" id="unitPrice" name="unitPrice" class="form-input col-xs-3"  required>

                              <label class ="form-label col-xs-3 modal-label">수량 : </label>
                              <input type="text" id="amount" name="amount" class="form-input col-xs-3"  required>
                          </div>
                      </div>
                    </div>
                  </div>

                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="submit" class="btn btn-primary">등록</button>
                    <input type="text" id="id" name="id" style="display:none;" value="black">
                  </div>
                </form>

              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
        <script src= "https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>

        <script>
          
	       function init(){
	           var date = new Date();
	           var now = setDateForm(date.getFullYear(), 4) + "-" 
	             + setDateForm(date.getMonth()+1, 2) + "-" + setDateForm(date.getDate(), 2);
	           console.log(now);
	           $("#date").val(now);
	           
	           $("#name").val();
	           $("#unitPrice").val();
	           $("#amount").val();
	           $("#id").val("blank");
	         }
	
	         function setDateForm(n, digit){
	           var zero="";
	           n = n.toString();
	
	           if(n.length < digit){
	             for(i = 0; i<digit-n.length; i++)
	               zero +='0';
	           }
	           return zero + n;
	         }
	         
	          
	         function modalSetting(date, name, unitPrice, amount, id){
	        	  
	       	 	$("#date").val(date);
		           
	            $("#name").val(name);
	        	$("#unitPrice").val(unitPrice);
	        	$("#amount").val(amount);
	        	$("#id").val(id);
	         }
          
        </script>
    </body>
</html>