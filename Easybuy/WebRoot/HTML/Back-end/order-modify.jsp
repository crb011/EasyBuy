<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.Date"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="HTML/css/style.css" />
<script type="text/javascript" src="HTML/scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="HTML/images/logo.gif" /></div>
	<div class="help"><a href="/Easybuy/indexSer">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="/Easybuy/indexSer">首页</a></li>
			<li><a href="userQuafy">用户</a></li>
			<li><a href="productClassSer">商品</a></li>
			<li class="current"><a href="orderQuafy">订单</a></li>
			<li><a href="guestbookQuafy">留言</a></li>
			<li><a href="newsQuafy">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员 [ admin ] 您好，今天是<%=new Date(System.currentTimeMillis()).toString() %>，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="indexSerHT">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="userAddSer">新增</a></em><a href="userQuafy">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="productClassAddSer">新增</a></em><a href="productClassSer">分类管理</a></dd>
				<dd><em><a href="productAddSer">新增</a></em><a href="productQuafy">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="orderQuafy">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbookQuafy">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="newsAddSer">新增</a></em><a href="newsQuafy">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>修改订单</h2>
		<div class="manage">
			<form action="orderUpd" method="post">
				<input type="hidden" name="id" value="${li.eo_id}"/>
				<input type="hidden" name="dianhua" value="${li.eo_user_tel}"/>
				<input type="hidden" name="time" value="${li.eo_create_time}"/>
				<input type="hidden" name="fukfs" value="${li.eo_type}"/>
				<table class="form">
					<tr>
						<td class="field">订单ID：</td>
						<td><input type="text" class="text" name="orderId" value="${li.eo_user_id}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">订购人姓名：</td>
						<td><input type="text" class="text" name="name" value="${li.eo_user_name}" /></td>
					</tr>
					<tr>
						<td class="field">收货地址</td>
						<td><input type="text" class="text" name="addres" value="${li.eo_user_address}" /></td>
					</tr>
					<tr>
						<td class="field">总价格</td>
						<td><input type="text" class="text" name="cost" value="${li.eo_cost}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">订单状态</td>
						<td >
							<select name="status">
									<option value="1" <c:if test="${li.eo_status eq 1}">
										selected="selected"
									</c:if>
									>待审核</option>
									<option value="2" <c:if test="${li.eo_status eq 2}">
										selected="selected"
									</c:if>>审核通过</option>
									<option value="3" <c:if test="${li.eo_status eq 3}">
										selected="selected"
									</c:if>
									>配货</option>
									<option value="4" <c:if test="${li.eo_status eq 4}">
										selected="selected"
									</c:if>>发货</option>
									<option value="5" <c:if test="${li.eo_status eq 5}">
										selected="selected"
									</c:if>
									>收货确认</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 开发年份 公司名 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
