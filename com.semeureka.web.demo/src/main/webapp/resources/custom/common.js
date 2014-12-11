// 添加jQuery.validator的pattern规则
$.validator.addMethod("pattern", function(value, element, param) {
	if (this.optional(element)) {
		return true;
	}
	if (typeof param === "string") {
		param = new RegExp("^(?:" + param + ")$");
	}
	return param.test(value);
}, "Invalid format.");
// 设置jQuery.validator的默认参数
jQuery.validator.setDefaults({
	errorClass : 'help-block validate-error',
	errorElement : 'p',
	highlight : function(element, errorClass, validClass) {
		$(element).closest('.form-group').addClass('has-warning');
	},
	unhighlight : function(element, errorClass, validClass) {
		$(element).closest('.form-group').removeClass('has-warning');
	},
	errorPlacement : function(error, element) {
		// $(element).closest('div').append(error);
	}
});
// DOM加载完成时执行
$(function() {
	// 启用jQuery.validator验证功能
	$('form.validate').validate();
	// 添加.confirm，.confirm-ajax两个类的操作前确认功能
	$('a.confirm').click(function() {
		if (!confirm('确认要执行该操作吗?')) {
			return false;
		}
	});
	$('a.confirm-ajax').click(function() {
		if (!confirm('确认要执行该操作吗?')) {
			return false;
		}
		var url = $(this).attr('href');
		$.get(url).complete(function(jqXHR, textStatus) {
			if (jqXHR.status == 200) {
				location.reload();
			} else {
				alert('操作失败，异常代码[' + jqXHR.status + ']，相关信息：' + jqXHR.statusText);
			}
		});
		return false;
	});
});