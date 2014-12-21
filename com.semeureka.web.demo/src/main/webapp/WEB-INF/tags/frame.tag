<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false" type="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session" />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${navs[0].name}</title>
<link href="${ctx}/resources/bootstrap/3.3.1/css/bootstrap${theme}.css" rel="stylesheet">
<link href="${ctx}/resources/custom/common.css" rel="stylesheet">
<!--[if lt IE 9]>
	<script src="${ctx}/resources/html5shiv/3.7.2/html5shiv.js"></script>
	<script src="${ctx}/resources/respond/1.4.2/respond.js"></script>
<![endif]-->
<script src="${ctx}/resources/jquery/1.11.1/jquery.js"></script>
<script src="${ctx}/resources/bootstrap/3.3.1/js/bootstrap.js"></script>
<script src="${ctx}/resources/jquery.validate/1.13.1/jquery.validate.js"></script>
<script src="${ctx}/resources/custom/common.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
					<span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${ctx}/menu/${navs[0].id}">${navs[0].name}</a>
			</div>
			<div id="navbar-collapse" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<c:forEach items="${navs[0].children}" var="menu">
						<c:if test="${menu.accessible}">
							<li class="${menu eq navs[1]?'active':''}"><a href="${ctx}/menu/${menu.id}">${menu.name}</a></li>
						</c:if>
					</c:forEach>
				</ul>
				<shiro:user>
					<p class="navbar-text navbar-right">
						当前用户（
						<shiro:principal property="name" />
						） <a href="${ctx}/user/password" class="navbar-link"><span class="glyphicon glyphicon-lock"></span></a> <a
							href="${ctx}/user/logout" class="navbar-link confirm" data-confirm="确认要退出吗?"><span
							class="glyphicon glyphicon-log-out"></span></a>
					</p>
				</shiro:user>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<c:forEach items="${navs[1].children}" var="menu">
					<c:if test="${menu.accessible}">
						<div class="panel panel-default">
							<div class="panel-heading">${menu.name}</div>
							<ul class="list-group">
								<c:forEach items="${menu.children}" var="menu">
									<c:if test="${menu.accessible}">
										<a href="${ctx}/menu/${menu.id}" class="list-group-item ${menu eq navs[3]?'active':''}">${menu.name}</a>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div class="col-md-10">
				<ol class="breadcrumb">
					<c:forEach items="${navs}" var="menu" begin="1">
						<li><a href="${ctx}/menu/${menu.id}">${menu.name}</a></li>
					</c:forEach>
				</ol>
				<jsp:doBody />
			</div>
		</div>
	</div>
</body>
</html>