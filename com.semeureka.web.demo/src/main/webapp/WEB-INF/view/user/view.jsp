<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<form class="form-inline form-group clearfix">
		<shiro:hasPermission name="user:create">
			<a href="${ctx}/user/create" class="btn btn-default btn-sm">添加</a>
		</shiro:hasPermission>
		<div class="pull-right">
			<input type="text" class="form-control input-sm" placeholder="查询条件">
			<button type="submit" class="btn btn-default btn-sm">查询</button>
		</div>
	</form>
	<table class="table table-condensed table-striped table-bordered">
		<tr>
			<th class="col-no">序号</th>
			<th>用户名称</th>
			<th>用户账户</th>
			<th>所属机构</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${users}" var="user" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.name}</td>
				<td>${user.account}</td>
				<td>${user.organization.name}</td>
				<td>
					<shiro:hasPermission name="user:delete">
						<a href="${ctx}/user/delete/${user.id}" class="confirm-ajax">删除</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="user:update">
						<a href="${ctx}/user/update/${user.id}">修改</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
	</table>
</template:frame>