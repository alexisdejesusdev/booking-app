var hotelUrl = "rest/hotel";
var bookTripUrl = "rest/book";

function addHotel() {
	// Validate the required form fields
	validateRequired("id");
	validateRequired("name");

	// Get the values from the form fields
	var id = $("#id").val();
	var name = $("#name").val();
	var isMerchant = $("#isMerchant").is(":checked");
	var discount = $("#discount").val();
	var details = $("#details").val();
	var link = $("#link").val();

	if (isMerchant) {
		validateRequired("discount");
		validateDiscount(discount);
	}

	// Create the data model to be sent
	var hotel = {
		id : id,
		name : name,
		isMerchant : isMerchant,
		discount : discount,
		details : details,
		link : link
	};

	// Post the request to the server
	post(hotelUrl, hotel, addHotelSuccess, addHotelError);
}

function addHotelSuccess(response) {
	alert("Hotel added successfully. ");
	window.location.reload();
}

function addHotelError(response) {
	alert("There was an error adding the hotel. "
			+ response.responseJSON.message);
}

function initBooking() {
	getAllHotels();
}

function bookTrip() {
	// Validate the required form fields
	validateRequired("type");
	validateRequired("hotel");
	validateRequired("cost");
	validateRequired("discount");
	validateRequired("finalPrice");
	validateRequired("creditCardNumber");
	validateRequired("currencySymbol");

	// Get the values from the form fields
	var type = $("#type").val();
	var hotel = $("#hotel").val();
	var cost = $("#cost").val();
	var discount = $("#discount").val();
	var finalPrice = $("#finalPrice").val();
	var creditCardNumber = $("#creditCardNumber").val();
	var currencySymbol = $("#currencySymbol").val();
	var details = $("#details").val();

	// Validate specific values
	validateCreditCardNumber(creditCardNumber);
	validateCurrencySymbol(currencySymbol);
	
	// Create the data model to be sent
	var trip = {
		type : type,
		hotel : {
			id : hotel,
		},
		cost : cost,
		discount : discount,
		finalPrice : finalPrice,
		creditCard : {
			number : creditCardNumber
		},
		currencySymbol : currencySymbol,
		details : details
	};

	// Post the request to the server
	post(bookTripUrl, trip, bookTripSuccess, bookTripError);
}

function bookTripSuccess(response) {
	$("#bookingSuccessId").html(response.id);
	
	$("#bookingSuccessType").html(response.type);
	$("#bookingSuccessHotelName").html(response.hotel.name);
	$("#bookingSuccessCost").html(response.currencySymbol + " " + response.cost);
	$("#bookingSuccessDiscount").html(response.currencySymbol + " " + response.discount);
	$("#bookingSuccessFinalPrice").html(response.currencySymbol + " " + response.finalPrice);
	
	var creditCardNumber = response.creditCard.number.toString();
	$("#bookingSuccessCreditCardNumber").html("****-****-****-" + creditCardNumber.substring(12, 16));
	
	$("#bookingSuccessDetails").html(response.details);

	hideElement("bookingForm");
	showElement("bookingSuccess");
}

function bookTripError(response) {
	alert("There was an error adding the hotel. "
			+ response.responseJSON.message);
}

function getAllHotels() {
	get(hotelUrl, getAllHotelsSuccess, getAllHotelsError);
}

function getAllHotelsSuccess(response) {
	var hotelSelect = $("#hotel");

	if (response.length > 0) {
		$.each(response, function(index, item) {
			var optionHtml = "<option value='" + item.id
					+ "' data-isMerchant='" + item.isMerchant + "'";

			if (item.isMerchant) {
				optionHtml += " data-discount='" + item.discount + "'";
			}

			optionHtml += ">" + item.name + "</option>"

			hotelSelect.append(optionHtml);
		});

		resolveHotelSpecifics();

	} else {
		alert("You must add at least one hotel to book a trip. ");
		window.location.href = "index.html";
	}
}

function getAllHotelsError(response) {
	alert("You must add at least one hotel to book a trip. ");
	window.location.href = "index.html";
}

function resolveHotelSpecifics() {
	getTripCost();
	getCalculatedFields();
}

function getTripCost() {
	var random = (Math.random() * (10000 - 500) + 500).toFixed(2);

	$("#cost").val(random);
}

function getCalculatedFields() {
	var hotelSelect = $("#hotel");

	var selected = hotelSelect.find("option:selected");
	var isMerchant = selected.data("ismerchant");

	var cost = $("#cost").val();
	var discount = 0;

	if (isMerchant) {
		discount = cost * selected.data("discount") / 100;
		discount = Math.round(discount * 100) / 100;
	}

	var finalPrice = cost - discount;
	finalPrice = Math.round(finalPrice * 100) / 100;

	$("#discount").val(discount);
	$("#finalPrice").val(finalPrice);
}