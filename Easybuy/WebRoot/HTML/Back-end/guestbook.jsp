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
	<script type="text/javascript">
		function test(page)
		{
			//传去servlet
			location.href="guestbookQuafy?page="+page;
		}
	</script>
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
			<li><a href="orderQuafy">订单</a></li>
			<li class="current"><a href="guestbookQuafy">留言</a></li>
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
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${li}" var="i" varStatus="a">
					<tr>
						<td class="first w4 c">${i.ec_id}</td>
						<td class="w1 c">${i.ec_nick_name}</td>
						<td>${i.ec_content}</td>
						<!-- 类似于else if -->
						<td class="w1 c">
							<c:choose>
								<c:when test="${empty i.ec_reply}">
									未回复
								</c:when>
								<c:when test="${not empty i.ec_reply}">
									已回复
								</c:when>
							</c:choose>
						</td>
						<td class="w1 c">
							<c:choose>
								<c:when test="${empty i.ec_reply}">
									<a href="guestbookQuaID?ec_tid=${i.ec_id}">回复</a>
								</c:when>
								<c:when test="${not empty i.ec_reply}">
									<a href="guestbookQua?ec_tid=${i.ec_id}">查看</a>
								</c:when>
							</c:choose>
							<a href="javascript:if(confirm('确定要删除吗？'))location='guestbookDel?ec_id=${i.ec_id}'">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					当前: ${page} / ${maxpage} 页
					<a href="guestbookQuafy?page=1">首页</a>
					<a href="guestbookQuafy?page=${page-1}">上一页</a>
					<a href="guestbookQuafy?page=${page+1}">下一页</a>
					<a href="guestbookQuafy?page=${maxpage}">尾页</a>
					<select onchange="test(this.value)">
						<c:forEach var="i" begin="1" end="${maxpage}">
							<option ${page==i?'selected':''} value="${i}">第${i}页</option>
						</c:forEach>
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
