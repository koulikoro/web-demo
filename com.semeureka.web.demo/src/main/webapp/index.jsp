<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Loading...</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session" />
<link href="${ctx}/resources/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
<!--[if lt IE 9]>
	<script src="${ctx}/resources/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="${ctx}/resources/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<div class="container">
		<h1 class="page-header">Loading...</h1>
	</div>
	<script src="${ctx}/resources/jquery/1.11.1/jquery.js"></script>
	<script src="${ctx}/resources/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>