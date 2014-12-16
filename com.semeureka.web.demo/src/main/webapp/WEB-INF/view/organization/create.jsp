<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<h1 class="page-header">添加机构</h1>
	<form class="form-horizontal validate" action="${ctx}/organization/create" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">机构名称</label>
			<div class="col-md-10">
				<input name="name" type="text" class="form-control" required maxlength="255">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">上级机构</label>
			<div class="col-md-10">
				<select name="parentId" class="form-control">
					<c:forEach items="${organizations}" var="parent">
						<option value="${parent.id}">${parent.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-primary">添加</button>
			</div>
		</div>
	</form>
</template:frame>