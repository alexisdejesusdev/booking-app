/**
 * Defines a post function to hide the implementation of the call.
 */
function post(url, data, successHandler, errorHandler) {
	var jqxhr = $.ajax({
		url : url,
		type : "POST",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : "json",
	}).done(successHandler).fail(errorHandler);
}

function get(url, data, successHandler, errorHandler) {
	var jqxhr = $.ajax({
		url : url,
		type : "GET",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
	}).done(successHandler).fail(errorHandler);
}