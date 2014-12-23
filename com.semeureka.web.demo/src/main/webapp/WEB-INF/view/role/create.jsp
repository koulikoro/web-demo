<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
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
		<c:forEach items="${resource.children}" var="res0">
		<c:forEach items="${res0.children}" var="res1">
		<c:forEach items="${res1.children}" var="res2">
			<div class="form-group">
				<label class="col-md-2 control-label">${res2.name}</label>
				<div class="col-md-10">
					<label class="checkbox-inline"><input name="resourceIds" value="${res2.id}" type="checkbox"
						class="checkbox-parent">访问页面</label>
					<c:forEach items="${res2.children}" var="res3">
					<label class="checkbox-inline"><input name="resourceIds" value="${res3.id}" type="checkbox"
						class="checkbox-child">${res3.name}</label>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
		</c:forEach>
		</c:forEach>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-primary">添加</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$('.checkbox-parent').click(function(){
			if (!$(this).prop('checked')) {
				$(this).closest('div').find('.checkbox-child').prop('checked', false);
			}
		});
		$('.checkbox-child').click(function(){
			if ($(this).prop('checked')) {
				$(this).closest('div').find('.checkbox-parent').prop('checked', true);
			}
		});
	</script>
</template:frame>