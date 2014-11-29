<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="sh"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">Manage...</h1>
	<form class="form-horizontal">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<a href="${ctx}/user" class="btn btn-default">Add...</a>
			</div>
		</div>
	</form>
	<table class="table">
		<tr>
			<th>No.</th>
			<th>Username</th>
			<th>Password</th>
			<th></th>
		</tr>
		<c:forEach items="${users}" var="user" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td><a href="${ctx}/user/${user.id}/delete">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</tt:frame>