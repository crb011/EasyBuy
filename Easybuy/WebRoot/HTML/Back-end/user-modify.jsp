<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript">
	function test()
	{
		var name = document.getElementsByName("name")[0].value;
		var passWord = document.getElementsByName("passWord")[0].value;
		var birthday = document.getElementsByName("birthday")[0].value;
		var reg = /^[0-9a-zA-Z]/;
		var reg1 = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
		var regExp = new RegExp(reg1);
		if(name=="")
		{
			alert("姓名不能为空");
			return false;
		}
		if(passWord=="")
		{
			alert("密码不能为空");
			return false;
		}
		if(birthday=="")
		{
			alert("出生日期不能为空");
			return false;
		}
		if(regExp.test(birthday)==false)
		{
			alert("日期格式不正确，正确格式为：2014-01-01");
			return false;
		}
		return true;
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
			<li class="current"><a href="userQuafy">用户</a></li>
			<li><a href="productClassSer">商品</a></li>
			<li><a href="orderQuafy">订单</a></li>
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
		<h2>修改用户</h2>
		<div class="manage">
			<form action="userUpd" method="post" onsubmit="return test()">
				<input type="hidden" class="text" name="sfz" value="${li.eu_identity_code}"/>
				<table class="form">
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="userName" value="${li.eu_user_id}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">姓名：</td>
						<td><input type="text" class="text" name="name" value="${li.eu_user_name}"/></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="passWord" value="${li.eu_password}" /></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<!-- 判断传出的name中的sex的值 -->
						<td><input type="radio" name="sex" value="T" <c:if test="${li.eu_sex eq 'T'}">
							checked="true"
						</c:if>/>男 
						<input type="radio" name="sex" value="F" <c:if test="${li.eu_sex eq 'F'}">
							checked="true"
						</c:if>/>女</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<input type="text" class="text" name="birthday" value="${li.eu_birthday}" />
						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="mobile" value="${li.eu_mobile}" /></td>
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="address" value="${li.eu_address}" /></td>
					</tr>
					<tr>
						<td class="field">电子邮箱：</td>
						<td><input type="text" class="text" name="email" value="${li.eu_email}" /></td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>
						<td>
							<select name="status">
							<!-- 跟上面一样 -->
								<option value="2" <c:if test="${li.eu_status eq 2}">
									selected="selected"
								</c:if>
								>管理员</option>
								<option value="1" <c:if test="${li.eu_status eq 1}">
									selected="selected"
								</c:if>>普通用户</option>
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
