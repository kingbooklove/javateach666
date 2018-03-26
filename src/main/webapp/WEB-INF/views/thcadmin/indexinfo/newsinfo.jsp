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
        <div id="newsinfo-toolbar">
            <div class="wu-toolbar-button">
                <form id="choice-search-form" style="display: inline-block">
			                    新闻标题：<input class="easyui-textbox" id="newstitle"/>
			                    新闻内容：<input class="easyui-textbox" id="newscontent"/>
                    <a id="choice-search-btn" class="easyui-linkbutton">搜索</a>
                    <a id="choice-search-reset" class="easyui-linkbutton">重置</a>
                </form>
                <a href="javascript:;" style="text-align: right;" class="easyui-linkbutton" iconAlign="left" iconCls="icon-add" onclick="addImg()"
                   plain="true">添加图片</a>
            </div>

        </div>
        <!-- End of toolbar -->
        <table id="newsinfo-datagrid" toolbar="#newsinfo-toolbar"></table>
    </div>
</div>
	<script type="text/javascript">
		
			/**
		     * Name 载入数据
		     */
		    $('#newsinfo-datagrid').datagrid({
		        url: 'getnewslist',
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
		        $('#newsinfo-datagrid').datagrid({
		            queryParams: formChoiceJson()
		        });
		    });
		    /*重置方法*/
		    $("#choice-search-reset").click(function () {
		        $("#choice-search-form").form('clear');
		        $("#newstitle").val('');
		        $("#newscontent").val('');
		        $('#choice-datagrid').datagrid({
		            queryParams: formChoiceJson()
		        });
		    });
		    //将表单数据转为json
		    function formChoiceJson() {
		        var newstitle = $("#newstitle").val();
		        var newscontent = $("#newscontent").val();
		        //alert(question1);
		        //alert(question2);
		        return {"joutitle": newstitle, "joucontent": newscontent};
		    }
		  	//删除图片
		  	function deleteImg(){
		  		var row = $('#newsinfo-datagrid').datagrid('getSelections');
		  		$.messager.confirm('确认', '确认删除?', function () {
				  		$.ajax({
							type: 'post',
							url: 'deletenews?joutitle=' + row[0].joutitle,
							contentType: "application/json",    //必须配置
							success: function(result){
								$.messager.show({
									title: '提示',
									msg: '数据删除成功。'
								});
							} 
						});
				  		$('#newsinfo-datagrid').datagrid('reload');
		  		});
		  	}
		  	function addNews(){
		  		showMyWindow("添加新闻",  
	                    'goaddnews',  
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
</html>