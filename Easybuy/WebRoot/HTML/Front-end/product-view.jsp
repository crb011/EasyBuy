<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="HTML/css/style.css" />
<script type="text/javascript" src="HTML/scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="HTML/images/logo.gif" /></div>
	<div class="help"><a href="shoppingQua" class="shopping">购物车</a><a href="guestbokSerFy">留言</a>
	<c:choose>
		<c:when test="${empty sessionScope.qtname}"><!-- 不存在的话-->
			<a href="loginSer">登录</a><a href="registerSer">注册</a>
		</c:when>
		<c:when test="${not empty sessionScope.qtname}"><!-- 存在的话 -->
			<a href="Seeionzx">注销</a><a href="indexSer">欢迎${sessionScope.qtname}登陆！</a>
		</c:when>
	</c:choose>
	</div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="indexSer">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="/Easybuy/indexSer">易买网</a> &gt; <a href="indexSer">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach items="${ea}" var="i" varStatus="a">
					<c:if test="${i.epc_parent_id eq 0}">
						<dt>${i.epc_name}</dt>
						<c:forEach items="${ea}" var="t" varStatus="b">
							<c:if test="${t.epc_parent_id == i.epc_id}">
								<dd><a href="productliQuafy?epc_id=${t.epc_id}">${t.epc_name}</a></dd>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
			</dl>
		</div>
	</div>
	<div id="product" class="main">
		<h1>${li.ep_name}</h1>
		<div class="infos">
			<div class="thumb"><img width="250px" height="210px" src="HTML/images/product/${li.ep_file_name}" /></div>
			<div class="buy">
				<p>商城价：<span class="price">￥${li.ep_price}</span></p>
				<p>库　存：${li.ep_stock}
				<%-- <c:choose>
					<c:when test="${li.ep_stock == 0}">无货</c:when>
					<c:when test="${li.ep_stock != 0}">有货</c:when>
				</c:choose> --%></p>
				<div class="button"><input type="button" name="button" value="" onclick="goBuy(1)" /><a href="shoppingSer?ep_id=${li.ep_id}">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${li.ep_description}<br/>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
		Copyright &copy; 开发年份 公司名 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
