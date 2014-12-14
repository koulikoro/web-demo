<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<tt:frame>
	<h1 class="page-header">
		没有足够的权限执行此操作，<span id="time">10</span>秒后跳转到<a href="${ctx}/user/logout">登录</a>页面...
	</h1>
	<script type="text/javascript">
		setInterval(function() {
			if ($('#time').text() = 0) {
				location.href = '${ctx}/user/logout';
			}
			$('#time').text($('#time').text() - 1);
		}, 1000);
	</script>
</tt:frame>