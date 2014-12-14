<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.semeureka.com/functons" prefix="sh"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
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
				<button type="submit" class="btn btn-default">修改</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		<c:if test="${role.contains(root)}">$('[class^="checkbox-"]').prop('checked',true);</c:if>
		$('.checkbox-parent').click(function() {
			$(this).closest('div').find('.checkbox-child').prop('checked', $(this).prop('checked')).prop('disabled', $(this).prop('checked'));
		});
		$('.checkbox-parent').each(function(){
			if($(this).prop('checked')) {
				$(this).closest('div').find('.checkbox-child').prop('checked', $(this).prop('checked')).prop('disabled', $(this).prop('checked'));
			}
		});
	</script>
</tt:frame>