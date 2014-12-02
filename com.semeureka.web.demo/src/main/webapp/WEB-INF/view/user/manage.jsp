<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">用户信息</h1>
	<form class="form-inline form-group clearfix">
		<shiro:hasPermission name="user:create">
			<a href="${ctx}/user/create" class="btn btn-default btn-sm">添加</a>
		</shiro:hasPermission>
		<div class="pull-right">
			<div class="form-group">
				<input type="text" class="form-control input-sm" placeholder="查询条件">
			</div>
			<button type="submit" class="btn btn-default btn-sm">查询</button>
		</div>
	</form>
	<table class="table table-condensed table-bordered">
		<tr>
			<th class="col-no">序号</th>
			<th>所属部门</th>
			<th>用户账号</th>
			<th></th>
		</tr>
		<c:forEach items="${users}" var="user" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.organization.name}</td>
				<td>${user.username}</td>
				<td><a href="${ctx}/user/delete/${user.id}">删除</a> <a href="${ctx}/user/update/${user.id}">修改</a></td>
			</tr>
		</c:forEach>
	</table>

</tt:frame>