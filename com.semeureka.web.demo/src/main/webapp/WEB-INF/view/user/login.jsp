<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame title="登录...">
	<h1 class="page-header">登录...</h1>
	<form action="${ctx}/user/login" method="post">
		<div class="form-group">
			<label>用户名称</label> <input name="username" type="text" class="form-control" placeholder="用户名称">
		</div>
		<div class="form-group">
			<label>用户密码</label> <input name="password" type="password" class="form-control" placeholder="用户密码">
		</div>
		<div class="checkbox">
			<label><input name="rememberMe" type="checkbox">记住我的密码</label>
		</div>
		<button type="submit" class="btn btn-default">登录</button>
	</form>
</tt:frame>