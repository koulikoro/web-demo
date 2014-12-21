<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<c:set var="themes" value="cerulean,cosmo,cyborg,darkly,flatly,lumen,paper,sandstone,simplex,slate,superhero,united" />
	<form id="theme-update" class="form-horizontal" action="${ctx}/theme" method="post">
		<div class="form-group form-group-sm">
			<label class="col-md-2 control-label">风格样式类型</label>
			<div class="col-md-10">
				<select id="theme" name="theme" class="form-control">
					<option value="">.default</option>
					<c:forTokens items="${themes}" delims="," var="theme">
						<option value=".${theme}">.${theme}</option>
					</c:forTokens>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label">风格样式示例</label>
			<div class="col-md-10">
				<div class="row" style="padding-bottom: 15px">
					<c:forTokens items="${themes}" delims="," var="theme">
						<div class="col-md-3 col-sm-4" style="padding-bottom: 15px;">
							<img alt=".${theme}" src="${ctx}/resources/image/theme/${theme}.png" class="img-responsive img-thumbnail">
						</div>
					</c:forTokens>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$('#theme').val('${theme}');
			$('[alt="${theme}"]').css('background-color','#ff0000');
			$('#theme').change(function() {
				$('#theme-update').submit();
			});
			$('.img-responsive').click(function() {
				$('#theme').val($(this).prop('alt'));
				$('#theme').change();
			});
		</script>
	</form>
</template:frame>