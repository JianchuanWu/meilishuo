<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML >
<html>
  <head>
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	<link rel="stylesheet" type="text/css" href="/meilishuo/dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="/meilishuo/dist/syscss/toolbar_right.css">
	<link rel="stylesheet" type="text/css" href="/meilishuo/dist/syscss/top.css">
	<link rel="stylesheet" type="text/css" href="/meilishuo/dist/syscss/main.css">
	
	
	<script type="text/javascript" src="/meilishuo/sysjs/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="/meilishuo/dist/js/bootstrap.min.js"></script>
	
	
	<style type="text/css">
		.container{
			height: 1600px;
		}
		#picimg{
			position: absolute;
			width: 180px;
			box-shadow: 6px 6px 26px gray;
		}
	</style>

  </head>
  
  <body>
    
	<div class="container">
	
	<form action="/meilishuo/mls/crol/orderinfo/mkorderinfoes" method="post">
	
		<jsp:include page="/main/top3.jsp"></jsp:include>
		<p style="font-size: 13px;color: red;">${requestScope.msg }</p>
		<div class="col-lg-10 col-lg-offset-1" style="margin-top: 26px;font-size: 12px;color: #666666;line-height: 40px;">
				
					<div class="col-lg-12 text-center" style="font-size: 12px;background-color: #fcfcfc;border: 1px solid #e6e6e6;height: 40px;">
					
						<div style="float: left;" class="col-lg-1">
							<input type="checkbox" role="chooseall" style="margin-top: 13px;float: left;margin-left: 20px;">
							<p style="float: left;margin-left: 10px;">全选</p>
						</div>
						
						<div class="col-lg-3">
							商品信息
						</div>
						
						<div class="col-lg-2 text-center" style="margin-left: -40px;">
							单价
						</div>
						
						<div class="col-lg-2 text-center" ">
							数量
						</div>
						
						<div class="col-lg-2 text-center">
							小计
						</div>
						
						<div class="col-lg-2 text-center">
							操作
						</div>
						
					</div>
			</div>
		
		
		
		
		
		<cc:forEach items="${requestScope.cart2 }" var="item">
		
			<cc:set var="store" value="${item.key }"></cc:set>
			<cc:set var="orderinfo" value="${item.value }"></cc:set>
			
			<div class="col-lg-10 col-lg-offset-1" style="font-size: 12px;color: #666666;line-height: 40px;padding: 0px;">
				<div style="float: left;margin-left: 20px;margin-top: 6px;" class="col-lg-12">
					<input type="checkbox" role="store" style="float: left;margin-top: 13px;">&nbsp;&nbsp;商家：${store.stname }
				</div>
				<cc:forEach items="${orderinfo.orderlists }" var="ol">
					<div class="col-lg-12 text-center" role='ol_item' style="font-size: 12px;background-color: #fcfcfc;border: 1px solid #e6e6e6;height: 120px;padding-top:20px;">
					
						<div style="float: left;margin: 20px;">
							<input type="checkbox" role='ol-cx' name="orderlist" value="${ol.goodsinfo.gdid}">
						</div>
						
						<div class="col-lg-1">
							<div role="pic" src="/meilishuo/imgs/tp/${ol.goodsinfo.goodsimages[1].gimgurl}" style="width: 80px;height: 80px;background-size:80px;border: 1px solid #e6e6e6;background-image: url('/meilishuo/imgs/tp/${ol.goodsinfo.goodsimages[1].gimgurl}')">
							</div>
						</div>
						
						<div class="col-lg-2 text-left">
							${ol.goodsinfo.gdname }
						</div>
						
						<div class="col-lg-2 text-center" role="price">
							${ol.goodsinfo.goodsprices[1].price }
						</div>
						
						<div class="col-lg-2 text-center" gdid="${ol.goodsinfo.gdid }" style="float: left;margin-top: 10px;padding-left: 60px;">
							
							
								<button id="bt_down" type="button" role="changecount" value="-1" 
			    					style="border:1px solid #e6e6e6;background-color: #ffffff;
			    					width: 20px;height: 25px;text-align: center;float: left;line-height: 20px;">
			    					<i class="glyphicon glyphicon-minus" style="margin-left: -3px;"></i>
			    				</button>
			    				
								<input 
			    					type="text" role="count" value="${ol.gdcount }" style="text-align: center;
			    					width: 30px;height: 25px;background-color: #ffffff;
			    					border: 1px solid #e6e6e6;float: left;border-right: 0px;
			    					border-left: 0px;line-height: 20px;">
			    					
			    				<button id="bt_up" type="button" role="changecount" value="1" 
				    				style="border:1px solid #e6e6e6;background-color: #ffffff;
				    				width: 20px;height: 25px;float: left;text-align: center;line-height: 20px;">
			    					<i class="glyphicon glyphicon-plus" style="margin-left: -3px;"></i>
			    				</button>
			    				
							
							
						</div>
						
						<div class="col-lg-2 text-center" role="g_ctandprice">
							${ol.goodsinfo.goodsprices[1].price*ol.gdcount }
						</div>
						
						<div class="col-lg-2 text-center">
							<a href="" style="color: #666666;">删除</a>
						</div>
						
					</div>
				</cc:forEach>
			</div>
		
		</cc:forEach>
		
	
	<div class="col-lg-10 col-lg-offset-1" 
		style="font-size: 12px;height: 60px;border: 1px solid #e6e6e6;
		margin-top: 26px;font-size: 12px;color: #666666;line-height: 60px;">
		<div>
		
			<div class="col-lg-10" style="float: left;" class="col-lg-1 text-center">
				<input type="checkbox" role="chooseall" style="margin-top: 23px;float: left;margin-left: 20px;">
				<p style="float: left;margin-left: 10px;">全选</p>
				
				<div class="pull-right" style="margin-right: 20px;">
					已选 <span id="ol_count">0</span> 件商品，合计（不含运费和优惠扣减）：<span id="sum">0.00</span>
				</div>
			</div>
			<div id="btjs" class="col-lg-2 text-center" data-toggle="modal" data-target="${sessionScope.activeUser!=null?'#myModal':'#login' }" style="background-color: #F36;color: #ffffff;font-size: 16px;">
				<a href="javascript:return void(0)" style="color: #ffffff;">去结算</a>
			</div>	
		</div>
		
	</div>
	
	
	
	
	<div class="modal fade bs-example-modal-lag" id="login" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      	<iframe src="/meilishuo/login2.html" style="width: 100%;height: 500px;border: 0px;" scrolling="no"></iframe>
	    </div>
	  </div>
	</div>
	
	
	
	
	
	
	<div class="modal fade bs-example-modal-sm" id="myModal" role="dialog" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content" style="margin-top: 160px;">
	      	
			
			  <div class="modal-header" style="background-color: #ff6699;color: #ffffff;line-height: 22px;height: 22px;">
		        <button type="button" class="close" data-dismiss="modal" style="margin-top: 1px;"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel" style="padding-left: 6px;padding-top: 2px;">
		        	<i class="glyphicon glyphicon-info-sign" style="font-size: 13px;float: left;"></i>
		        	<i style="float: left;font-size: 13px;">请务必将收货信息填写完整</i>
		        </h4>
		      </div>
		      
		      <div class="modal-body row" style="line-height: 60px;font-size: 13px;color: #ff6699;">
		      
			      <div class="col-lg-4 col-lg-offset-1 " style="height: 200px;padding-top: 20px;">
		        	<img src="/meilishuo/imgs/logo_1.png" style="margin-top: 30px;">
		        	<img src="/meilishuo/imgs/logo_2.png" style="margin-top: 30px;margin-left: 20px;">
			      </div>
			      
			      <div class="col-lg-6 " style="height: 200px;padding: 20px;">
			      	<div style="height: 30px;margin-top: 12px;line-height: 30px;">
			      		<i class="glyphicon glyphicon-home" style="float: left;width: 20%;height: 100%;background-color: #ff6699;text-align: center;font-size: 16px;padding-top: 5px;border: 1px solid #ff6699;color: #ffffff;margin-top: -1px;"></i>
						<input type="text" name="address" placeholder="联系地址" style="height: 100%;width: 80%;float: right;color: black;padding-left: 10px;">
					</div>
			      	<div style="height: 30px;margin-top: 12px;line-height: 30px;">
			      		<i class="glyphicon glyphicon-user" style="float: left;width: 20%;height: 100%;background-color: #ff6699;text-align: center;font-size: 16px;padding-top: 5px;border: 1px solid #ff6699;color: #ffffff;margin-top: -1px;"></i>
						<input type="text" name="recipient" placeholder="收件人" style="height: 100%;width: 80%;float: right;color: black;padding-left: 10px;">
					</div>
			      	<div style="height: 30px;margin-top: 12px;line-height: 30px;">
			      		<i class="glyphicon glyphicon-earphone" style="float: left;width: 20%;height: 100%;background-color: #ff6699;text-align: center;font-size: 16px;padding-top: 5px;border: 1px solid #ff6699;color: #ffffff;margin-top: -1px;"></i>
						<input type="text" name="contactnumber" placeholder="联系电话" style="height: 100%;width: 80%;float: right;color: black;padding-left: 10px;">
					</div>
			      </div>
			      
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal" style="font-size: 13px;margin-right: 10px;">关&nbsp;闭</button>
		        <button type="submit" class="btn btn-primary" style="font-size: 13px; margin-right: 60px;background-color: #F36;border: 0px;">提&nbsp;交</button>
		      </div>
		
		
	    </div>
	  </div>
	</div>
	
	</form>
	
		
	
		<br><br>
	</div>
	
	
	
  </body>
  
  <script type="text/javascript">
  
  
  	(function(){
  		$("").ready(function(){
  			
  			
  			$("#btjs").click(function(){
  				
  			});
  			
  			
  			
  			
  			
  			
  			$(":checkbox").click(function(){
  				getSum();
  			});
  			
  			function getSum(){
  				var sum=0;
  				var cks=$("[role='ol-cx']:checked");
  				$(cks).each(function(){
  					var vv=$(this).parents("[role='ol_item']").find("[role='g_ctandprice']").html();
  					sum+=parseInt(vv);
  				});
  				$("#ol_count").html(cks.size());
  				$("#sum").html("￥"+sum+".00");
  			}
  		
  		
  		
  			$("[role='store']").click(function(){
  				$(this).parent().parent().find(":checkbox").prop("checked",this.checked);
  				getSum();
  			});
  			
  			
  			$("[role='chooseall']").click(function(){
  				$("body :checkbox").prop("checked",this.checked);
  				getSum();
  			});
  		
  		
  		
  		
  			$("[role='pic']").mouseover(function(){
  				var picimg="<img class='img-thumbnail' src='"+$(this).attr('src')+"' id='picimg'>";
  				$("body").append(picimg);
  				$("#picimg").css('left',$(this).offset().left+100);
  				$("#picimg").css('top',$(this).offset().top);
  			}).mouseout(function(){
  				$("#picimg").remove();
  			});
  			
  			
  			$("[role='changecount']").click(function(){
  				var ipt_ct=$(this).parent().find("[role='count']");
  				var ct=parseInt(ipt_ct.val());
  				var val=parseInt($(this).val());
  				ct+=val;
  				var dt={'orderlist.goodsinfo.gdid':$(this).parent().attr("gdid"),'orderlist.gdcount':ct};
  				$.post("/meilishuo/mls/crol/cart/changect",dt,function(txt){
  				
  					var gcount=parseInt(txt)
  					
  					if(gcount==0){
  						
  						if($(ipt_ct).parents("[role='ol_item']").parent().find("[role='ol_item']").size()==1){
  							$(ipt_ct).parents("[role='ol_item']").parent().remove();
  						}else{
  							$(ipt_ct).parents("[role='ol_item']").remove();
  						}
  						getSum();
  					}
  					
  					ipt_ct.val(gcount);
  					
  					var price=parseInt($(ipt_ct).parents("[role='ol_item']").find("[role='price']").html());
  					var pricecount=$(ipt_ct).parents("[role='ol_item']").find("[role='g_ctandprice']");
  					
  					pricecount.html(price*gcount);
  					
  					getSum();
  					
  				});
  			});
  			
  			
  			
  		});
  	})();
  
  
  
  </script>
  
  
  
</html>
