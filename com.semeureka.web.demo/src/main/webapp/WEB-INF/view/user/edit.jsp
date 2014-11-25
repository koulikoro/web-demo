<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="sh"%>
<tt:frame>
	<h1 class="page-header">Edit...</h1>
	<form id="edit" action="${ctx}/user/edit" method="post">
		<div class="form-group">
			<label>Username</label> <input name="username" value="${user.username}" type="text" class="form-control"
				placeholder="Username" required="required">
		</div>
		<div class="form-group">
			<label>Password</label> <input name="password" value="${user.password}" type="password"
				class="form-control" placeholder="Password" required="required">
		</div>
		<button type="submit" class="btn btn-default">Update</button>
	</form>
</tt:frame>