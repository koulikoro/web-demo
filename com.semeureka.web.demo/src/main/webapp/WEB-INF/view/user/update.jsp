<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">修改用户</h1>
	<form id="user-update" class="form-horizontal" action="${ctx}/user/update/${user.id}" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户账号</label>
			<div class="col-md-10">
				<input name="username" value="${user.username}" type="text" class="form-control" required
					pattern="[\w]{6,30}|[\u4e00-\u9fa5]{2,15}">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户密码</label>
			<div class="col-md-10">
				<input name="password" type="password" class="form-control" required pattern=".{6,30}">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">确认密码</label>
			<div class="col-md-10">
				<input name="password2" type="password" class="form-control" required pattern=".{6,30}">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">所属机构</label>
			<div class="col-md-10">
				<select name="organization.id" class="form-control" required>
					<option></option>
					<c:forEach items="${organizations}" var="organization">
						<option value="${organization.id}" ${user.organization eq organization ? 'selected' : ''}>${organization.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户角色</label>
			<div class="col-md-10">
				<fieldset>
					<c:forEach items="${roles}" var="role">
						<label class="checkbox-inline"><input name="roleIds" type="checkbox" value="${role.id}" required
							minlength="1" <shiro:hasRole name="${role.name}">checked</shiro:hasRole>>${role.name}</label>
					</c:forEach>
				</fieldset>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-default">修改</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$('#user-update').validate();
	</script>
</tt:frame>