<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="sh"%>
<tt:frame>
	<h1 class="page-header">Welcome...</h1>
	<p>
		Welcome,
		<sh:principal />
		<a href="${ctx}/user/logout" class="btn btn-default">Logout</a> <a href="${ctx}/user/edit/<sh:principal />"
			class="btn btn-primary">Edit</a>
	</p>
</tt:frame>