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

/**
 * 
 */
function get(url, successHandler, errorHandler) {
	var jqxhr = $.ajax({
		url : url,
		type : "GET",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
	}).done(successHandler).fail(errorHandler);
}

function showElement(id) {
	$("#" + id).removeClass("hidden");
}

function hideElement(id) {
	$("#" + id).addClass("hidden");
}

function clearValue(id) {
	$("#" + id).val("");
}

function checkToggle(checkbox, containerId, fieldId) {
	var checked = $(checkbox).is(":checked");

	if (checked) {
		showElement(containerId);

	} else {
		hideElement(containerId);
		
		if (fieldId != undefined){
			clearValue(fieldId);
		}
	}
}