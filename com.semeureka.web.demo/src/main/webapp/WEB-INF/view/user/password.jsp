<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<form class="form-horizontal validate" action="${ctx}/user/password" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户名称</label>
			<div class="col-md-10">
				<input name="account" value="${user.name}" type="text" class="form-control" readonly>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">旧密码</label>
			<div class="col-md-10">
				<input name="oldPassword" type="password" class="form-control" required pattern=".{5,30}">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">新密码</label>
			<div class="col-md-10">
				<input name="newPassword" type="password" class="form-control" required pattern=".{5,30}">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">确认密码</label>
			<div class="col-md-10">
				<input name="newPassword2" type="password" class="form-control" required equalTo="[name='newPassword']">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-primary">修改</button>
			</div>
		</div>
	</form>
</template:frame>