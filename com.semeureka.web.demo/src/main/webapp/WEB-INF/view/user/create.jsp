<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">添加用户</h1>
	<form id="user-create" class="form-horizontal" action="${ctx}/user/create" method="post">
		<div class="form-group form-group-sm">
			<label class="col-sm-2 control-label">用户账号</label>
			<div class="col-sm-10">
				<input name="username" type="text" class="form-control" placeholder="用户账号" required
					pattern="[\w]{6,30}|[\u4e00-\u9fa5]{2,15}">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-sm-2 control-label">用户密码</label>
			<div class="col-sm-10">
				<input name="password" type="password" class="form-control" placeholder="用户密码" required pattern=".{6,30}">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-sm-2 control-label">确认密码</label>
			<div class="col-sm-10">
				<input name="password2" type="password" class="form-control" placeholder="确认密码" required pattern=".{6,30}"
					equalTo="[name='password']">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-sm-2 control-label">所属机构</label>
			<div class="col-sm-10">
				<select name="organization.id" class="form-control" required>
					<option value=""></option>
					<c:forEach items="${organizations}" var="organization">
						<option value="${organization.id}">${organization.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-sm-2 control-label">用户角色</label>
			<div class="col-sm-10">
				<fieldset>
					<c:forEach items="${roles}" var="role">
						<label class="checkbox-inline"><input name="roleIds" type="checkbox" value="${role.id}" required
							minlength="1">${role.name}</label>
					</c:forEach>
				</fieldset>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$('#user-create').validate();
	</script>
</tt:frame>