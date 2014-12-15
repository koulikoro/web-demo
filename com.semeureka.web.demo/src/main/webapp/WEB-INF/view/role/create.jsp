<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<h1 class="page-header">添加角色</h1>
	<form class="form-horizontal validate" action="${ctx}/role/create" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">角色名称</label>
			<div class="col-md-10">
				<input name="name" type="text" class="form-control" required maxlength="255">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">角色描述</label>
			<div class="col-md-10">
				<textarea name="description" rows="2" class="form-control" maxlength="255"></textarea>
			</div>
		</div>
		<c:forEach items="${root.children}" var="perm1">
			<div class="form-group form-group-sm">
				<label class="col-md-2 control-label">${perm1.name}</label>
				<div class="col-md-10">
					<label class="checkbox-inline"><input name="permissionIds" value="${perm1.id}" type="checkbox" class="checkbox-parent">全部</label>
					<c:forEach items="${perm1.children}" var="perm2">
						<label class="checkbox-inline"><input name="permissionIds" value="${perm2.id}" type="checkbox" class="checkbox-child">${perm2.name}</label>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-primary">添加</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$('.checkbox-parent').click(function() {
			$(this).closest('div').find('.checkbox-child').prop('checked', $(this).prop('checked')).prop('disabled', $(this).prop('checked'));
		})
	</script>
</template:frame>