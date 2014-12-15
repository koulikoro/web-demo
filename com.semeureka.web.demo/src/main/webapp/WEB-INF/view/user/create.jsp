<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<h1 class="page-header">添加用户</h1>
	<form class="form-horizontal validate" action="${ctx}/user/create" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户名称</label>
			<div class="col-md-10">
				<input name="name" type="text" class="form-control" required maxlength="255">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户账户</label>
			<div class="col-md-10">
				<input name="account" type="text" class="form-control" required pattern="[\w]{5,30}">
				<p class="help-block">初始用户密码为“123456”。</p>
				<input name="password" type="hidden" value="123456">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">所属机构</label>
			<div class="col-md-10">
				<select name="organization.id" class="form-control">
					<c:forEach items="${organizations}" var="organization">
						<option value="${organization.id}">${organization.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户角色</label>
			<div class="col-md-10">
				<c:forEach items="${roles}" var="role">
					<label class="checkbox-inline"><input name="roleIds" type="checkbox" value="${role.id}">${role.name}</label>
				</c:forEach>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-primary">添加</button>
			</div>
		</div>
	</form>
</template:frame>