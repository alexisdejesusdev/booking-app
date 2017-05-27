var hotelUrl = "rest/hotel";
var bookTripUrl = "rest/book";

function addHotel() {
	alert("Adding hotel...");

	// Get the values from the form fields
	var id = $("#id").val();
	var name = $("#name").val();
	var isMerchant = $("#isMerchant").is(":checked");
	var discount = $("#discount").val();
	var details = $("#details").val();
	var link = $("#link").val();

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
	alert("addHotelSuccess");
}

function addHotelError(response) {
	alert("addHotelError");
}

function bookTrip() {
	alert("Booking trip...");

	// Get the values from the form fields
	var type = $("#type").val();
	var hotelName = $("#hotelName").val();
	var cost = $("#cost").val();
	var discount = $("#discount").val();
	var finalPrice = $("#finalPrice").val();
	var creditCardNumber = $("#creditCardNumber").val();
	var details = $("#details").val();
	var currencySymbol = $("#currencySymbol").val();

	// Create the data model to be sent
	var trip = {
		type : type,
		hotel: {
			name : hotelName,
		},
		cost : cost,
		discount : discount,
		finalPrice : finalPrice,
		creditCard: {
			number : creditCardNumber
		},
		details : details,
		currencySymbol : currencySymbol
	};

	// Post the request to the server
	post(bookTripUrl, trip, bookTripSuccess, bookTripError);
}

function bookTripSuccess(response) {
	alert("bookTripSuccess");
}

function bookTripError(response) {
	alert("bookTripError");
}