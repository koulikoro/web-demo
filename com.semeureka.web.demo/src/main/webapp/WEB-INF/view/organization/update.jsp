<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.semeureka.com/functons" prefix="sh"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">修改机构</h1>
	<form id="organization-update" class="form-horizontal" action="${ctx}/organization/update/${organization.id}"
		method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">机构名称</label>
			<div class="col-md-10">
				<input name="name" value="${organization.name}" type="text" class="form-control" required maxlength="255">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">上级机构</label>
			<div class="col-md-10">
				<select name="parentId" class="form-control" required>
					<option value="${sh:principal().organization.id}">${sh:principal().organization.name}</option>
					<c:forEach items="${organizations}" var="parent">
						<option value="${parent.id}" ${organization.parent eq parent ? 'selected' : ''}>${parent.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-default">修改</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$('#organization-update').validate();
	</script>
</tt:frame>