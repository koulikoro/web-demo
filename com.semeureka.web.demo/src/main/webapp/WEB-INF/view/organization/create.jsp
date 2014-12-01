<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="sh"%>
<tt:frame>
	<h1 class="page-header">添加部门</h1>
	<form class="form-horizontal" action="${ctx}/organization/create" method="post">
		<div class="form-group">
			<label class="col-sm-2 control-label">部门名称</label>
			<div class="col-sm-10">
				<input name="name" type="text" class="form-control" placeholder="name">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>
</tt:frame>