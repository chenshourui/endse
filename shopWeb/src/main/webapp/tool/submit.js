
/**
 * 数据提交方法
 * 
 * @param url
 *            请求路径
 * @param data
 *            数据
 * @param success
 *            成功回调方法
 */
function ajaxSubmit(url, data, success) {
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		data : data,
		url : url,
		error : function() {// 请求失败处理函数
		},
		success : success
	});
}

function ajaxSubmitAsync(url, data, success) {
	$.ajax({
		async : true,
		cache : false,
		type : 'POST',
		data : data,
		url : url,
		error : function() {// 请求失败处理函数
		},
		success : success
	});
}

/**
 * 数据提交方法（可以包含List数据）
 * 
 * @param url
 *            请求路径
 * @param data
 *            数据
 * @param success
 *            成功回调方法
 */
function ajaxSubmitJson(url, data, success) {
	$.ajax({
		async : false,
		contentType : "application/json;charset=utf-8",
		cache : false,
		type : 'POST',
		dataType:"json",
		data : JSON.stringify(data),
		url : url,
		error : function() {// 请求失败处理函数
		},
		success : success
	});
}

/**
 * 数据提交方法（可以包含List数据）
 * 
 * @param url
 *            请求路径
 * @param data
 *            数据
 * @param success
 *            成功回调方法
 */
function ajaxSubmitListJson(url, data, success) {
	$.ajax({
		async : false,
		contentType : "application/json;charset=utf-8",
		cache : false,
		type : 'POST',
		dataType : "json",
		data : JSON.stringify(data),
		url : url,
		error : function() {// 请求失败处理函数
		},
		success : success
	});
}
