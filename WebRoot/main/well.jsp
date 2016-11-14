<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="width: 100%;height: 100%;">

	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox" style="width: 100%;height: 100%;">
	  
	  	<cc:forEach items="${requestScope.radvs }" var="adv" varStatus="vst">
	  	
	  		<div class="item ${vst.count==1?'active':'' }" style="width: 100%;height: 100%;">
	  			<a href="${adv.raurl }">
		    		<img src="/meilishuo/imgs/rolladv/${adv.raimg }" style="width: 100%;height: 100%;">
		    	</a>
		    </div>
	  	
	  	</cc:forEach>
	  	
	  </div>
	
	  <!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>