<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
            <form class="form-signin" method="post" action="managerInsert" onsubmit="return checkPw()">
	            <div class="form-subject">회원가입</div>
                <hr class="form-hr">
                
                <div class="row form-join">
                    <div class="col-xs-1"></div>
                    <label for="id" class="form-label col-xs-4" style="font-size:20px;">아이디 : </label>
                    <div class="col-xs-1"></div>
                    <input type="text" id="id" name="id" class="form-input col-xs-4" data-toggle="popover"  required autofocus>
                    
                    <!-- <button class="btn btn-lg btn-default col-xs-2 form-btn2" id="duplication">중복확인</button> -->
                </div>
                <div class="row form-join">
                    <div class="col-xs-1"></div>
                    <label for="password" class="form-label col-xs-4" style="font-size:20px;">비밀번호 : </label>
                    <div class="col-xs-1"></div>
                    <input type="password" id="pw" name="pw" class="form-input col-xs-4"  required >
                    <div class="col-xs-1"></div>
                </div>
                <div class="row form-join">
                    <div class="col-xs-1"></div>
                    <label for="checkId" class="form-label col-xs-4" style="font-size:20px;">비밀번호 확인 : </label>
                    <div class="col-xs-1"></div>
                    <input type="password" id="pw_check" class="form-input col-xs-4"  required >
                    <div class="col-xs-1"></div>
                </div>
                <div class="row form-join">
                    <div class="col-xs-1"></div>
                    <label for="name" class="form-label col-xs-4" style="font-size:20px;">이름 : </label>
                    <div class="col-xs-1"></div>
                    <input type="test" id="name" name="name" class="form-input col-xs-4"  required >
                    <div class="col-xs-1"></div>
                </div>
                <div class="row form-join">
                    <div class="col-xs-1"></div>
                    <label for="email" class="form-label col-xs-4" style="font-size:20px;">이메일 : </label>
                    <div class="col-xs-1"></div>
                    <input type="email" id="email" name ="email" class="form-input col-xs-4"  required >
                    <div class="col-xs-1"></div>
                </div>
                <div class="row form-join">
                    <div class="col-xs-1"></div>
                    <label for="phone" class="form-label col-xs-4" style="font-size:20px;">전화번호 : </label>
                    <div class="col-xs-1"></div>
                    <input type="tel" id="phone" name="phone" class="form-input col-xs-4"  required >
                    <div class="col-xs-1"></div>
                </div>
                <div class="row form-join">
                    <div class="col-xs-1"></div>
                    <label for="birth" class="form-label col-xs-4" style="font-size:20px;">생년월일 : </label>
                    <div class="col-xs-1"></div>
                    <input type="date" id="birth" name="birth" class="form-input col-xs-4"  required >
                    <div class="col-xs-1"></div>
                </div>
                <div class="row form-join">
                    <div class="col-xs-1"></div>
                    <label for="gender" class="form-label col-xs-4" style="font-size:20px;">성별 : </label>
                    <div class="col-xs-1"></div>
                    <select class="form-input col-xs-4" id="gender" name="gender" required>
                        <option value="남자">남자</option>
                        <option valut="여자">여자</option>
                    </select>
                    <div class="col-xs-1"></div>
                </div>
                <hr class="form-hr">
                <!--div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div-->

                <div class="center-block row form-btn">
                    <div class="col-xs-2"></div>
                    <button class="btn btn-lg btn-default col-xs-3" type="submit">회원가입</button>
                    <div class="col-xs-2"></div>
                    <button class="btn btn-lg btn-default col-xs-3" type="button" onclick="location.href='/jspweb/'">취소</button>
                    <div class="col-xs-2"></div>
                </div>
            </form>
        </div> 


        <script src= "https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript">
        
        $(document).ready(function(){
            //$("#id").keyup(idCheck);
            //$("#id").focus(idCheck);
            //$("#id").popover("destroy");
            $("#id").on('keyup focus', function(){
            	console.log($("#id").val());
            	var e = $(this);
            	var data;
            	if($("#id").val()){
	                var query = {id:$("#id").val()};
					$.ajax({
	                        url : "join/idCheck",
	                        type : "post",
	                        data : query,
	                        success : function(data) {
	                        	
	                            if(data == 1){
	                            	/*$("#id").popover('destroy').popover({
	                            		content : "이 아이디를 사용할 수 없습니다.",
	                            		placement : "right"
	                            	});*/
	                            	data = "이 아이디를 사용할 수 없습니다.";
	                            	
	                            	e.css("border-color", '#f96039');
	                            	console.log("1");
	                            } else if(data == -1){
	                            	/*$("#id").popover('destroy').popover({
	                            		content : "이 아이디를 사용할 수 있습니다.",
	                            		placement : "right"
	                            	});*/
	                            	data = "이 아이디를 사용할 수 있습니다.";
	                            	
	                            	e.css("border-color", '');
	                            	console.log("2");
	                            }
	                            
	                            var popover = e.attr('data-content', data).data('bs.popover');
	                            popover.$tip.addClass(popover.options.placement);
	                            
	                            e.popover({
	                            	trigger: 'manual',
                            		content : data,
                            		placement : "right"
                            	}).popover('show');
	                            
	                            
	                            //popover.setCotent();
	                            //$("#id").popover('show');
	                           // console.log("3");
	                        }
	                    });
                } else{
                	console.log("4");
                	data = "아이디를 입력해주세요.";
                	e.popover({
                		trigger: 'manual',
                		content : data,
                		placement : "right"
                	}).popover('show');
                	var popover = e.attr('data-content', data).data('bs.popover');
               	 	popover.$tip.addClass(popover.options.placement);
               	 	
               	 	e.popover('show');
                	
                	
                	
                	 
                     //popover.setCotent();
                	/*$("#id").popover({
                		trigger: 'manual',
                		content : "이 아이디를 입력해주세요.",
                		placement : "right"
                	}).popover('show');*/
                    //$("#id").popover('show');
                }
            });
            /*$("#id").blur(function(){
        		$(this).popover('destroy');
        	});*/
        });
        
	        function checkPw(){
	            var pw = document.getElementById("pw").value;
	            var checkPw = document.getElementById("pw_check").value;
	
	            if(pw != checkPw)
	            {
	                alert("비밀번호를 확인해주세요.");

                    document.getElementById("pw").value = "";
                    document.getElementById("pw_check").value = "";
	                return false;
	            }
	
	        }
	        
            

	        
        
        </script>
    </body>
</html>