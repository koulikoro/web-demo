<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.semeureka.com/functons" prefix="sh"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">用户信息</h1>
	<form class="form-inline form-group clearfix">
		<a href="${ctx}/user/create" class="btn btn-default btn-sm${sh:hasPermission('user:create')?'':' hidden'}">添加</a>
		<div class="pull-right">
			<div class="form-group">
				<input type="text" class="form-control input-sm" placeholder="查询条件">
			</div>
			<button type="submit" class="btn btn-default btn-sm">查询</button>
		</div>
	</form>
	<table class="table table-condensed table-striped table-bordered">
		<tr>
			<th class="col-no">序号</th>
			<th>用户账户</th>
			<th>用户名称</th>
			<th>所属机构</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${users}" var="user" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.account}</td>
				<td>${user.name}</td>
				<td>${user.organization.name}</td>
				<td><a href="${ctx}/user/delete/${user.id}" class="confirm-ajax${sh:hasPermission('user:delete')?'':' hidden'}">删除</a>
					<a href="${ctx}/user/update/${user.id}" class="${sh:hasPermission('user:update')?'':'hidden'}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</tt:frame>