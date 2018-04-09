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
				<security:authorize ifAnyGranted="STUDENT" >
					<li class="nav_top">
						<a class="nav_top_link" href="#">
							<span class="index">返回首页</span>
						</a>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">我的考试</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="${basePath }/practice/initPractice" target="_son">练习导航</a>
							</li>
							<li>
								<a href="${basePath }/stuexam/stuexam" target="_son">参加考试</a>
							</li>
							<li>
								<a href="${basePath }/stuscore/initStuScore" target="_son">查询成绩</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">教学质量评价</span>
						</a>
						<ul class="sub">
							<li>
								<a href="gomyevaluate" target="_son">教学评价</a>
							</li>
						</ul>
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
								<a href="myfile" target="_son">我的文档</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">我的课程</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="myownclassinfo" target="_son">查看我的课表</a>
							</li>
							<li>
								<a href="chooseclassonline" target="_son">网上选课</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">我的重修</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="myrepairlist" target="_son">挂科科目</a>
							</li>
						</ul>
					</li>
				</security:authorize>
				<security:authorize ifAnyGranted="ADMIN" >
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">网上选课管理员1</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">全校性选课</a>
							</li>
							<li>
								<a href="#">课程行课情况查询</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">网上选课管理员2</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="#">全校性选课</a>
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
								<a href="goteaaccount" target="_son">教师账户信息</a>
							</li>
							<li>
								<a href="goteapost" target="_son">教师职位信息</a>
							</li>
							<li>
								<a href="gopostrecord" target="_son">职位申请记录</a>
							</li>
							<li>
								<a href="ProfessionFK" target="_son">升职请求</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">学生信息管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="gostuaccount" target="_son">学生账户信息</a>
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
								<a href="gocourseinfo" target="_son">学科信息</a>
								<a href="#">课程行课情况查询</a>
							</li>
						</ul>
					</li>
				</security:authorize>
				<security:authorize ifAnyGranted="TEACHER" >
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">信息设置</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="teainfo" target="_son">个人资料</a>
							</li>
							
							<li>
								<a href="allteainfo" target="_son">教师信息</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">通知管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="noticeinfo" target="_son">发布通知</a>
							</li>
							<li>
								<a href="noticeinfolist" target="_son">通知管理</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">资料管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="uploadinformation" target="_son">资料上传</a>
							</li>
							<li>
								<a href="informationlist"  target="_son">资料管理</a>
							</li>
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">课程管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="publishcourse" target="_son">发布选课</a>
							</li>
							<li>
								<a href="stucourseinfo" target="_son">学生选课信息</a>
							</li>
							<li>
								<a href="initmyteaclassinfo" target="_son">教师课表</a>
							</li>
							
						</ul>
					</li>
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">职称管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="profession" target="_son">升职请求</a>
							</li>
							
							<li>
								<a href="professionlist?teano=${TeaInfo.teano }" target="_son">查看升职请求记录</a>
							</li>
							<!-- <li>
								<a href="ProfessionFK">升职请求审批</a>
							</li> -->
						</ul>
					</li>	
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">题库管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="${basePath }/single/singlechoice" target="_son">单选题库</a>
							</li>
							<li>
								<a href="${basePath }/multiple/multiplechoice" target="_son">多选题库</a>
							</li>
							<li>
								<a href="${basePath }/judgment/judge" target="_son">判断题库</a>
							</li>
							<li>
								<a href="${basePath }/completion/completion" target="_son">填空题库</a>
							</li>
							<li>
								<a href="${basePath }/subjective/subjective" target="_son">主观题库</a>
							</li>
						</ul>
					</li>	
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">试卷管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="${basePath }/examrule/examrule" target="_son">试卷规则</a>
							</li>
							<li>
								<a href="${basePath }/exampaper/exampaper" target="_son">试卷列表</a>
							</li>
						</ul>
					</li>	
					<li class="nav_top">
						<a class="nav_top_link">
							<span class="down">考试管理</span>
						</a>
						
						<ul class="sub">
							<li>
								<a href="${basePath }/exam/exam" target="_son">考试发布</a>
							</li>
							<li>
								<a href="${basePath }/exam/initCorrecting" target="_son">批改试卷</a>
							</li>
							<li>
								<a href="${basePath }/teascore/initTeaScore" target="_son">成绩统计</a>
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
		<div class="center" style="height:  100%;overflow:  hidden;">
			<div style="height:  100%;overflow:  hidden;">
				<iframe name="_son" src="wel"  width="98%" height="80%"  style="margin: 0px 12px;overflow: hidden;" scrolling="no" frameborder="0"></iframe>
			</div>
		</div>
		<!--底部-->
		<!-- <div class="footer">
			
		</div> -->
	</body>
</html>
