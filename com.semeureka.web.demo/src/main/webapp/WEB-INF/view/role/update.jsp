<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<tt:frame>
	<h1 class="page-header">修改角色</h1>
	<form class="form-horizontal validate" action="${ctx}/role/update/${role.id}" method="post">
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
				<textarea name="description" rows="3" class="form-control" maxlength="255">${role.description}</textarea>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户操作权限</label>
			<div class="col-md-10">
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="user:*" ${role.hasPermission('user:*')?'checked':''}>全部</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="user:create" ${role.hasPermission('user:create')?'checked':''}>添加</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="user:delete" ${role.hasPermission('user:delete')?'checked':''}>删除</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="user:update" ${role.hasPermission('user:update')?'checked':''}>修改</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="user:view" ${role.hasPermission('user:view')?'checked':''}>查看</label>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">角色操作权限</label>
			<div class="col-md-10">
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="role:*" ${role.hasPermission('role:*')?'checked':''}>全部</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="role:create" ${role.hasPermission('role:create')?'checked':''}>添加</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="role:delete" ${role.hasPermission('role:delete')?'checked':''}>删除</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="role:update" ${role.hasPermission('role:update')?'checked':''}>修改</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="role:view" ${role.hasPermission('role:view')?'checked':''}>查看</label>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">机构操作权限</label>
			<div class="col-md-10">
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="organization:*" ${role.hasPermission('organization:*')?'checked':''}>全部</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="organization:create" ${role.hasPermission('organization:create')?'checked':''}>添加</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="organization:delete" ${role.hasPermission('organization:delete')?'checked':''}>删除</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="organization:update" ${role.hasPermission('organization:update')?'checked':''}>修改</label>
				<label class="checkbox-inline"><input name="permission" type="checkbox" value="organization:view" ${role.hasPermission('organization:view')?'checked':''}>查看</label>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-default">修改</button>
			</div>
		</div>
	</form>
</tt:frame>