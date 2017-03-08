<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/jQuery/jquery-1.7.2.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="">
	    姓名：<input type="text" name="name" value=""><br/><br/>
	    地区：<input type="text" name="region" value=""><br/><br/>
	    地址：<input type="text" name="address" value=""><br/><br/>
	    手机号码：<input type="text" name="tel" value=""><br/><br/>
	    邮箱：<input type="text" name="email" value=""><br/><br/>
	    邮编：<input type="text" name="postcode" value=""><br/><br/>
	  <input id="subBtn" type="button" value="提  交">
	  
	</form>
	<script type="text/javascript">
		$(function(){
			$("#subBtn").click(function(){
				var name = $("input[name='name']").val();
				var region = $("input[name='region']").val();
				var address = $("input[name='address']").val();
				var tel = $("input[name='tel']").val();
				var email = $("input[name='email']").val();
				var postcode = $("input[name='postcode']").val();
				var params ={
						"name" :name,
						"region":region,
						"address":address,
						"tel":tel,
						"email":email,
						"postcode":postcode
				};
				$.ajax({
					   type: "POST",
					   url: "${pageContext.request.contextPath }/user/getCoffee",
					   data: params,
					   success: function(msg){
					     alert( "Data Saved: " + msg );
					   }
					});
			});
		});
	</script>
</body>
</html>