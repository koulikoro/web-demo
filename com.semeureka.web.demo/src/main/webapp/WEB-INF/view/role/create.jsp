<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">添加角色</h1>
	<form id="role-create" class="form-horizontal" action="${ctx}/role/create" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">角色名称</label>
			<div class="col-md-10">
				<input name="name" type="text" class="form-control" required pattern="[\w]{6,30}|[\u4e00-\u9fa5]{2,15}">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label">角色描述</label>
			<div class="col-md-10">
				<textarea name="description" rows="3" class="form-control" maxlength="255" ></textarea>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">用户操作权限</label>
			<div class="col-md-10">
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="user:*">全部</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="user:create">添加</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="user:delete">删除</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="user:update">修改</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="user:view">查看</label>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">角色操作权限</label>
			<div class="col-md-10">
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="role:*">全部</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="role:create">添加</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="role:delete">删除</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="role:update">修改</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="role:view">查看</label>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">机构操作权限</label>
			<div class="col-md-10">
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="organization:*">全部</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="organization:create">添加</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="organization:delete">删除</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="organization:update">修改</label>
				<label class="checkbox-inline"> <input name="permission" type="checkbox" value="organization:view">查看</label>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$('#role-create').validate();
	</script>
</tt:frame>