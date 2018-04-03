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
				<span id="dqwz">新闻管理</span>
			</em>
		</p>
	</div>
	<!--选项卡-->
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center',border:false">
        <!-- Begin of toolbar -->
        <div id="pubinfo-toolbar">
            <div class="wu-toolbar-button">
                <form id="choice-search-form" style="display: inline-block">
			                    新闻标题：<input class="easyui-textbox" id="pubtitle"/>
			                    新闻内容：<input class="easyui-textbox" id="pubcontent"/>
                    <a id="choice-search-btn" class="easyui-linkbutton">搜索</a>
                    <a id="choice-search-reset" class="easyui-linkbutton">重置</a>
                </form>
                <a href="javascript:;" style="text-align: right;" class="easyui-linkbutton" iconAlign="left" iconCls="icon-add" onclick="addPubs()"
                   plain="true">添加公告</a>
            </div>

        </div>
        <!-- End of toolbar -->
        <table id="pubinfo-datagrid" toolbar="#pubinfo-toolbar"></table>
    </div>
</div>
<!-- 添加修改页面 -->
<div id="addpubs-dialog" style="width:600px;height:500px; padding:10px;">
    <form id="addpubs-form" method="post" >
        <table style="margin:0 auto; height:250px">
        	<tr>
        		<td>标题</td>
        		<td><input type="text" name="joutitle" class="easyui-textbox"/></td>
        	</tr>
    	    <tr>
    	    	<td>公告类型</td>
    	    	<td><input class="easyui-combobox" value="--请选择--" id="joutype"/></td>
    	    </tr>
        	<tr>
        		<td>公告内容</td>
        		<td><textarea name="joucontent" rows="10" cols="40"></textarea></td>
        	</tr>
        </table>
    </form>
</div>
	<script type="text/javascript">
		    $('#joutype').combobox({
		    	url: 'getJoutypeList1',
		    	editable: true,//不可编辑，只能选择
		    	valueField: 'dicname',
		        textField: 'dicname'}
		    );	
		
			/**
		     * Name 载入数据
		     */
		    $('#pubinfo-datagrid').datagrid({
		        url: 'getpublist',
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
		            {field: 'joutitle', title: '标题', width: 50, sortable: true},
		            {field: 'joucontent', title: '内容', width: 150, sortable: false},
		            {field: 'joutype', title: '新闻类型', width: 50, sortable: false,
		            	formatter : function(value,row,index){ 
			                 if(value=='1'){return '时事'} 
			                 else if(value=='2'){return '政治'}
			                 else {return '学习'}
		                }
		            },
		            {field: 'starttime', title: '创建时间', width: 100, sortable: true},
		            {field: 'endtime', title: '过期时间', width: 100, sortable: true},
		            {field: 'adminname', title: '发布人', width: 50, sortable: true},
		            {field: 'operate', title: '操作', align:'center',width:$(this).width()*0.1,formatter:function(value, row, index){  
						var str = '<a href="#" name="edit" class="easyui-linkbutton" onclick="editPubs()" ></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" name="del" class="easyui-linkbutton" onclick="delPubs()" ></a>';  
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
		        $('#pubinfo-datagrid').datagrid({
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
		        var pubtitle = $("#pubtitle").val();
		        var pubcontent = $("#pubcontent").val();
		        return {"joutitle": pubtitle, "joucontent": pubcontent};
		    }
		  	//删除图片
		  	function delPubs(){
		  		var row = $('#pubinfo-datagrid').datagrid('getSelections');
		  		$.messager.confirm('确认', '确认删除?', function () {
				  		$.ajax({
							type: 'post',
							url: 'deletepub?joutitle=' + row[0].joutitle,
							contentType: "application/json",    //必须配置
							success: function(result){
								$.messager.show({
									title: '提示',
									msg: '数据删除成功。'
								});
							} 
						});
				  		$('#pubinfo-datagrid').datagrid('reload');
		  		});
		  	}
		  	function addPubs(){

		  		//$('#addnews-form').form('clear');
		        $('#addpubs-dialog').dialog({
		            closed: false,
		            modal: true,
		            width: 500,
		            height: 350,
		            title: "添加公告",
		            buttons: [{
		                text: '确定',
		                iconCls: 'icon-ok',
		                handler: function () {
		                    $("#addpubs-form").form('submit', {
		                        url: 'addpubs',
		                        onSubmit: function () {

		                        },
		                        success: function (data) {
		                            if (data == "OK") {
		                                $.messager.alert('信息提示', '提交成功！');
		                                $("#pubinfo-datagrid").datagrid("reload");// 重新加载数据库
		                                $('#addpubs-dialog').dialog('close');
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
		                    $('#addpubs-dialog').dialog('close');
		                }
		            }]
		        });
		  	}
		  	//编辑公告
		  	function editPubs(){
		  		var rows = $('#pubsinfo-datagrid').datagrid('getSelections');
		  		alert(JSON.stringify(rows[0]));
		  		//$('#addnews-form').form('clear');
		        $('#addpubs-dialog').dialog({
		            closed: false,
		            modal: true,
		            width: 500,
		            height: 350,
		            title: "修改公告",
		            buttons: [{
		                text: '确定',
		                iconCls: 'icon-ok',
		                handler: function () {
		                    $("#addpubs-form").form('submit', {
		                        url: 'updatepubs',
		                        onSubmit: function () {

		                        },
		                        success: function (data) {
		                            if (data == "OK") {
		                                $.messager.alert('信息提示', '修改成功！');
		                                $("#pubsinfo-datagrid").datagrid("reload");// 重新加载数据库
		                                $('#addpubs-dialog').dialog('close');
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
		                    $('#addpubs-dialog').dialog('close');
		                }
		            }]
		        });
		        $('#addpubs-form').form('load', rows[0]);
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
				<span id="dqwz">新闻管理</span>
			</em>
		</p>
	</div>
	<!--选项卡-->
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center',border:false">
        <!-- Begin of toolbar -->
        <div id="pubinfo-toolbar">
            <div class="wu-toolbar-button">
                <form id="choice-search-form" style="display: inline-block">
			                    新闻标题：<input class="easyui-textbox" id="pubtitle"/>
			                    新闻内容：<input class="easyui-textbox" id="pubcontent"/>
                    <a id="choice-search-btn" class="easyui-linkbutton">搜索</a>
                    <a id="choice-search-reset" class="easyui-linkbutton">重置</a>
                </form>
                <a href="javascript:;" style="text-align: right;" class="easyui-linkbutton" iconAlign="left" iconCls="icon-add" onclick="addImg()"
                   plain="true">添加图片</a>
            </div>

        </div>
        <!-- End of toolbar -->
        <table id="pubinfo-datagrid" toolbar="#pubinfo-toolbar"></table>
    </div>
</div>
	<script type="text/javascript">
		
			/**
		     * Name 载入数据
		     */
		    $('#pubinfo-datagrid').datagrid({
		        url: 'getpublist',
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
		            {field: 'joutitle', title: '标题', width: 50, sortable: true},
		            {field: 'joucontent', title: '内容', width: 150, sortable: false},
		            {field: 'joutype', title: '新闻类型', width: 50, sortable: false,
		            	formatter : function(value,row,index){ 
			                 if(value=='1'){return '时事'} 
			                 else if(value=='2'){return '政治'}
			                 else {return '学习'}
		                }
		            },
		            {field: 'starttime', title: '创建时间', width: 100, sortable: true},
		            {field: 'endtime', title: '过期时间', width: 100, sortable: true},
		            {field: 'adminname', title: '发布人', width: 50, sortable: true},
		            {field: 'operate', title: '操作', align:'center',width:$(this).width()*0.1,formatter:function(value, row, index){  
						var str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="deleteImg()" ></a>';  
						return str;  
					}}
				]],
				onLoadSuccess:function(data){    
						$("a[name='opera']").linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'},{text:'删除',plain:true,iconCls:'icon-cancel'});    
				},
		    });
		    /* 搜索方法*/
		    $("#choice-search-btn").click(function () {
		        //点击搜索
		        $('#pubinfo-datagrid').datagrid({
		            queryParams: formChoiceJson()
		        });
		    });
		    /*重置方法*/
		    $("#choice-search-reset").click(function () {
		        $("#choice-search-form").form('clear');
		        $("#pubtitle").val('');
		        $("#pubcontent").val('');
		        $('#choice-datagrid').datagrid({
		            queryParams: formChoiceJson()
		        });
		    });
		    //将表单数据转为json
		    function formChoiceJson() {
		        var pubtitle = $("#pubtitle").val();
		        var pubcontent = $("#pubcontent").val();
		        //alert(question1);
		        //alert(question2);
		        return {"joutitle": pubtitle, "joucontent": pubcontent};
		    }
		  	//删除图片
		  	function deleteImg(){
		  		var row = $('#pubinfo-datagrid').datagrid('getSelections');
		  		$.messager.confirm('确认', '确认删除?', function () {
				  		$.ajax({
							type: 'post',
							url: 'deletepub?joutitle=' + row[0].joutitle,
							contentType: "application/json",    //必须配置
							success: function(result){
								$.messager.show({
									title: '提示',
									msg: '数据删除成功。'
								});
							} 
						});
				  		$('#pubinfo-datagrid').datagrid('reload');
		  		});
		  	}
		  	function addpub(){
		  		showMyWindow("添加新闻",  
	                    'goaddpub',  
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