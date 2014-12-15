<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<h1 class="page-header">修改角色</h1>
	<form class="form-horizontal validate" action="${ctx}/role/update/${role.id}" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">角色名称</label>
			<div class="col-md-10">
				<input name="name" value="${role.name}" type="text" class="form-control" required maxlength="255">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">角色描述</label>
			<div class="col-md-10">
				<textarea name="description" rows="3" class="form-control" maxlength="255">${role.description}</textarea>
			</div>
		</div>
		<c:forEach items="${root.children}" var="perm1">
			<div class="form-group form-group-sm">
				<label class="col-md-2 control-label">${perm1.name}</label>
				<div class="col-md-10">
					<label class="checkbox-inline"><input name="permissionIds" type="checkbox" value="${perm1.id}"
						class="checkbox-parent" ${role.contains(perm1)?'checked':''}>全部</label>
					<c:forEach items="${perm1.children}" var="perm2">
						<label class="checkbox-inline"><input name="permissionIds" type="checkbox" value="${perm2.id}"
							class="checkbox-child" ${role.contains(perm2)?'checked':''}>${perm2.name}</label>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-primary">修改</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		<%-- 如果角色有ROOT权限，选中所有项 --%>
		<c:if test="${role.contains(root)}">$('[class^="checkbox-"]').prop('checked',true);</c:if>
		$('.checkbox-parent').click(function() {
			<%-- 选中全部时，选中所有子项，然后禁用；取消选中全部时，取消选中所有子项，然后启用 --%> 
			$(this).closest('div').find('.checkbox-child').prop('checked', $(this).prop('checked')).prop('disabled', $(this).prop('checked'));
		});
		$('.checkbox-parent').each(function(){
			<%-- 初始化选中状态 --%>
			if($(this).prop('checked')) {
				$(this).closest('div').find('.checkbox-child').prop('checked', $(this).prop('checked')).prop('disabled', $(this).prop('checked'));
			}
		});
	</script>
</template:frame>