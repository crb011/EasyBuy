<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="HTML/css/style.css" />
<script type="text/javascript" src="HTML/scripts/function.js"></script>
	<script type="text/javascript">
		function test(page)
		{
			//传去servlet
			location.href="productliQuafy?page="+page;
		}
	</script>
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
	您现在的位置：<a href="/Easybuy/indexSer">易买网</a> &gt; <a href="indexSer">家用电器</a> &gt; 电视
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
								<dd><a href="productliSer?epc_id=${t.epc_id}">${t.epc_name}</a></dd>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<c:forEach items="${hislist}" var="i" varStatus="f">
					<dt><img width="50px" height="50px" src="HTML/images/product/${i.ep_file_name}" /></dt>
					<dd><a href="productviSer?id=${i.ep_id}">${i.ep_name}</a></dd>
				</c:forEach>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>
			<div class="pager">
				<ul class="clearfix">
					当前: 1 / 3 页
					<a href="#">首页</a>
					<a href="#">上一页</a>
					<a href="#">下一页</a>
					<a href="#">尾页</a>
					<select >
						<option value="1" >第 1 页</option>
						<option value="2" >第 2 页</option>
						<option value="3" >第 3 页</option>
					</select>
				</ul>
			</div>
			<div class="clear"></div>
			<ul class="product clearfix">
				<c:forEach items="${list}" var="i" varStatus="p">
					<li>
						<dl>
							<dt><a href="productviSer?id=${i.ep_id}" target="_blank"><img src="HTML/images/product/${i.ep_file_name}" /></a></dt>
							<dd class="title"><a href="productviSer?id=${i.ep_id}" target="_blank">${i.ep_description}</a></dd>
							<dd class="price">￥${i.ep_price}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					当前: 1 / 3 页
					<a href="#">首页</a>
					<a href="#">上一页</a>
					<a href="#">下一页</a>
					<a href="#">尾页</a>
					<select >
						<option value="1" >第 1 页</option>
						<option value="2" >第 2 页</option>
						<option value="3" >第 3 页</option>
					</select>
				</ul>
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
