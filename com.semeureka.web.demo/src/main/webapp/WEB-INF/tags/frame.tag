<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false" type="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${title}</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session" />
<link href="${ctx}/resources/bootstrap/3.3.1/css/bootstrap.united.css" rel="stylesheet">
<!--[if lt IE 9]>
	<script src="${ctx}/resources/html5shiv/3.7.2/html5shiv.js"></script>
	<script src="${ctx}/resources/respond/1.4.2/respond.js"></script>
<![endif]-->
<script src="${ctx}/resources/jquery/1.11.1/jquery.js"></script>
<script src="${ctx}/resources/bootstrap/3.3.1/js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<jsp:doBody />
	</div>
</body>
</html>