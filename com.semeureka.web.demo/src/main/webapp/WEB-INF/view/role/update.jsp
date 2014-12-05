<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<tt:frame>
	<h1 class="page-header">修改角色</h1>
	<form id="role-update" class="form-horizontal" action="${ctx}/role/update/${role.id}" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">角色名称</label>
			<div class="col-md-10">
				<input name="name" value="${role.name}" type="text" class="form-control" required
					pattern="[\w]{6,30}|[\u4e00-\u9fa5]{2,15}">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label">角色描述</label>
			<div class="col-md-10">
				<textarea name="description" rows="3" class="form-control" required maxlength="255">${role.description}</textarea>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户操作权限</label>
			<div class="col-md-10">
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="user:*" ${role.contains('user:*') ? 'checked' : ''}>全部</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="user:create" ${role.contains('user:create') ? 'checked' : ''}>添加</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="user:delete" ${role.contains('user:delete') ? 'checked' : ''}>删除</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="user:update" ${role.contains('user:update') ? 'checked' : ''}>修改</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="user:view" ${role.contains('user:view') ? 'checked' : ''}>查看</label>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">组织操作权限</label>
			<div class="col-md-10">
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="organization:*" ${role.contains('organization:*') ? 'checked' : ''}>全部</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="organization:create" ${role.contains('organization:create') ? 'checked' : ''}>添加</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="organization:delete" ${role.contains('organization:delete') ? 'checked' : ''}>删除</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="organization:update" ${role.contains('organization:update') ? 'checked' : ''}>修改</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="organization:view" ${role.contains('organization:view') ? 'checked' : ''}>查看</label>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">角色操作权限</label>
			<div class="col-md-10">
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="role:*" ${role.contains('role:*') ? 'checked' : ''}>全部</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="role:create" ${role.contains('role:create') ? 'checked' : ''}>添加</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="role:delete" ${role.contains('role:delete') ? 'checked' : ''}>删除</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="role:update" ${role.contains('role:update') ? 'checked' : ''}>修改</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="role:view" ${role.contains('role:view') ? 'checked' : ''}>查看</label>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-default">修改</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$('#role-update').validate();
	</script>
</tt:frame>