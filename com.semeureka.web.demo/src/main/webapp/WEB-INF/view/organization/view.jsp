<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<h1 class="page-header">机构信息</h1>
	<form class="form-inline form-group clearfix" action="${ctx}/organization">
		<shiro:hasPermission name="organization:create">
			<a href="${ctx}/organization/create" class="btn btn-default btn-sm">添加</a>
		</shiro:hasPermission>
		<div class="pull-right">
			<input type="password" class="form-control input-sm" placeholder="查询条件">
			<button type="submit" class="btn btn-default btn-sm">查询</button>
		</div>
	</form>
	<table class="table table-condensed table-striped table-bordered">
		<tr>
			<th class="col-no">序号</th>
			<th>机构名称</th>
			<th>上级机构</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${organizations}" var="organization" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${organization.name}</td>
				<td>${organization.parent.name}</td>
				<td>
					<shiro:hasPermission name="organization:delete">
						<a href="${ctx}/organization/delete/${organization.id}" class="confirm-ajax">删除</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="organization:update">
						<a href="${ctx}/organization/update/${organization.id}">修改</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
	</table>
</template:frame>