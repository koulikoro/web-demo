<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<form class="form-inline form-group clearfix" action="${ctx}/role">
		<shiro:hasPermission name="role:create">
			<a href="${ctx}/role/create" class="btn btn-default btn-sm">添加</a>
		</shiro:hasPermission>
		<div class="pull-right">
			<input type="text" class="form-control input-sm" placeholder="查询条件">
			<button type="submit" class="btn btn-default btn-sm">查询</button>
		</div>
	</form>
	<table class="table table-condensed table-striped table-bordered">
		<tr>
			<th class="col-no">序号</th>
			<th>角色名称</th>
			<th>角色描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${roles}" var="role" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${role.name}</td>
				<td>${role.description}</td>
				<td>
					<shiro:hasPermission name="role:delete">
						<a href="${ctx}/role/delete/${role.id}" class="confirm-ajax">删除</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="role:update">
						<a href="${ctx}/role/update/${role.id}">修改</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
	</table>
</template:frame>