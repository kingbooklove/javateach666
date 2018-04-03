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
<title>首页图片管理</title>
</head>
<body>
	<!--选项卡-->
	<div class="tab">
		<p class="location">
			<em>当前位置 --
				<span id="dqwz">教师账户管理</span>
			</em>
		</p>
	</div>
	<!--选项卡-->
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center',border:false">
        <!-- Begin of toolbar -->
        <div id="teainfo-toolbar">
            <div class="wu-toolbar-button">
                <form id="choice-search-form" style="display: inline-block">
			                    教师账号：<input class="easyui-textbox" id="username"/>
                    <a id="choice-search-btn" class="easyui-linkbutton">搜索</a>
                    <a id="choice-search-reset" class="easyui-linkbutton">重置</a>
                </form>
                <a href="javascript:;" style="text-align: right;" class="easyui-linkbutton" iconAlign="left" iconCls="icon-add" onclick="addTea()"
                   plain="true">添加账户</a>
                <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-ok" onclick="openImportTeaInfo()"
                   plain="true">导入</a>
            </div>

        </div>
        <!-- End of toolbar -->
        <table id="teainfo-datagrid" toolbar="#teainfo-toolbar"></table> 
    </div>
</div>
<!-- 添加修改页面 -->
<div id="addtea-dialog" style="width:600px;height:500px; padding:10px;">
    <form id="addtea-form" method="post" >
        <table style="margin:0 auto; height:250px">
			<tr>
			  <td>用户名：</td>
			  <td><input type="text" id="username" name="username"/></td>
			</tr>
			<tr>
			  <td>密码：</td>
			  <td><input type="text" id="password" name="password" /></td>
			</tr>
			<tr>
			  <td>是否启用：</td>
			  <td><input type="text" id="enable" name="enable" /></td>
			</tr>
        </table>
    </form>
</div>
	<script type="text/javascript">
			/**
		     * Name 载入数据
		     */
		    $('#teainfo-datagrid').datagrid({
		        url: 'gettealist',
		        rownumbers: true,
		        singleSelect: true,
		        checkOnSelect:false,
	            selectOncheck:false,
		        pageSize: 10,
		        pagination: true,
		        queryParams: formChoiceJson(),
		        multiSort: true,
		        fitColumns: true,
		        fit: true,
		        columns: [[
		            //{field: '', checkbox: true},
		            {field: 'id', title: '编号', width: 50, sortable: true, hidden: true},
		            {field: 'username', title: '用户名', width: 50, sortable: true},
		            {field: 'password', title: '密码', width: 50, sortable: false},
		            {field: 'enable', title: '是否启用', width: 50, sortable: true},
		            {field: 'operate', title: '操作', align:'center',width:$(this).width()*0.1,formatter:function(value, row, index){  
						var str = '<a href="#" name="edit" class="easyui-linkbutton" onclick="editTea()" ></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" name="del" class="easyui-linkbutton" onclick="delTea()" ></a>';  
						return str;  
					}}
				]],
				onLoadSuccess:function(data){  
					$("a[name='edit']").linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});    
					$("a[name='del']").linkbutton({text:'删除',plain:true,iconCls:'icon-cancel'});   
				},
		    });
		    /* 搜索方法*/
		    $("#choice-search-btn").click(function () {
		        //点击搜索
		        $('#teainfo-datagrid').datagrid({
		            queryParams: formChoiceJson()
		        });
		    });
		    /*重置方法*/
		    $("#choice-search-reset").click(function () {
		        $("#choice-search-form").form('clear');
		        $('#choice-datagrid').datagrid({
		            queryParams: formChoiceJson()
		        });
		    });
		    //将表单数据转为json
		    function formChoiceJson() {
		        var username = $("#username").val();
		        return {"username": username};
		    }
		  	//删除教师账号
		  	function delTea(){
		  		
		  	}
		  	function addTea(){

		  		//$('#addnews-form').form('clear');
		        $('#addtea-dialog').dialog({
		            closed: false,
		            modal: true,
		            width: 500,
		            height: 350,
		            title: "添加账户",
		            buttons: [{
		                text: '确定',
		                iconCls: 'icon-ok',
		                handler: function () {
		                    $("#addtea-form").form('submit', {
		                        url: 'addtea',
		                        onSubmit: function () {

		                        },
		                        success: function (data) {
		                            if (data == "OK") {
		                                $.messager.alert('信息提示', '提交成功！');
		                                $("#teainfo-datagrid").datagrid("reload");// 重新加载数据库
		                                $('#addtea-dialog').dialog('close');
		                            }
		                            else {
		                                $.messager.alert('信息提示', '提交失败！');
		                            }
		                        }

		                    });
		                }
		            }, {
		                text: '取消',
		                iconCls: 'icon-cancel',
		                handler: function () {
		                    $('#addtea-dialog').dialog('close');
		                }
		            }]
		        });
		  	}
		  	//编辑教师账户
		  	function editTea(){
		  		var rows = $('#teainfo-datagrid').datagrid('getSelections');
		  		alert(JSON.stringify(rows[0]));
		  		//$('#addnews-form').form('clear');
		        $('#addtea-dialog').dialog({
		            closed: false,
		            modal: true,
		            width: 500,
		            height: 350,
		            title: "修改信息",
		            buttons: [{
		                text: '确定',
		                iconCls: 'icon-ok',
		                handler: function () {
		                    $("#addtea-form").form('submit', {
		                        url: 'updatetea',
		                        onSubmit: function () {

		                        },
		                        success: function (data) {
		                            if (data == "OK") {
		                                $.messager.alert('信息提示', '修改成功！');
		                                $("#teainfo-datagrid").datagrid("reload");// 重新加载数据库
		                                $('#addtea-dialog').dialog('close');
		                            }
		                            else {
		                                $.messager.alert('信息提示', '修改失败！');
		                            }
		                        }

		                    });
		                }
		            }, {
		                text: '取消',
		                iconCls: 'icon-cancel',
		                handler: function () {
		                    $('#addtea-dialog').dialog('close');
		                }
		            }]
		        });
		        $('#addtea-form').form('load', rows[0]);
		  	}
	</script>
</body>
</html>