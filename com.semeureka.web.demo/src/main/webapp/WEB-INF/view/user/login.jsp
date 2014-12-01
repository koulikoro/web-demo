<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">用户登录</h1>
	<form class="form-horizontal" action="${ctx}/user/login" method="post">
		<div class="form-group">
			<label class="col-xs-2 control-label">用户账号</label>
			<div class="col-xs-10">
				<input name="username" type="text" class="form-control" placeholder="用户账号">
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-2 control-label">用户密码</label>
			<div class="col-xs-10">
				<input name="password" type="password" class="form-control" placeholder="用户密码">
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-offset-2 col-xs-10">
				<div class="checkbox">
					<label><input name="rememberMe" type="checkbox" value=""> 记住我的密码 </label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-offset-2 col-xs-10">
				<button type="submit" class="btn btn-default">登录</button>
			</div>
		</div>
	</form>
</tt:frame>