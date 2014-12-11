<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.semeureka.com/functons" prefix="sh"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">添加机构</h1>
	<form id="organization-create validate" class="form-horizontal" action="${ctx}/organization/create" method="post">
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
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>
</tt:frame>