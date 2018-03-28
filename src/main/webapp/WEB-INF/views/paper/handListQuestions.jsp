<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="${basePath }/css/wu.css" />
<%@include file="/common/easyui.jspf"%>
</head>
<body>
	<!-- 检索部分 -->
	<div style="padding-left: 5%;padding-bottom: 5px;border-bottom: 1px solid #bbb;">
		<form action="#" method="post">
			题目：<input type="text" name="singleTitle" class="easyui-textbox"/>
			难度：<input type="text" name="degree" class="easyui-textbox"/><br/><br/>
			时间：<input type="date" id="bdaytime-course-value" class="easyui-textbox"/>~<input type="date" id="edaytime-course-value" class="easyui-textbox"/>
              	<br/><br/>
              <a id="choice-search-btn" class="easyui-linkbutton">搜索</a>
              <a id="choice-search-reset" class="easyui-linkbutton">重置</a>
		</form>
	</div>
	<div style="margin:40px auto;">
		<c:forEach items="${singleChoicelist }" var="single">
			<div >
				<p style=" line-height: 20px;margin-left: 25px;">
					<input type="checkbox"  id = "${single.id }" name="sc" value="${single.id }"  />
					<input type="text" id = "score${single.id }" placeholder="输入分数" name="score" size="4" />
					难度等级：${single.degree }级<br/>
					<span style="font-family:'微软雅黑';font-szie:14px;">
						${single.singleTitle }<br/>
						A、${single.answera }<br/>
						B、${single.answerb }<br/>
						C、${single.answerc }<br/>
						D、${single.answerd }<br/>
					</span>
				</p>
			</div>
		</c:forEach>
		
		<c:forEach items="${multipleChoicelist }" var="multiple">
			<p style=" line-height: 20px;margin-left: 25px;">
				<input type="checkbox" id = "${multiple.id }"  name="sc" value="${multiple.id }" />
				<input type="text" id = "score${multiple.id }" placeholder="输入分数" name="score" size="4" />
				<span style="font-family:'微软雅黑';font-szie:14px;">${multiple.multipleTitle }<br/>
					A、${multiple.answera }<br/>
					B、${multiple.answerb }<br/>
					C、${multiple.answerc }<br/>
					D、${multiple.answerd }<br/>
				</span>
			</p>
		</c:forEach>
		
		<c:forEach items="${completionlist }" var="blank">
			<p style=" line-height: 20px;margin-left: 25px;">
				<input type="checkbox" id = "${blank.id }" name="sc" value="${blank.id }" />
				<input type="text" id = "score${blank.id }" placeholder="输入分数" name="score" size="4" />
				<span style="font-family:'微软雅黑';font-szie:14px;">${blank.completionTitle }
				</span>
			</p>
		</c:forEach>
		
		<c:forEach items="${judgmentlist }" var="judge">
			<p style=" line-height: 20px;margin-left: 25px;">
				<input type="checkbox" id = "${judge.id }" name="sc" value="${judge.id }" />
				<input type="text" id = "score${judge.id }" placeholder="输入分数" name="score" size="4" />
				<span style="font-family:'微软雅黑';font-szie:14px;">${judge.judgmentTitle }
				</span>
			</p>
		</c:forEach>
		
		<c:forEach items="${subjectivelist }" var="subjective">
			<p style=" line-height: 20px;margin-left: 25px;">
				<input type="checkbox" id = "${subjective.id }" name="sc" value="${subjective.id }" />
				<input type="text" id = "score${subjective.id }" placeholder="输入分数" name="score" size="4" />
				<span style="font-family:'微软雅黑';font-szie:14px;">${subjective.subjectiveTitle }
				</span>
			</p>
		</c:forEach>
	</div>
</body>
</html>