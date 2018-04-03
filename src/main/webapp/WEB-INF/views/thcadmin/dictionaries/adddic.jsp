<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
	response.setHeader("X-Frame-Options", "SAMEORIGIN");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header"  content="${_csrf.headerName}"/> --%>
<%@include file="/common/easyui.jspf"%>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/main.css"/>
<title>密码管理</title>
</head>
<body>
	<form action="addindeximg" enctype="multipart/form-data" method = "post">
		<table width="80%" height="100px" bgcolor="#f2f6fb" border="1" style="border-color: #99CCFF; border-collapse : collapse">
		  <tr>
		    <td width="20%">字典类型：</td>
		    <td width="20%"><input type="text" id="dtype" name="dtype"/></td>
		    <td width="20%">字典名称：</td>
		    <td width="20%"><input type="text" id="dicname" name="dicname" /></td>
		  </tr>
  		  <tr>
		    <td width="20%">字典值：</td>
		    <td width="20%"><input type="text" id="dvalue" name="dvalue" /></td>
		    <td width="20%">备注：</td>
		    <td width="20%"><input type="text" id="remark" name="remark" /></td>
		  </tr>
  		  <tr>
		    <td colspan="4">
		    	<button id="submits" onclick="submits()">提交</button>
		    </td>
		  </tr>
		</table>
	</form>                                                                                          
	<script type="text/javascript" src="${basePath}/static/js/vue.js"></script>
	<script type="text/javascript">
			function submits(){
				alert("111");
				var dtype = $("#dtype").val();
				var dicname = $("#dicname").val();
				var dvalue = $("#dvalue").val();
				var remark = $("#remark").val();
				if(dtype == null || dtype == '')
					alert("字典类型不能为空");
				if(dicname == null || dicname == '')
					alert("字典名称不能为空");
				if(dvalue == null || dvalue == '')
					alert("字典值不能为空");
 				var data = {
						"dtype": dtype,
						"dicname": dicname,
						"dvalue": dvalue,
						"remark": remark
						};

			}
	</script>
</body>
</html>