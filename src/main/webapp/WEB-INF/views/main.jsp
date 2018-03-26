<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>教务管理系统</title>
		<%@include file="/common/easyui.jspf"%>
		<link rel="stylesheet" type="text/css" href="${basePath}/static/css/main.css"/>
	</head>
	<body class="mainbody">
		<!--顶部-->
		<div class="header">
			<div class="logo_box">
				<div class="logo">
					<h2><img src="${basePath}/static/img/login/logo_school.png" /></h2>
				</div>
				<div class="info">
					<ul>
						<li>
							<span>欢迎您：</span>
							<span><security:authentication property="principal.username" />同学</span>
						</li>
						<li>
							<a href="logout">退出</a>
						</li>
					</ul>
				</div>
			</div>
			<!--菜单-->
			<ul class="nav">
				<li class="nav_top">
					<a class="nav_top_link" href="#">
						<span class="index">返回首页</span>
					</a>
				</li>
				<security:authorize ifAnyGranted="STUDENT" >
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">我的考试</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">考试考试111</a>
							</li>
							<li>
								<a href="#">考试考试222</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">教学质量评价</span>
						</a>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">我的信息</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="stuowninfo" target="_son">个人信息修改</a>
							</li>
							<li>
								<a href="myclassinfo" target="_son">我的班级</a>
							</li>
							<li>
								<a href="#">我的文档</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">我的课程</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">查看我的课表</a>
							</li>
							<li>
								<a href="#">网上选课</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">我的重修</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">挂科科目</a>
							</li>
						</ul>
					</li>
				</security:authorize>
				<!-- 管理员菜单 -->
				<security:authorize ifAnyGranted="ADMIN" >
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">个人设置</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="admininfo" target="_son">个人资料</a>
							</li>
							<li>
								<a href="adminsetpass" target="_son">密码管理</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">首页管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="indeximg" target="_son">轮播图片信息</a>
							</li>
							<li>
								<a href="gonewsinfo" target="_son">新闻信息</a>
							</li>
							<li>
								<a href="gopubinfo" target="_son">公告信息</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">教师信息管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">教师账户信息</a>
							</li>
							<li>
								<a href="#">教师职位信息</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">学生信息管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">学生账户信息</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">数据字典管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="godiclist" target="_son">数据字典信息</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">学科管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">学科信息</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">我的通知</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">通知信息</a>
							</li>
						</ul>
					</li>
				</security:authorize>
				<!-- 教师菜单 -->
				<security:authorize ifAnyGranted="TEACHER" >
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">个人设置</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">个人资料</a>
							</li>
							<li>
								<a href="#">密码管理</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">通知管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">发布通知</a>
							</li>
							<li>
								<a href="#">通知管理</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">资料管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">资料上传</a>
							</li>
							<li>
								<a href="#">资料管理</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">课程管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">发布选课</a>
							</li>
							<li>
								<a href="#">学生选课信息</a>
							</li>
							<li>
								<a href="#">教师课表</a>
							</li>
							<li>
								<a href="#">查看教学评价</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">职称管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">升职请求</a>
							</li>
							<li>
								<a href="#">查看升职情况</a>
							</li>
							<li>
								<a href="#">查看升职请求记录</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">考试管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">考试管理</a>
							</li>
							<li>
								<a href="#">考试管理</a>
							</li>
						</ul>
					</li>											
				</security:authorize>
			</ul>
			<!--选项卡-->
			<!-- <div class="tab">
				<p class="location">
					<em>当前位置 --
						<span id="dqwz">通知公告</span>
					</em>
				</p>
			</div> -->
			<!--选项卡-->
		</div>
		
		<!--中间-->
		<div class="center">
			<div>
				<iframe name="_son" src="wel"  width="98%" height="463px" style="margin: 0px 12px;" scrolling="no" frameborder="0"></iframe>
			</div>
		</div>
		<!--底部-->
		<div class="footer">
			
		</div>
	</body>
</html>