<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<form class="form-horizontal validate" action="${ctx}/user/update/${user.id}" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户名称</label>
			<div class="col-md-10">
				<input name="name" value="${user.name}" type="text" class="form-control" required maxlength="255">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户账户</label>
			<div class="col-md-10">
				<input name="account" value="${user.account}" type="text" class="form-control" readonly="readonly">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户密码</label>
			<div class="col-md-10">
				<input name="password" type="text" class="form-control" pattern=".{5,30}">
				<p class="help-block">用户密码为空时“保留”原用户密码。</p>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">所属机构</label>
			<div class="col-md-10">
				<select name="organizationId" class="form-control">
					<c:forEach items="${organizations}" var="organization">
						<option value="${organization.id}" ${user.belongs(organization)?'selected':''}>${organization.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户角色</label>
			<div class="col-md-10">
				<c:forEach items="${roles}" var="role">
					<label class="checkbox-inline"><input name="roleIds" type="checkbox" value="${role.id}"
						${user.contains(role)?'checked':''}>${role.name}</label>
				</c:forEach>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-primary">修改</button>
			</div>
		</div>
	</form>
</template:frame>