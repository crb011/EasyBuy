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
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="HTML/css/style.css" />
<script type="text/javascript" src="HTML/scripts/function.js"></script>
<script type="text/javascript">
		function test(page)
		{
			//传去servlet
			location.href="guestbokSerFy?page="+page;
		}
		
	</script>
<c:if test="${empty sessionScope.qtname}"><!-- 判断用户是否存在 -->
	<script type="text/javascript">
		alert('请先登录');
		location.href="/Easybuy/loginSer";
	</script>
</c:if>
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
	您现在的位置：<a href="indexSer">易买网</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
			<c:forEach items="${ea2}" var="i" varStatus="a">
					<c:if test="${i.epc_parent_id eq 0}">
						<dt>${i.epc_name}</dt>
						<c:forEach items="${ea2}" var="t" varStatus="b">
							<c:if test="${t.epc_parent_id == i.epc_id}">
								<dd><a href="productliSer?epc_id=${t.epc_id}">${t.epc_name}</a></dd>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
				<c:forEach items="${ea}" var="i" varStatus="a">
					<li>
						<dl>
							<dt>${i.ec_content}</dt>
							<dd class="author">网友：${i.ec_nick_name} <span class="timer">${i.ec_create_time}</span></dd>
							<dd>${i.ec_reply}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					当前: ${page} / ${maxpage} 页
					<a href="guestbokSerFy?page=1">首页</a>
					<a href="guestbokSerFy?page=${page-1}">上一页</a>
					<a href="guestbokSerFy?page=${page+1}">下一页</a>
					<a href="guestbokSerFy?page=${maxpage}">尾页</a>
					<select onchange="test(this.value)">
						<c:forEach var="i" begin="1" end="${maxpage}">
							<option ${page==i?'selected':''} value="${i}">第${i}页</option>
						</c:forEach>
					</select>
				</ul>
			</div>
			<div id="reply-box">
				<form action="guestbokADD" method="post" onsubmit="return test()">
				<!-- 留言创建时间 -->
					<input type="hidden" name="ec_create_time" value="<%=new Date(System.currentTimeMillis()).toString() %>"/>
					<input type="hidden" name="ec_nick_name" value="${sessionScope.qtname}"/>
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td>${sessionScope.qtname}</td>
						</tr>
						<tr>
							<td class="field">留言标题：</td>
							<td><input class="text" type="text" name="guestTitle" /></td>
						</tr>
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
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
