<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset = "UTF-8">
        <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>OTO CAFE</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/dashboard.css">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body style="background-color:mintcream;">
        <div role="tabpanel"> 
            
            <ul class="nav nav-tabs navbar-fixed-top" role="tablist">
              <li role="presentation" class="active" style="width:25%; background-color:#fff; border-width:1px; text-align:center;"><a href="#coffee" id="coffee-tab" aria-controls="coffee" role="tab" data-toggle="tab" class="customorder-tab">커피</a></li>
              <li role="presentation" style="width:25%; background-color:#fff; text-align:center;"><a href="#beverage" id="deverage-tab" aria-controls="beverage" role="tab" data-toggle="tab" class="customorder-tab">음료</a></li>
              <li role="presentation" style="width:25%; text-align:center; background-color:#fff;"><a href="#dessert" id="dessert-tab" aria-controls="dessert" role="tab" data-toggle="tab" class="customorder-tab">디저트</a></li>
              <li role="presentation" style="width:25%; text-align:center; background-color:#fff;"><a href="#order" id="order-tab" aria-controls="order" role="tab" data-toggle="tab" class="customorder-tab">주문내역</a></li>
            </ul>
            
            <div class = "tab-content" style="padding-top:10px;">
                <div role="tabpanel" class="tab-pane fade in active" id="coffee" aria-labelledby="coffee-tab">
                	<div role="tabpanel">
                		
                		<ul class="nav nav-tabs navbar-fixed-top" style="top:50px;"  role="tablist">
			              <li role="presentation" class="active" style="width:50%; background-color:#fff; text-align:center;"><a href="#chot" id="chot-tab" aria-controls="chot" role="tab" data-toggle="tab" class="customorder-tab">HOT</a></li>
			              <li role="presentation" style="width:50%; background-color:#fff; text-align:center;"><a href="#cice" id="cice-tab" aria-controls="cice" role="tab" data-toggle="tab" class="customorder-tab">ICE</a></li>
			            </ul>
			            <div class="tab-content" style="padding-top:50px;">
				            <div role="tabpanel" class="tab-pane fade in active" id="chot" aria-labelledby="chot-tab">
		                		<div class="tab-content">
					                <div class="table-responsive">
					                  <table class="table table-striped">
					                    <thead class="form-thead">
					                    </thead>
					                    <tbody>
					                        <c:forEach var="row" items="${cListHot}">
					                      <tr onclick="orderModal('${row.imageURL}','${row.name}', '${row.sPrice}', '${row.rPrice}', '${row.lPrice}', 1, 1);" style="background-color:#fbf2e7;">
					                          <td style="text-align:center;">
					                              <img class="img-responsive img-rounded" style="width: 50px; height: 60px; display:inline-block;" src = ${row.imageURL}>
					                          </td>
					                          <td>${row.name}</td>
					                          <td>small<br>regular<br>large</td>
					                          <td>${row.sPrice}원<br>${row.rPrice}원<br>${row.lPrice}원</td>
					                      </tr>
					                      </c:forEach>
					                    </tbody>
					                  </table>
					                 </div>
				                 </div>
			                 </div>
			                 <div role="tabpanel" class="tab-pane fade" id="cice" aria-labelledby="cice-tab">
		                		<div class="tab-content">
					                <div class="table-responsive">
					                  <table class="table table-striped">
					                    <thead class="form-thead">
					                    </thead>
					                    <tbody>
					                        <c:forEach var="row" items="${cListIce}">
					                      <tr onclick="orderModal('${row.imageURL}','${row.name}', '${row.sPrice}', '${row.rPrice}', '${row.lPrice}', 2, 1);" style="background-color:#fbf2e7;">
					                          <td style="text-align:center;">
					                              <img class="img-responsive img-rounded" style="width: 50px; height: 60px; display:inline-block;" src = ${row.imageURL}>
					                          </td>
					                          <td>${row.name}</td>
					                          <td>small<br>regular<br>large</td>
					                          <td>${row.sPrice}원<br>${row.rPrice}원<br>${row.lPrice}원</td>
					                      </tr>
					                      </c:forEach>
					                    </tbody>
					                  </table>
					                 </div>
				                 </div>
			                 </div>
		                 </div>
	                 </div> 
                 </div>
                      
                 <div role="tabpanel" class="tab-pane fade" id="beverage" aria-labelledby="beverage-tab">
                     <div role="tabpanel">
                		
                		<ul class="nav nav-tabs navbar-fixed-top" style="top:50px;" role="tablist">
			              <li role="presentation" class="active" style="width:50%; background-color:#fff; text-align:center;"><a href="#dhot" id="dhot-tab" aria-controls="dhot" role="tab" data-toggle="tab" class="customorder-tab">HOT</a></li>
			              <li role="presentation" style="width:50%; background-color:#fff; text-align:center;"><a href="#dice" id="dice-tab" aria-controls="dice" role="tab" data-toggle="tab" class="customorder-tab">ICE</a></li>
			            </ul>
			            <div class="tab-content" style="padding-top:50px;">
				            <div role="tabpanel" class="tab-pane fade in active" id="dhot" aria-labelledby="dhot-tab">
		                		<div class="tab-content">
					                <div class="table-responsive">
					                  <table class="table table-striped">
					                    <thead class="form-thead">
					                    </thead>
					                    <tbody>
					                        <c:forEach var="row" items="${bListHot}">
						                      <tr onclick="orderModal('${row.imageURL}','${row.name}', '${row.sPrice}', '${row.rPrice}', '${row.lPrice}' , 1, 2);" style="background-color:#fbf2e7;">
						                          <td style="text-align:center;">
						                              <img class="img-responsive img-rounded" style="width: 50px; height: 60px; display:inline-block;" src = ${row.imageURL}>
						                          </td>
						                          <td>${row.name}</td>
						                          <td>small<br>regular<br>large</td>
						                          <td>${row.sPrice}원<br>${row.rPrice}원<br>${row.lPrice}원</td>
						                      </tr>
					                      </c:forEach>
					                    </tbody>
					                  </table>
					                 </div>
				                 </div>
			                 </div>
			                 <div role="tabpanel" class="tab-pane fade" id="dice" aria-labelledby="dice-tab">
		                		<div class="tab-content">
					                <div class="table-responsive">
					                  <table class="table table-striped">
					                    <thead class="form-thead">
					                    </thead>
					                    <tbody>
					                        <c:forEach var="row" items="${bListIce}">
					                      <tr onclick="orderModal('${row.imageURL}','${row.name}', '${row.sPrice}', '${row.rPrice}', '${row.lPrice}' , 2, 2);" style="background-color:#fbf2e7;">
					                          <td style="text-align:center;">
					                              <img class="img-responsive img-rounded" style="width: 50px; height: 60px; display:inline-block;" src = ${row.imageURL}>
					                          </td>
					                          <td>${row.name}</td>
					                          <td>small<br>regular<br>large</td>
					                          <td>${row.sPrice}원<br>${row.rPrice}원<br>${row.lPrice}원</td>
					                      </tr>
					                      </c:forEach>
					                    </tbody>
					                  </table>
					                 </div>
				                 </div>
			                 </div>
		                 </div>
	                 </div> 
                 </div>
                 
                <div role="tabpanel" class="tab-pane fade" id="dessert" aria-labelledby="dessert-tab">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead class="form-thead">
                            </thead>
                            <tbody>
                                <c:forEach var="row" items="${dList}">
                                    <tr onclick="orderModal2('${row.imageURL}', '${row.name}', '${row.rPrice}', 3);" style="background-color:#fbf2e7;">
                                        <td style="text-align:center;">
                                            <img class="img-responsive img-rounded" style="width: 50px; height: 60px; display:inline-block;" src = ${row.imageURL}>
                                        </td>
                                        <td>${row.name}</td>
                                        <td>regular</td>
                                        <td>${row.rPrice}원</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                  
                    </div> 
                </div>

                <div role="tabpanel" class="tab-pane fade" id="order" aria-labelledby="order-tab">
                        <div class="table-	responsive">
                            <table class="table table-striped">
                                <thead class="form-thead">
	                                <tr>
					                    <th style="text-align:center; border-bottom-color:#ffdce2;padding-left: 3px;padding-right: 3px;">이미지</th>
					                    <th style="text-align:center; border-bottom-color:#ffdce2;padding-left: 3px;padding-right: 3px;">품명</th>
					                    <th style="text-align:center; border-bottom-color:#ffdce2;padding-left: 3px;padding-right: 3px;">사이즈</th>
					                    <th style="text-align:center; border-bottom-color:#ffdce2;padding-left: 3px;padding-right: 3px;">개수</th>
					                    <th style="text-align:center; border-bottom-color:#ffdce2;padding-left: 3px;padding-right: 3px;">가격</th>
					                    <th style="text-align:center; border-bottom-color:#ffdce2;padding-left: 3px;padding-right: 3px;">취소</th>
				               		</tr>
                                </thead>
                                <tbody id="orderList">
                                </tbody>
                            </table>
                        </div> 
                        <div style="text-align:right;">
	                        <label style="font-size:40px;width:20%; text-align : center;">금액 :</label>
	                        <input type="text" id="totalPrice" style="font-size:40px; width:40%; padding-left:20px; " value = "0" readOnly>
	                        <button class="btn btn-default" style="font-size:40px; width:35%; margin-bottom:10px"  onclick="orderToServer();">주문하기</button>
                        </div>
                        
                    </div>
              
                    
            </div>
        
        </div>
        
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">

                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="myModalLabel">상품 주문</h4>
                  <input type="text" style="display:none;" id="kind" name="kind" value="" >
                </div>
                <form method="post" action="" enctype="multipart/form-data">
                  <div class="modal-body" style="padding-left: 0px; padding-right: 0px; padding-bottom: 0px;">
                    <div class="container-fluid" style="padding-left: 5px; padding-right: 5px;">
                      <div class="col-xs-12 modal-data" style="margin-top:0px;">
                      	<div class="row" id ="image" style="text-align:center;">
                      		<div id="image-div" style="height: 100%; width: 100%">
                          		<img class="img-responsive img-rounded" id="modalImage" style="width: 150px; height: 180px; display:block; margin-left:auto; margin-right:auto;" src = "images/no_image.jpg">
                        	</div>
                      	</div>
                      	<div class="row" id ="data">
                      		<div class="row" id ="data">
                      		  <div class="col-xs-1"></div>
                      		  <div class="col-xs-8">
	                          	<label class ="form-label col-xs-4 modal-label" style="text-align:center;">품  명 : </label>
	                          	<input type="text" style="padding-left: 5px; padding-right: 5px;" id="modalName" name="modalName" class="form-input col-xs-8" readOnly="true" required>
	                          </div>
	                          <div class="col-xs-3"></div> 
	                        </div>
	                        <div class="row" id ="data">
	                          <div class="col-xs-1"></div>
	                          <div class="col-xs-8">
	                          	<label class ="form-label col-xs-4 modal-label" style="text-align:center;">총  액 : </label>
	                          	<input type="text" id="total" style="padding-left: 5px; padding-right: 5px;" name="total" class="form-input col-xs-8" readOnly="true" required>
	                          </div>
	                          <div class="col-xs-3"></div>
	                        </div>
                          	<div class="row" id ="data">
                          	  <div class="col-xs-1"></div>
	                          <div class="col-xs-8">
	                          	<label class ="form-label col-xs-4 modal-label" style="text-align:center;">Size : </label>
	                          	<select class = "form-input col-xs-8" id="size" name="size" style="padding-left:1px !important; margin-top:5px;" onchange="modalSize();" required>
			                          	<option value = "1">small</option>
			                          	<option value = "2">regular</option>
			                          	<option value = "3">large</option>
			                    </select>
			                    <input type="text" name="sPrice" id="sPrice" value="" style="display:none;">
			                    <input type="text" name="rPrice" id="rPrice" value="" style="display:none;">
			                    <input type="text" name="lPrice" id="lPrice" value="" style="display:none;">
	                          </div>
	                          <div class="col-xs-3"></div>
                        	</div>
                        	<div class="row" id ="data">
                        	  <div class="col-xs-1"></div>
	                          <div class="col-xs-8">
	                        	<label class ="form-label col-xs-4 modal-label" style="text-align:center;">H / I :</label>
	                          	<select class = "form-input col-xs-8" id="types" name="types" style="padding-left:3px !important; margin-top:5px;" readOnly="true" required>
			                    	<option value = "1">Hot</option>
			                        <option value = "2">Ice</option>
			                        <option value = "3">none</option>
			                    </select>
			                  </div>
			                  <div class="col-xs-3"></div>
	                        </div>
	                        <div class="row" id ="data">
	                          <div class="col-xs-1"></div>
	                          <div class="col-xs-8">
	                        	<label class ="form-label col-xs-4 modal-label" style="text-align:center">갯수 :</label>
	                          	<select class = "form-input col-xs-8" id="count" name="count" style="padding-left:3px !important; margin-top:5px;" onchange="modalCount(this);" required>
			                      <option value = "1">1개</option>
			                      <option value = "2">2개</option>
			                      <option value = "3">3개</option>
			                      <option value = "4">4개</option>
			                      <option value = "5">5개</option>
			                      <option value = "6">6개</option>
			                      <option value = "7">7개</option>
			                    </select>
	                          </div>
	                          <div class="col-xs-3"></div>
	                        </div>
                        </div>
                          
                        </div>
                      
                        
                      </div>
                    </div>
                    
	                    <div class="modal-footer">
	                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	                    <input type="text" id="uuid" name="uuid" style="display:none;" value="blank">
	                    <button type="button" class="btn btn-primary" style="background-color:#ffdce2; color:black; border-color:#ffdce2;" onclick="addOrderItem();">주문 추가</button>
	                  </div>
	                </form>
                    
                  </div>

                  
              </div>
            </div>
          </div>

        <script src= "https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        
        <script type="text/javascript">
    		var orderList = [];
    		var userNum = "0";
        
        	function orderModal(url, name, s, r, l, type, kind){
        		$("#myModal").modal("show");
        		$("#modalImage").attr("src", url);
        		$('#image-div').slideDown();
        		$('#modalName').val(name);
        		$('#total').val(s);
        		$('#size').attr("disabled", false);
        		$('#size').val('1').prop("selected", true);
        		$('#count').val('1').prop("selected", true);
        		$('#types').val(type).prop("selected", true);
        		$('#types').attr("disabled", true);
        		$("#sPrice").val(s);
        		$("#rPrice").val(r);
        		$("#lPrice").val(l);
        		$("#kind").val(kind);
        	}
        	
        	function orderModal2(url, name, r, kind){
        		$("#myModal").modal("show");
        		$("#modalImage").attr("src", url);
        		$('#image-div').slideDown();
        		$('#modalName').val(name);
        		$('#total').val(r);
        		$('#size').val('2').prop("selected", true);
        		$('#size').attr("disabled", true);
        		$('#count').val('1').prop("selected", true);
        		$('#types').val('3').prop("selected", true);
        		$('#types').attr("disabled", true);
        		$("#sPrice").val("0");
        		$("#rPrice").val(r);
        		$("#lPrice").val("0");
        		$("#kind").val(kind);
        	}
        	
        	function modalCount(elm){
        		var count = $(elm).val();
        		switch(parseInt($('#size').val())){
        		case 1:
        			var price = parseInt($('#sPrice').val());
        			$('#total').val(count*price);
        			break;
        		case 2:
        			var price = parseInt($('#rPrice').val());
        			$('#total').val(count*price);
        			break;
        		case 3:
        			var price = parseInt($('#lPrice').val());
        			$('#total').val(count*price);
        			break;
       			default :
       				break;
        		}
        		
        	}
        	
        	function modalSize(){
        		var count = $('#count').val();
        		switch(parseInt($('#size').val())){
        		case 1:
        			var price = parseInt($('#sPrice').val());
        			$('#total').val(count*price);
        			break;
        		case 2:
        			var price = parseInt($('#rPrice').val());
        			$('#total').val(count*price);
        			break;
        		case 3:
        			var price = parseInt($('#lPrice').val());
        			$('#total').val(count*price);
        			break;
       			default :
       				break;
        		}
        		
        	}
        	
        	
        	function orderItem(){
        		this.url;
        		this.name;
        		this.size;
        		this.count;
        		this.total;
        		this.type;
        		this.fullName;
        		this.kind;
        	}
        	
        	function addOrderItem(){
        		//사진, 이름, 사이즈, 갯수, 총액
        		$("#myModal").modal("hide");
        		var tmp = new orderItem();
        		
        		tmp.url = $("#modalImage").attr("src");
        		tmp.name = $('#modalName').val();
        		tmp.total = $('#total').val();
        		tmp.count = $('#count').val();
        		tmp.type = $('#types').val();
        		tmp.kind = $('#kind').val();
        		
        		switch(parseInt($('#size').val())){
        		case 1:
        			tmp.size = 'small';
        			break;
        		case 2:
        			tmp.size = 'ragular';
        			break;
        		case 3:
        			tmp.size = 'large';
        			break;
       			default:
       				break;
        			
        		}
        		
        		switch(parseInt(tmp.type)){
        		case 1:
        			tmp.fullName = tmp.name + '(HOT)';
        			break;
        		case 2:
        			tmp.fullName = tmp.name + '(ICE)';
        			break;
       			default:
       				tmp.fullName = tmp.name;
       				break;
        			
        		}
        		
        		
        		orderList.push(tmp);
        		addPrintList(tmp);
        		calTotal();
        		console.log(orderList);
        	}
        	
        	function addPrintList(item){
        		var contents = '';
        		
        		contents += '<tr style="background-color:#fbf2e7;">';
        		contents +=		'<td style="text-align:center;"><img class="img-responsive img-rounded" style="width: 50px; height: 60px; display:inline-block;" src='+ item.url +'></td>';
        		contents +=		'<td style="text-align:center;">' + item.fullName + '</td>';
        		contents +=		'<td style="text-align:center;">' + item.size + '</td>';
        		contents +=		'<td style="text-align:center;">' + item.count + '개</td>';
        		contents +=		'<td style="text-align:center;">' + item.total + '원</td>';
        		contents +=		'<td style="text-align:center;"><button type="button" class="btn btn-default" id="delItem" style="width:80%; height:80%;"onclick="delItem(\''+item.name+'\', \''+item.size+'\', \''+item.count+'\', \''+item.total+'\' , \''+item.type+'\', this);">취소</button></td>';
        		contents += '</tr>';
        		
        		$("#orderList").append(contents);
        	}
        	
        	function delItem(name, size, count, total, type, elm){
        		console.log(name + ", " + type + ", " + size + ", " + count + ", " + total);
        		$(elm).parent().parent().remove();
        		
        		for(var i=0; i < orderList.length ; i++){
        			
        			if((orderList[i].name == name) && (orderList[i].type == type) &&
        					(orderList[i].size == size) && (orderList[i].count == count) &&
        					(orderList[i].total == total)){
        				orderList.splice(i,1);
        				break;
        			}
        		}
        		console.log(orderList);
        		calTotal();
        	}
			
        	function calTotal(){
        		var tmp = 0;
        		for(var i=0; i<orderList.length ; i++){
        			console.log(orderList[i].total);
        			tmp = parseInt(tmp) + parseInt(orderList[i].total);
        			console.log(tmp);
        		}
        		
        		$('#totalPrice').val(tmp);
        	}
        	
        	function setNum(num){
        		userNum = num;
        	}
        	
        	function orderToServer(){
        		var sendUserNum = userNum;
        		var menu = "";
        		var fullMenu = "";
        		var count = "";
        		var size = "";
        		var totalByItem = "";
        		var typeByItem = "";
        		var kind = "";
        		var total;
        		
        		for(var i=0; i<orderList.length; i++){
        			menu += orderList[i].name + ',';
        			fullMenu += orderList[i].fullName + ',';
        			count += orderList[i].count + ',';
        			size += orderList[i].size + ',';
        			totalByItem  += orderList[i].total + ',';
        			kind += orderList[i].kind + ',';
        			console.log(orderList[i].kind);
        			switch(parseInt(orderList[i].type)){
        			case 1:
        				typeByItem += "H,";
        				break;
        			case 2:
        				typeByItem += "I,";
        				break;
        			default:
        				typeByItem += "N,";
        				break;
        			}
        			
        		}
        		
        		total = $('#totalPrice').val();
				
        		var query = {"userNum":sendUserNum, "menu":menu, "fullMenu":fullMenu, 
        				"count":count, "size":size, "total":total, "kind":kind, 
        				"totalByItem":totalByItem, "typeByItem":typeByItem};
				
				$.ajax({
					url : "order/insert",
					type : "post",
					data : query,
					success : function(data) {
						if(data == 1){
							allDeleteItem();
						}else{
							
						}
					}
				});	
        		
        	}
        	
        	function allDeleteItem(){
        		for(var i = 0; i < orderList.length; i++)
        			$("#orderList > tr:first").remove();
        		
        		orderList = [];
        		console.log(orderList);
        		$('#totalPrice').val("0");
        	}
        	
        </script>
    </body>
</html>