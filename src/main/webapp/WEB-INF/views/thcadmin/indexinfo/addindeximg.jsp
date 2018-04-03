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
		    <td width="20%">图片编号：</td>
		    <td width="20%"><input type="text" id="imgno" name="imgno"/></td>
		    <td width="20%">图片名称：</td>
		    <td width="20%"><input type="text" id="imgname" name="imgname" /></td>
		  </tr>
  		  <tr>
		    <td width="20%">选择图片：</td>
		    <td width="20%"><input type="file" id="file" name="file" /></td>
		    <td width="20%">是否展示：</td>
		    <td width="20%"><input name="is_pub" type="radio" size="30" value="0" checked>否<input name="is_pub" type="radio" size="30" value="1">是</td>
		  </tr>
  		  <tr>
		    <td colspan="4">
		    	<button id="submits">提交</button>
		    </td>
		  </tr>
		</table>
	</form>                                                                                          
	<script type="text/javascript" src="${basePath}/static/js/vue.js"></script>
	<script type="text/javascript">
			function submits(){
				alert("111");
				var imgno = $("#imgno").val();
				var imgname = $("#imgname").val();
				var is_pub = $("input[name='is_pub']:checked").val();
				var imgurl = $("#file").val();
				alert(imgurl);
				if(imgno == null || imgno == '')
					alert("图片编号不能为空");
				if(imgname == null || imgname == '')
					alert("图片名称不能为空");
 				var data = {
						"imgno": imgno,
						"imgname": imgname,
						"is_pub": is_pub,
						"imgurl": imgurl
						};
 				alert(data.is_pub);
				$.ajax({
					type: 'post',
					url: 'addindeximg',
					contentType: 'application/json',
					data: "?imgno=" + data.imgno + "&imgname=" + data.imgname + "&imgurl=" + data.imgurl + "&is_pub=" + data.is_pub,
					success: function(result){
						alert(result.responseDesc);
					}
				}); 
			}
	</script>
</body>
</html>