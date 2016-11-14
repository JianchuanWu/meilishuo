<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 首页导航 1 -->
    <div id="tp1">
    	<div class="pull-right" style="margin-right: 60px;">
    		<a href="">帮助中心</a>
    	</div>
    	<div class="pull-right">
    		<a href=""><i class="glyphicon glyphicon-phone" style="color: "></i>&nbsp;&nbsp;&nbsp;下载App</a>
    	</div>
    	<div class="pull-right">
    		<a href=""><i class="glyphicon glyphicon-user" style="color: "></i>&nbsp;&nbsp;&nbsp;美丽说会员</a>
    	</div>
    	<div class="pull-right">
    		<a href=""><i class="glyphicon glyphicon-file" style="color: "></i>&nbsp;&nbsp;&nbsp;我的订单</a>
    	</div>
    	<div class="pull-right">
    		<a href="/meilishuo/mls/crol/cart/tocart"><i class="glyphicon glyphicon-shopping-cart" style="color: #ff6699;"></i>&nbsp;&nbsp;&nbsp;帮我的购物车</a>
    	</div>
    	<div class="pull-right">
    		<a href="">注册</a>
    	</div>
    	<div class="pull-right">
    		<a href="">登录</a>
    	</div>
    	<div class="pull-right">
    		<a href=""><img src="/meilishuo/imgs/qq.jpg" style="width: 20px;float: left;margin-top: -2.5;">QQ登录</a>
    	</div>
    	<div class="pull-right" style="border: 0px;">
    		<a href=""><img src="/meilishuo/imgs/weixin.jpg" style="width: 20px;float: left;margin-top: -2.5;">微信登录</a>
    	</div>
    </div>
    
    <!-- 首页导航 2 -->
    <div id="tp2">
    	<div class="col-lg-10 col-lg-offset-1">
    		
    		<div class="col-lg-5">
    			<a href="/meilishuo/mls/index/welcome" style="color: #535353;">
    			<img src="/meilishuo/imgs/logo_1.png" style="margin-top: 30px;">
    			<img src="/meilishuo/imgs/logo_2.png" style="margin-top: 30px;margin-left: 20px;">
    			</a>
    		</div>
    		
    		<div class="col-lg-6" style="margin-top: 56px;margin-left: 20;">
    		
    			<div class="col-lg-10" style="background-color: #ff6699;padding: 2px;">
    				<input placeholder="搜索商品"
    					 style="width: 85%;float: left;height: 27px;border-radius: 0px;border: 0px;font-size: 13px;" 
    					 type="text" class="form-control" />
    				<button class="btn btn-xs" 
    					style="background-color: transparent;margin-left:10px;
    					color: #ffffff;font-size: 13px;margin-top: 2px;">
    					搜全站
    				</button>
    			</div>
    			
    			<button style="border: 0px;height: 31px;font-size: 13px;
    				color: #ffffff;background-color: #4d4d4d;margin-left: 5px;width: 70px;">
    				搜本店
    			</button>
    			
    		</div>
    	</div>
    </div>
    
    <div id="dianpulogo">
    	<img alt="" src="/meilishuo/imgs/dianpu.png">
    </div>
    
    <div id="toolbar" style="background-color: #333333;padding: 8px;">
    	<a href="" style="color: white;margin-left: 100px;">店铺首页</a>
    	<a href="" style="color: white;margin-left: 40px;">新品到货</a>
    	<a href="" style="color: white;margin-left: 40px;">T恤</a>
    	<a href="" style="color: white;margin-left: 40px;">连衣裙</a>
    	<a href="" style="color: white;margin-left: 40px;">卫衣</a>
    	<a href="" style="color: white;margin-left: 40px;">外套</a>
    	<a href="" style="color: white;margin-left: 40px;">针织衫</a>
    	<a href="" style="color: white;margin-left: 40px;">裤子</a>
    	<a href="" style="color: white;margin-left: 40px;">毛呢、羽绒服、棉衣</a>
    </div>
  
    
    <script type="text/javascript">
    
    	//用于顶部导航滚动跟随的方法
 			function top3_beScroll(){
 				$(window).scroll(function(){
 					
 					if($(window).scrollTop()>=100){
	  					$("#to_Top").show();
	  				}else{
	  					$("#to_Top").hide();				
	  				}
 				
	  				if($(window).scrollTop()>=$("#dianpulogo").offset().top+$("#dianpulogo").height()){
	  					$("#toolbar").addClass("toolbar_scroll");
	  				}else{
	  					$("#toolbar").removeClass("toolbar_scroll");  					
	  				}
 				});
 			}
 			top3_beScroll();
  	
    </script>