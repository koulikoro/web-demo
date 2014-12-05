<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">机构信息</h1>
	<form class="form-inline form-group clearfix" action="${ctx}/organization">
		<shiro:hasPermission name="organization:create">
			<a href="${ctx}/organization/create" class="btn btn-default btn-sm">添加</a>
		</shiro:hasPermission>
		<div class="pull-right">
			<div class="form-group">
				<input type="password" class="form-control input-sm" placeholder="查询条件">
			</div>
			<button type="submit" class="btn btn-default btn-sm">查询</button>
		</div>
	</form>
	<table class="table table-condensed table-striped table-bordered">
		<tr>
			<th class="col-no">序号</th>
			<th>上级机构</th>
			<th>机构名称</th>
			<th></th>
		</tr>
		<c:forEach items="${organizations}" var="organization" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${organization.parent.name}</td>
				<td>${organization.name}</td>
				<td><a href="${ctx}/organization/delete/${organization.id}">删除</a> <a
					href="${ctx}/organization/update/${organization.id}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</tt:frame>