<<<<<<< HEAD
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
				<span id="dqwz">数据字典管理</span>
			</em>
		</p>
	</div>
	<!--选项卡-->
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center',border:false">
        <!-- Begin of toolbar -->
        <div id="dicinfo-toolbar">
            <div class="wu-toolbar-button">
                <form id="choice-search-form" style="display: inline-block">
			                    图片名称：<input class="easyui-combobox" value="--请选择--" id="dtype"/>
                    <a id="choice-search-btn" class="easyui-linkbutton">搜索</a>
                    <a id="choice-search-reset" class="easyui-linkbutton">重置</a>
                </form>
                <a href="javascript:;" style="text-align: right;" class="easyui-linkbutton" iconAlign="left" iconCls="icon-add" onclick="addDic()"
                   plain="true">添加字典</a>
            </div>

        </div>
        <!-- End of toolbar -->
        <table id="dicinfo-datagrid" toolbar="#dicinfo-toolbar"></table> 
    </div>
</div>
<!-- 添加修改页面 -->
<div id="adddic-dialog" style="width:600px;height:500px; padding:10px;">
    <form id="adddic-form" method="post" >
        <table style="margin:0 auto; height:250px">
			<tr>
			  <td>字典类型：</td>
			  <td><input type="text" id="dtype" name="dtype"/></td>
			</tr>
			<tr>
			  <td>字典名称：</td>
			  <td><input type="text" id="dicname" name="dicname" /></td>
			</tr>
			<tr>
			  <td>字典值：</td>
			  <td><input type="text" id="dvalue" name="dvalue" /></td>
			</tr>
			<tr>
			  <td>备注：</td>
			  <td><input type="text" id="remark" name="remark" /></td>
			</tr>
        </table>
    </form>
</div>
	<script type="text/javascript">
	    $('#dtype').combobox({
	    	url: 'getDicNameList',
	    	editable: true,//不可编辑，只能选择
	    	valueField: 'dtype',
	        textField: 'dtype'}
	    );	
			/**
		     * Name 载入数据
		     */
		    $('#dicinfo-datagrid').datagrid({
		        url: 'getdiclist',
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
		            {field: 'dicname', title: '字典名称', width: 50, sortable: true},
		            {field: 'dtype', title: '字典类型', width: 50, sortable: false},
		            {field: 'dvalue', title: '字典值', width: 100, sortable: false},
		            {field: 'remark', title: '备注', width: 180, sortable: true},
		            {field: 'is_delete', title: '是否删除', width: 50, sortable: true,
					  	formatter : function(value,row,index){ 
			                 if(value=='0'){return '否'} 
			                 else {return '是'}
		                }	
		            },
		            {field: 'operate', title: '操作', align:'center',width:$(this).width()*0.1,formatter:function(value, row, index){  
						var str = '<a href="#" name="edit" class="easyui-linkbutton" onclick="editDic()" ></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" name="del" class="easyui-linkbutton" onclick="deleteDic()" ></a>';  
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
		        $('#dicinfo-datagrid').datagrid({
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
		        var dtype = $("#dtype").val();
		        return {"dtype": dtype};
		    }
		  	//删除字典
		  	function deleteDic(){
		  		var row = $('#dicinfo-datagrid').datagrid('getSelections');
		  		alert(row[0].dicname);
		  		var data = {"dicname": row[0].dicname}
		  		$.messager.confirm('确认', '确认删除?', function () {
				  		$.ajax({
							type: 'post',
							url: 'deleteDic?dicname='+row[0].dicname,
							contentType: "application/json",    //必须配置
							success: function(result){
								$.messager.show({
									title: '提示',
									msg: '数据删除成功。'
								});
							},
				  			error: function(error){
				  				alert("删除失败");
				  			}
						});
				  		$('#dicinfo-datagrid').datagrid('reload');
		  		});
		  	}
		  	function addDic(){

		  		//$('#addnews-form').form('clear');
		        $('#adddic-dialog').dialog({
		            closed: false,
		            modal: true,
		            width: 500,
		            height: 350,
		            title: "添加字典",
		            buttons: [{
		                text: '确定',
		                iconCls: 'icon-ok',
		                handler: function () {
		                    $("#adddic-form").form('submit', {
		                        url: 'adddic',
		                        onSubmit: function () {

		                        },
		                        success: function (data) {
		                            if (data == "OK") {
		                                $.messager.alert('信息提示', '提交成功！');
		                                $("#dicinfo-datagrid").datagrid("reload");// 重新加载数据库
		                                $('#adddic-dialog').dialog('close');
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
		                    $('#adddic-dialog').dialog('close');
		                }
		            }]
		        });
		  	}
		  	//编辑字典
		  	function editDic(){
		  		var rows = $('#dicinfo-datagrid').datagrid('getSelections');
		  		alert(JSON.stringify(rows[0]));
		  		//$('#addnews-form').form('clear');
		        $('#adddic-dialog').dialog({
		            closed: false,
		            modal: true,
		            width: 500,
		            height: 350,
		            title: "修改字典",
		            buttons: [{
		                text: '确定',
		                iconCls: 'icon-ok',
		                handler: function () {
		                    $("#adddic-form").form('submit', {
		                        url: 'updatedic',
		                        onSubmit: function () {

		                        },
		                        success: function (data) {
		                            if (data == "OK") {
		                                $.messager.alert('信息提示', '修改成功！');
		                                $("#dicinfo-datagrid").datagrid("reload");// 重新加载数据库
		                                $('#adddic-dialog').dialog('close');
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
		                    $('#adddic-dialog').dialog('close');
		                }
		            }]
		        });
		        $('#adddic-form').form('load', rows[0]);
		  	}
	</script>
</body>
=======
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
				<span id="dqwz">数据字典管理</span>
			</em>
		</p>
	</div>
	<!--选项卡-->
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center',border:false">
        <!-- Begin of toolbar -->
        <div id="dicinfo-toolbar">
            <div class="wu-toolbar-button">
                <!-- <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-add" onclick="openAddChoice()"
                   plain="true">添加</a>
                <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEditChoice()"
                   plain="true">修改</a>
                <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-remove" onclick="openRemoveChoice()"
                   plain="true">删除</a>
                <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-ok" onclick="openImportChoice()"
                   plain="true">导入</a> -->
                <form id="choice-search-form" style="display: inline-block">
			                    图片名称：<input class="easyui-combobox" value="--请选择--" id="dtype"/>
                    <a id="choice-search-btn" class="easyui-linkbutton">搜索</a>
                    <a id="choice-search-reset" class="easyui-linkbutton">重置</a>
                </form>
                <a href="javascript:;" style="text-align: right;" class="easyui-linkbutton" iconAlign="left" iconCls="icon-add" onclick="addImg()"
                   plain="true">添加字典</a>
            </div>

        </div>
        <!-- End of toolbar -->
        <table id="dicinfo-datagrid" toolbar="#dicinfo-toolbar"></table>
        123
        
		<div id="dd">Dialog Content.</div>  
    </div>
</div>
	<script type="text/javascript">
	    $('#dtype').combobox({
	    	url: 'getDicNameList',
	    	editable: true,//不可编辑，只能选择
	    	valueField: 'dtype',
	        textField: 'dtype'}
	    );	
			/**
		     * Name 载入数据
		     */
		    $('#dicinfo-datagrid').datagrid({
		        url: 'getdiclist',
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
		            {field: 'dicname', title: '字典名称', width: 50, sortable: true},
		            {field: 'dtype', title: '字典类型', width: 50, sortable: false},
		            {field: 'dvalue', title: '字典值', width: 100, sortable: false},
		            {field: 'remark', title: '备注', width: 180, sortable: true},
		            {field: 'is_delete', title: '是否删除', width: 50, sortable: true,
					  	formatter : function(value,row,index){ 
			                 if(value=='0'){return '否'} 
			                 else {return '是'}
		                }	
		            },
		            {field: 'operate', title: '操作', align:'center',width:$(this).width()*0.1,formatter:function(value, row, index){  
						var str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="deleteDic()" ></a>';  
						return str;  
					}}
				]],
				onLoadSuccess:function(data){  
						$("a[name='opera']").linkbutton({text:'删除',plain:true,iconCls:'icon-cancel'});    
				},
		    });
		    /* 搜索方法*/
		    $("#choice-search-btn").click(function () {
		        //点击搜索
		        $('#dicinfo-datagrid').datagrid({
		            queryParams: formChoiceJson()
		        });
		    });
		    /*重置方法*/
		    $("#choice-search-reset").click(function () {
		        $("#choice-search-form").form('clear');
		        $("#dicname").val('');
		        $('#choice-datagrid').datagrid({
		            queryParams: formChoiceJson()
		        });
		    });
		    //将表单数据转为json
		    function formChoiceJson() {
		        var dtype = $("#dtype").val();
		        return {"dtype": dtype};
		    }
		  	//删除字典
		  	function deleteDic(){
		  		var row = $('#dicinfo-datagrid').datagrid('getSelections');
		  		alert(row[0].dicname);
		  		var data = {"dicname": row[0].dicname}
		  		$.messager.confirm('确认', '确认删除?', function () {
				  		$.ajax({
							type: 'post',
							url: 'deleteDic?dicname='+row[0].dicname,
							contentType: "application/json",    //必须配置
							success: function(result){
								$.messager.show({
									title: '提示',
									msg: '数据删除成功。'
								});
							},
				  			error: function(error){
				  				alert("删除失败");
				  			}
						});
				  		$('#dicinfo-datagrid').datagrid('reload');
		  		});
		  	}
		  	function addImg(){
		  		showMyWindow("添加字典",  
	                    'goadddic',  
	                    800, 400);
		  	}
		  	$(function() {
		        $('body').append('<div id="myWindow" class="easyui-dialog" closed="true"></div>');  
		    });  
		    function showMyWindow(title, href, width, height, modal, minimizable,  
		            maximizable) {
		        $('#myWindow').window(
                    {
                        title : title,  
                        width : width === undefined ? 800 : width,  
                        height : height === undefined ? 400 : height,  
                        content : '<iframe scrolling="yes" frameborder="0"  src="'  
                                + href  
                                + '" style="width:100%;height:98%;"></iframe>',  
                        modal : modal === undefined ? true : modal,  
                        minimizable : minimizable === undefined ? false  
                                : minimizable,  
                        maximizable : maximizable === undefined ? false  
                                : maximizable,  
                        shadow : false,  
                        cache : false,  
                        closed : false,  
                        collapsible : false,  
                        resizable : false,  
                        loadingMessage : '正在加载数据，请稍等片刻......'  
                    });  
		    }  
	</script>
</body>
>>>>>>> branch 'master' of https://github.com/kingbooklove/javateach666
</html>