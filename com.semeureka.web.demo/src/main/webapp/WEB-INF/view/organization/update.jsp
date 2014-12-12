<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.semeureka.com/functons" prefix="sh"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">修改机构</h1>
	<form class="form-horizontal validate" action="${ctx}/organization/update/${organization.id}" method="post">
		<input name="path" value="${organization.path}" type="hidden">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">机构名称</label>
			<div class="col-md-10">
				<input name="name" value="${organization.name}" type="text" class="form-control" required maxlength="255">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">上级机构</label>
			<div class="col-md-10">
				<select name="parent.id" class="form-control" readonly>
					<option value="${organization.parent.id}" selected>${organization.parent.name}</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-default">修改</button>
			</div>
		</div>
	</form>
</tt:frame>