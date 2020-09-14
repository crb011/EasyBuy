<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
<title>��̨���� - ������</title>
<link type="text/css" rel="stylesheet" href="HTML/css/style.css" />
<script type="text/javascript">
	function test()
	{
		var productPrice = document.getElementsByName("productPrice")[0].value;
		var productstock = document.getElementsByName("productstock")[0].value;
		if(productPrice=="")
		{
			alert("��Ʒ�۸���Ϊ��");
			return false;
		}
		if(productstock=="")
		{
			alert("��治��Ϊ��");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="HTML/images/logo.gif" /></div>
	<div class="help"><a href="/Easybuy/indexSer">����ǰ̨ҳ��</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="/Easybuy/indexSer">��ҳ</a></li>
			<li><a href="userQuafy">�û�</a></li>
			<li class="current"><a href="productClassSer">��Ʒ</a></li>
			<li><a href="orderQuafy">����</a></li>
			<li><a href="guestbookQuafy">����</a></li>
			<li><a href="newsQuafy">����</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		����Ա [ admin ] ���ã�������<%=new Date(System.currentTimeMillis()).toString() %>����ӭ�ص�������̨��
	</div>
</div>
<div id="position" class="wrap">
	�����ڵ�λ�ã�<a href="indexSerHT">������</a> &gt; ������̨
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>�û�����</dt>
				<dd><em><a href="userAddSer">����</a></em><a href="userQuafy">�û�����</a></dd>
				<dt>��Ʒ��Ϣ</dt>
				<dd><em><a href="productClassAddSer">����</a></em><a href="productClassSer">�������</a></dd>
				<dd><em><a href="productAddSer">����</a></em><a href="productQuafy">��Ʒ����</a></dd>
				<dt>��������</dt>
				<dd><a href="orderQuafy">��������</a></dd>
				<dt>���Թ���</dt>
				<dd><a href="guestbookQuafy">���Թ���</a></dd>
				<dt>���Ź���</dt>
				<dd><em><a href="newsAddSer">����</a></em><a href="newsQuafy">���Ź���</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>�޸���Ʒ</h2>
		<div class="manage">
			<form action="/Easybuy/productUpd" method="post" enctype="multipart/form-data" onsubmit="return test()">
				<input type="hidden" name="id" value="${li.ep_id}" />
				<table class="form">
					<tr>
						<td class="field">��Ʒ���ƣ�</td>
						<td><input type="text" class="text" name="productName" value="${li.ep_name}" /></td>
					</tr>
					<tr>
						<td class="field">�������ࣺ</td>
						<td>
							<select name="parentId">
								<c:forEach items="${list}" var="i" varStatus="a">
								<!-- �ж��Ƿ�Ϊ���� -->
									<c:if test="${i.epc_parent_id == 0}">
											<option value="${i.epc_parent_id}">${i.epc_name}</option>
										</c:if>
										<!-- �ж��Ƿ�Ϊ���� -->
										<c:forEach items="${list}" var="b" varStatus="o">
											<c:if test="${b.epc_parent_id == i.epc_id}">
												<option value="${b.epc_parent_id}">&emsp;��${b.epc_name}</option>
											</c:if>
										</c:forEach>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">��ƷͼƬ��</td>
						<td><input type="file" class="text" name="photo"/></td>
					</tr>
					<tr>
						<td class="field">��Ʒ�۸�</td>
						<td><input type="text" class="text tiny" name="productPrice" value="${li.ep_price}"/> Ԫ</td>
					</tr>
					<tr>
						<td class="field">��Ʒ������</td>
						<td><input type="text" class="text" name="product1" value="${li.ep_description}"/></td>
					</tr>
					<tr>
						<td class="field">��棺</td>
						<td><input type="text" class="text tiny" name="productstock" value="${li.ep_stock}"/></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="����" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; ������� ��˾�� All Rights Reserved. ��ICP֤1000001��
</div>
</body>
</html>