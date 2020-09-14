<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="/Easybuy/indexSer">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="/Easybuy/indexSer">首页</a></li>
			<li class="current"><a href="userSer">用户</a></li>
			<li><a href="productSer">商品</a></li>
			<li><a href="orderSer">订单</a></li>
			<li><a href="guestbookSer">留言</a></li>
			<li><a href="newsSer">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
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
		<h2>提示信息</h2>
		<div class="manage">
			<div class="shadow">
				<em class="corner lb"></em>
				<em class="corner rt"></em>
				<div class="box">
					<div class="msg">
						<p>恭喜：操作成功！</p>
						<p>正在返回首页...</p>
						<script type="text/javascript">
							setTimeout("location.href='indexSeverlet'", 2000);
						</script>
					</div>
				</div>
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
