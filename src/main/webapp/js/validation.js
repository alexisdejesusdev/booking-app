function validateRequired(id) {
	var element = $("#" + id);

	var value = element.val();

	var message = "The field '" + id + "' is required. ";

	if (value == null || value == "") {
		alert(message);
		throw Error(message);
	}
}

function validateDiscount(value) {
	var message = "The discount value mus be between 0 and 100 percent. (0 - 100) ";

	var discount = parseInt(value);

	if (isNaN(discount) || (discount < 0 && discount > 100)) {
		alert(message);
		throw Error(message);
	}
}

function validateCreditCardNumber(value) {
	var regex = "[0123456789]{16}";

	var message = "The credit card number must contain 16 digits. ";

	if (!value.match(regex)) {
		alert(message);
		throw new Error(message);
	}
}

function validateCurrencySymbol(value) {
	var currencies = "₳฿₵¢₡₢$₫₯֏₠€ƒ₣₲₴₭₺₾ℳ₥₦₧₱₰£៛₽₹₨₪৳​₸₮₩¥";
	var regex = "^[" + currencies + "](?!.+)";

	var message = "The currency symbol '" + value
			+ "' is not allowed from the following list: " + currencies;

	if (!value.match(regex)) {
		alert(message);
		throw new Error(message);
	}
}