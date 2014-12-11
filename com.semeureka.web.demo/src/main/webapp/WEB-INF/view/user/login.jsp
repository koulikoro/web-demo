<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">用户登录</h1>
	<form class="form-horizontal validate" action="${ctx}/user/login" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户账户</label>
			<div class="col-md-10">
				<input name="username" type="text" class="form-control" required pattern="[\w]{4,30}">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户密码</label>
			<div class="col-md-10">
				<input name="password" type="password" class="form-control" required maxlength="255">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<div class="col-md-offset-2 col-md-10">
				<div class="checkbox">
					<label><input name="rememberMe" type="checkbox"> 记住我的密码 </label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-default">登录</button>
			</div>
		</div>
	</form>
</tt:frame>