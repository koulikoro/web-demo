<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.semeureka.com/functons" prefix="sh"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">修改密码</h1>
	<form class="form-horizontal validate" action="${ctx}/user/password" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户名称</label>
			<div class="col-md-10">
				<input value="${user.name}" type="text" class="form-control" readonly>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">旧密码</label>
			<div class="col-md-10">
				<input name="oldPassword" type="password" class="form-control" required pattern=".{6,30}">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">新密码</label>
			<div class="col-md-10">
				<input name="newPassword" type="password" class="form-control" required pattern=".{6,30}">
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
				<button type="submit" class="btn btn-default btn-sm">修改</button>
			</div>
		</div>
	</form>
</tt:frame>