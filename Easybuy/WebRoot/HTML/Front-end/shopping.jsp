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
	您现在的位置：<a href="indexSer">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="shoppingreSer" method="post">
			<table>
				<tr>
					<th>&nbsp;</th>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${li}" var="i" varStatus="a">
					<tr id="product_id_1">
						<td><input type="checkbox" name=""></td>
						<td class="thumb"><img width="40px" height="40px" src="HTML/images/product/${i.EP_FILE_NAME}"/><a href="productviSer?id=${eas.ep_id}">${i.EP_NAME}</a></td>
						<td class="price" id="price_id_1">
							<span>￥${i.EOD_COST}</span>
						</td>
						<td class="number">
							<dl>
								<dt><input id="number_id_1" type="text" name="number" value="1" /></dt>
								<dd onclick="reloadPrice(1,true);">修改</dd>
							</dl>
						</td>
						<td class="delete"><a href="shoppingDel?EOD_ID=${i.EOD_ID}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer">
	Copyright &copy; 开发年份 公司名 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
