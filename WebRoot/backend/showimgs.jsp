<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showimgs.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">

	
	
	<link rel="stylesheet" type="text/css" href="/meilishuo/dist/css/bootstrap.css">
    
    <script type="text/javascript" src="/meilishuo/sysjs/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="/meilishuo/dist/js/bootstrap.min.js"></script>
	
	<style type="text/css">
	
	.container{width: 100%;height:600px;}
	img{width: 50px;height: 50px;margin: 10px;box-shadow:0px 0px 5px black;}
	img:HOVER {
		box-shadow:0px 0px 13px #337ab7;
}
	
	
	</style>

  </head>
  <body>
    <div class="container">
    	
    	<%-- 根据请求作用域中的属性获取upload文件夹中的图片名称结合路径显示 --%>
    	<cc:forEach items="${requestScope.urls }" var="url">
    	
    		<img src="/meilishuo/upload/${url }" value="${url }" class="img-rounded">
    	
    	</cc:forEach>
    
    
    </div>
  </body>
  
  
  
  <script type="text/javascript">
  
  (function(){
  
  	var types;
  	
  	$("").ready(function(){
  	
  		//设置每张img的点击事件，为商品选择图片
  		$(".container img").click(function(){
  			//通过父窗口查找元素并附属性值（src用于显示）
  			$(window.parent.document).find("#${requestScope.imgid}").attr("src",this.src);
  			
  			//通过父窗口查找元素并附属性值（value用于记录值）
  			$(window.parent.document).find("#${requestScope.imgid}").attr("value",$(this).attr("value"));
  		
  		});
  		
  		//如upload文件夹中图片过多则采取页面滚动加载剩余项的方式显示
  		$(window).scroll(function(){
  		
  			if($("body").scrollTop>=($("img:last").offset().top-300)){
  			
  				$.post("/meilishuo/mls/becrol/goodsinfo/showrest",function(txt){
  				
  					var data=eval(txt);
  					$(data).each(function(){
  					
  						var img="<img src='/meilishuo/upload/'"+this.url+" class='img-rounded' />";
  						$(".container").append(img);
  					
  					});
  				
  				
  				});
  			
  			
  			}
  		
  		
  		});
  	
  	
  	
  	});
  
  
  
  
  
  })();
  
  
  
  
  
  </script>
  
  
  
  
  
  
</html>
